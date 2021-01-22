package com.vd.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class CustomerDTO implements Serializable{
	private Integer cid;
	private String name;
	private String address;
	private Long contactNo;
}
