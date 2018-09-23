package com.org.bean;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Transaction1{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int accountId;
	private Date date;
	private String cardNumber;
	private double amount;
	private String status;
	
	public Transaction1() {
		// TODO Auto-generated constructor stub
	}
	
	public Transaction1(Date date, String cardNumber, double amount, String status) {
		super();
		this.date = date;
		this.cardNumber = cardNumber;
		this.amount = amount;
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

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Transaction1 [accountId=" + accountId + ", date=" + date + ", cardNumber=" + cardNumber + ", amount="
				+ amount + ", status=" + status + "]";
	}
}
