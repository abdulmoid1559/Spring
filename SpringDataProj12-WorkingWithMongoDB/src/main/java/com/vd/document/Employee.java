package com.vd.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Document
@Data
@EqualsAndHashCode
public class Employee {
	@Id
	private Integer eno;
	private String name;
	private String address;
	private Double Salary;
}
