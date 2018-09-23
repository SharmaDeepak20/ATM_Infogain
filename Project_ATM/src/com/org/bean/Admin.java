package com.org.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Admin {

	@Id
	private String adminid;
	private String name;
	private String password;
	
	public Admin() {
		// TODO Auto-generated constructor stub
	}

	public Admin(String adminid, String name, String password) {
		super();
		this.adminid = adminid;
		this.name = name;
		this.password = password;
	}

	public String getAdminid() {
		return adminid;
	}

	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [adminid=" + adminid + ", name=" + name + ", password=" + password + "]";
	}
}
