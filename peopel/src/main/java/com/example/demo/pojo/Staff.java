package com.example.demo.pojo;

public class Staff {
    private Integer id;

    private String name;

    private Integer salary;

    private Integer section;

    private String location;

    private String tel;

    private String indate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getSection() {
        return section;
    }

    public void setSection(Integer section) {
        this.section = section;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getIndate() {
        return indate;
    }

    public void setIndate(String indate) {
        this.indate = indate == null ? null : indate.trim();
    }

	@Override
	public String toString() {
		return "Staff [id=" + this.id + ", name=" + this.name + ", salary=" + this.salary + ", section=" + this.section
				+ ", location=" + this.location + ", tel=" + this.tel + ", indate=" + this.indate + "]";
	}
}