package com.example.demo.pojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {

	private String userName;
	private String userPassword;
	private int age;

	public static List<User> initList(){
		List<User> users=new ArrayList<User>();
		users.add(new User("张三", "890123", 18));
		users.add(new User("李四", "901234", 23));
		users.add(new User("王五", "012345", 14));
		users.add(new User("赵六", "123456", 30));
		users.add(new User("田七", "234567", 32));
		return users;
	}
	
	
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
