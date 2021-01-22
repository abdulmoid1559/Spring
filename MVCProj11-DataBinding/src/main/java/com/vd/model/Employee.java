package com.vd.model;

import lombok.Data;

@Data
public class Employee {
	private Integer eid;
	private String ename;
	private String address;
	private Integer dept;
	private String job;
	private Double salary;
}
