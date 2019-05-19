package com.example.demo.pojo;

public class Manager {

	private int id;
	private String name;
	private int salary;
	private String section;
	private String location;
	private String tel;
	private String indate;
	public int getId() {
		return this.id;
	}
	@Override
	public String toString() {
		return "manager [id=" + this.id + ", name=" + this.name + ", salary=" + this.salary + ", section="
				+ this.section + ", location=" + this.location + ", tel=" + this.tel + ", indate=" + this.indate + "]";
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return this.salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getSection() {
		return this.section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getLocation() {
		return this.location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getTel() {
		return this.tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getIndate() {
		return this.indate;
	}
	public void setIndate(String indate) {
		this.indate = indate;
	}
}
