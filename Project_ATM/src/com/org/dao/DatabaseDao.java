package com.org.dao;

import java.util.List;

import com.org.bean.Users;

public interface DatabaseDao {

	public Users verifyCardNumber(String cardNumber);
	public List<Users> verifyPinAndCardNumber(String cardNumber, int pinNumber);
}
