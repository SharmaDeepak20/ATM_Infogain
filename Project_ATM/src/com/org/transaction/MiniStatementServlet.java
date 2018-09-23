package com.org.transaction;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.bean.Transaction1;
import com.org.dao.DatabaseDaoImpl;


public class MiniStatementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public MiniStatementServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		
		if(session!=null)
		{
			String cardNumber=(String)session.getAttribute("cardNumber");
			DatabaseDaoImpl dbDao=new DatabaseDaoImpl();
			List<Transaction1> transList=dbDao.miniStatement(cardNumber);
			session.setAttribute("transList", transList);
			
			try{
			File file=new File("MiniStatement"+cardNumber);
			FileOutputStream fos=new FileOutputStream(file);
			PrintWriter pw=new PrintWriter(fos);
			String line=System.getProperty("line.separator");
			for(Transaction1 trans:transList)
			{
				pw.write("AMOUNT "+trans.getAmount()+" IS "+trans.getStatus()+"ED FROM CARDNUMBER  "+trans.getCardNumber()+line);
			}
			pw.close();
			System.out.println("File created successfully "+file.getAbsolutePath());
			}
			catch(Exception e)
			{
			   e.printStackTrace();	
			}
			
			RequestDispatcher reqDis=request.getRequestDispatcher("displayStatement.jsp");
			reqDis.forward(request, response);
		}
		else
		{
			RequestDispatcher reqDis=request.getRequestDispatcher("index.jsp");
			reqDis.forward(request, response);
		}
	}
}
