package com.vd.dto;

import java.io.Serializable;

import lombok.Data;


@Data
public class UserDTO implements Serializable {
	private Integer uid;
	private String name;
	private String address;
	private Long contactNo;
	private String username;
	private String password;
}
