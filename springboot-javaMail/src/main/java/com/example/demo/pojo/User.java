package com.example.demo.pojo;

public class User {

	private String userName;
	private String sex;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public User(String userName, String sex) {
		super();
		this.userName = userName;
		this.sex = sex;
	}
	public User() {
		super();
	}
	
	
}
