package com.org.dao;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.joda.time.Days;

import com.org.bean.Admin;
import com.org.bean.ChequeBook;
import com.org.bean.Transaction1;
import com.org.bean.Users;

public class DatabaseDaoImpl implements DatabaseDao{

	Session session;
	public DatabaseDaoImpl() {
		Configuration cfg=new AnnotationConfiguration();
		SessionFactory factory=cfg.configure().buildSessionFactory();
		session=factory.openSession();
	}
	
	public Users verifyCardNumber(String cardNumber)
	{
		Transaction t=session.beginTransaction();
		Users users=(Users)session.get(Users.class, cardNumber);
		t.commit();
		
		return users;
	}//end verifyCardNumber
	
	public List<Users> verifyPinAndCardNumber(String cardNumber, int pinNumber)
	{
		Transaction t=session.beginTransaction();
		Query query=session.createQuery("FROM Users WHERE accountNo=? AND pinNo=?");
		query.setString(0, cardNumber);
		query.setInteger(1, pinNumber);
		
		List<Users> userList=query.list();
		t.commit();
		
		return userList;
	}//end verifyPinAndCardNumber
	
	public List<Admin> loginAdmin(Admin admin)
	{
		Transaction t=session.beginTransaction();
		Query query=session.createQuery("FROM Admin WHERE adminid=? AND password=?");
		query.setString(0, admin.getAdminid().toUpperCase());
		query.setString(1, admin.getPassword());
		
		List<Admin> adminList=query.list();
		
		return adminList;
	}//end loginAdmin
	
	public void totalUserCount()
	{
		Transaction t=session.beginTransaction();
		Query query=session.createQuery("SELECT count(*) FROM Users");
	}//end totalUserCount
	
	public void depositMoney(String cardNumber,double amount)
	{
		
		Date date1=dateConversion();
		
		Transaction1 trans1=new Transaction1(date1,cardNumber, amount, "CREDIT");
		Transaction t=session.beginTransaction();
		session.save(trans1);
		
		Users users=(Users)session.get(Users.class, cardNumber);
		users.setBalance(users.getBalance()+amount);
		session.update(users);
		t.commit();
	}//end depositMoney
	
	public boolean chequeBookRequest(String cardNumber)
	{
		updateChequeBookStatus(cardNumber);
		if(checkBookData(cardNumber))
		{
			Date date1=dateConversion();
			ChequeBook checkBook=new ChequeBook(date1, cardNumber ,"PROGRESS");
			Transaction t=session.beginTransaction();
			session.save(checkBook);
			t.commit();
			return true;
		}
		else
		{
			return false;
		}
		
		
	}//end chequeBookRequest
	
	public boolean checkBookData(String cardNumber)
	{		
		Transaction t=session.beginTransaction();
		Query query=session.createQuery("FROM ChequeBook WHERE cardNumber=?");
		query.setString(0, cardNumber);
		List<ChequeBook> chequeBook=query.list();
		t.commit();
		int count=0;
		for(ChequeBook c:chequeBook){
			String status=c.getStatus();
		    if(status.equalsIgnoreCase("progress"))
		    {
			   count=1;
		    }
		 }//end forEach
		
		if(count==1)
		{
			return false;
		}
		else
		{
			return true;
		}
	}//end checkBookData
	
	public void updateChequeBookStatus(String cardNumber)
	{
		Transaction t=session.beginTransaction();
		Query query=session.createQuery("FROM ChequeBook WHERE cardNumber=?");
		query.setString(0, cardNumber);
		List<ChequeBook> list=query.list();
		
		//ChequeBook chequeBook=(ChequeBook)session.get(ChequeBook.class, cardNumber);
		for(ChequeBook chequeBook:list){
		if(chequeBook==null)
		{
		}
		else
		{
			Date date=dateConversion();
			if((daysBetween(date, chequeBook.getDate()))>=7)
			{
				chequeBook.setStatus("DONE");
				session.update(chequeBook);
			}
			else
			{
				System.out.println("Request is under process");
			}
			t.commit();
		}}
	}//end updateChequeBookStatus
	
	public boolean withdrawalMoney(String cardNumber,double amount)
	{
		double amount1=checkBalance(cardNumber);
		if(amount>amount1)
		{
			return false;
		}
		else
		{
			Date date=dateConversion();
			Transaction t=session.beginTransaction();
			session.save(new Transaction1(date,cardNumber, amount, "DEBIT"));
			Query query=session.createQuery("UPDATE Users SET balance=balance-? WHERE accountNo=?");
			query.setDouble(0, amount);
			query.setString(1, cardNumber);
			query.executeUpdate();
			t.commit();
			return true;
		}
	}//end withdrawalMoney
	
	public double checkBalance(String cardNumber)
	{
		Transaction t=session.beginTransaction();
		Query query=session.createQuery("SELECT balance FROM Users WHERE accountNo=?");
		query.setString(0, cardNumber);
		List<Double> amountList=query.list();
		t.commit();
		
		return amountList.get(0);
	}//end checkBalance
	
	public List<Transaction1> miniStatement(String cardNumber)
	{
	    int count=0;
	    List<Transaction1> transList1=new ArrayList<Transaction1>();
	    Transaction t=session.beginTransaction();
	    Query query=session.createQuery("FROM Transaction1 WHERE cardNumber=? ORDER BY date DESC");
	    query.setString(0, cardNumber);
	    List<Transaction1> transList=query.list();
	    t.commit();
	    
	    for(Transaction1 trans:transList)
	    {
	    	if(count<5)
	    	{
	    		transList1.add(trans);
	    		count++;
	    	}
	    	else
	    	{
	    		break;
	    	}
	    }//end forEach
	    
	    return transList1;
	}//end miniStatement
	
	public double currentBalance(String cardNumber)
	{
		Transaction t=session.beginTransaction();
		Users users=(Users)session.get(Users.class, cardNumber);
		t.commit();
		return users.getBalance();
	}//end currentBalance
	
	public void pinChange(int newPin, String cardNumber)
	{
		Transaction t=session.beginTransaction();
		Users users=(Users)session.get(Users.class, cardNumber);
		users.setPinNo(newPin);
		t.commit();
	}//end pinChange
	
	public void changePhoneNumber(String cardNumber, String number)
	{
		Transaction t=session.beginTransaction();
		Users users=(Users)session.get(Users.class, cardNumber);
		users.setPhoneNumber(number);
		session.update(users);
		t.commit();
	}//end changePhoneNumber
	
	public List<Users> showAllUsers()
	{
		Transaction t=session.beginTransaction();
		List<Users> usersList=session.createQuery("FROM Users").list();
		t.commit();
		return usersList;
	}//end showAllUsers
	
	public void insertUser(Users users)
	{
		users.setBalance(0.0);
		users.setStatus("OPEN");
		Transaction t=session.beginTransaction();
		session.save(users);
		t.commit();
	}//end insertUser
	
	public List<Transaction1> depositReport()
	{
		Date date=dateConversion();
		Transaction t=session.beginTransaction();
		Query query=session.createQuery("FROM Transaction1 WHERE status=? AND date=?");
		query.setString(0, "CREDIT");
		query.setDate(1, date);
		List<Transaction1> transList=query.list();
		t.commit();
		
		return transList;
	}//end depositReport
	
	public List<Transaction1> withdrawalReport()
	{
		Date date=dateConversion();
		Transaction t=session.beginTransaction();
		Query query=session.createQuery("FROM Transaction1 WHERE status=? AND date=?");
		query.setString(0, "DEBIT");
		query.setDate(1, date);
		List<Transaction1> transList=query.list();
		t.commit();
		
		return transList;
	}//end withdrawalReport
	
	public List<Transaction1> transactionReport()
	{
		Date date=dateConversion();
		Transaction t=session.beginTransaction();
		Query query=session.createQuery("FROM Transaction1 WHERE date=?");
		query.setDate(0, date);
		List<Transaction1> transList=query.list();
		t.commit();
		
		return transList;
	}//end transactionReport
	
	public Date dateConversion()
	{
		LocalDateTime currentTime=LocalDateTime.now();
		LocalDate date=currentTime.toLocalDate();
		Date date1=Date.valueOf(date);
		return date1;
	}//end dateConversion
	
	public static int daysBetween(Date d1, Date d2)
	{ 
		return Days.daysBetween( new org.joda.time.LocalDate(d1.getTime()), new org.joda.time.LocalDate(d2.getTime())).getDays(); 
	}//end daysBetween
}//end class
