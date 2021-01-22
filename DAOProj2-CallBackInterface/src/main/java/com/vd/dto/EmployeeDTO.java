package com.vd.dto;

import java.io.Serializable;
import java.sql.Date;

import lombok.Getter;
import lombok.Setter;


public class EmployeeDTO implements Serializable {
	private int eno;
	private String name;
	private String address;
	private String dept;
	private float salary;
	private Date DOB;
	
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public Date getDOB() {
		return DOB;
	}
	public void setDOB(Date dOB) {
		DOB = dOB;
	}
	@Override
	public String toString() {
		return "EmployeeDTO [eno=" + eno + ", name=" + name + ", address=" + address + ", dept=" + dept + ", salary="
				+ salary + ", DOB=" + DOB + "]";
	}

}
