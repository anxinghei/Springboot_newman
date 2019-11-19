package com.example.demo.pojo;

public class User {

	private String userName;
	private String userPassword;
	private int age;

	public User() {
		super();
	}

	public User(String userName, String userPassword, int age) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.age = age;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", userPassword=" + userPassword + ", age=" + age + "]";
	}
	
}
