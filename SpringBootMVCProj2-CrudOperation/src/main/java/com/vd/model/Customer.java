package com.vd.model;





import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import lombok.Data;

@Data
public class Customer{
	private Integer cid;
	@NotBlank
	@NotEmpty
	@Size(max=30, min=3)
	private String name;
	@NotBlank
	@NotEmpty
	@Size(max=50, min=3)
	private String address;
	@Size(max=10,min=10)
	@NotBlank
	private Long contactNo;
}
