package com.vd.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode
public class EmployeeDTO {
	private Integer eno;
	private String name;
	private String address;
	private Double Salary;
}
