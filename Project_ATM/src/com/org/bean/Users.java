package com.org.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Users {

	private String username;
	
	@Id
	private String accountNo;
	private int pinNo;
	private String gender;
	private String address;
	private String phoneNumber;
	private double balance;
	private String status;
	
	public Users() {
		// TODO Auto-generated constructor stub
	}

	public Users(String username, String accountNo, int pinNo, String gender, String address, String phoneNumber,
			double balance, String status) {
		super();
		this.username = username;
		this.accountNo = accountNo;
		this.pinNo = pinNo;
		this.gender = gender;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.balance = balance;
		this.status = status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public int getPinNo() {
		return pinNo;
	}

	public void setPinNo(int pinNo) {
		this.pinNo = pinNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Users [username=" + username + ", accountNo=" + accountNo + ", pinNo=" + pinNo + ", gender=" + gender
				+ ", address=" + address + ", phoneNumber=" + phoneNumber + ", balance=" + balance + ", status="
				+ status + "]";
	}
}
