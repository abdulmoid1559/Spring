package com.vd.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class User implements Serializable {
	private String username;
	private String password; 
}
