package com.org.bean;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class ChequeBook{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int accountId;
	private Date date;
	private String cardNumber;
	private String status;
	
	public ChequeBook() {
		// TODO Auto-generated constructor stub
	}

	

	
	public ChequeBook(Date date, String cardNumber, String status) {
		super();
		this.date = date;
		this.cardNumber = cardNumber;
		this.status = status;
	}




	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	public int getAccountId() {
		return accountId;
	}


	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "ChequeBook [accountId=" + accountId + ", date=" + date + ", cardNumber=" + cardNumber + ", status="
				+ status + "]";
	}
}
