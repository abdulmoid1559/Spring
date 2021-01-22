package com.vd.model;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import lombok.Data;


@Data
public class User implements Serializable {
	private Integer uid;
	@NotBlank
	@Size(max=30, min=3)
	private String name;
	@NotBlank
	@Size(max=50, min=3)
	private String address;
	@NumberFormat(style = Style.NUMBER)
	@Size(max=10,min=10)
	@NotBlank
	private Long contactNo;
	@NotBlank
	private String username;
	@NotBlank
	@Size(min=8, max=20)
	private String password;
}
