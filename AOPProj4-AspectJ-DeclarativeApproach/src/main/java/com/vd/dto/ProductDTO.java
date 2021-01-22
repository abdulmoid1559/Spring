package com.vd.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class ProductDTO implements Serializable {
	private int pid;
	private String pname;
	private double price;
	private int qty;
	public ProductDTO(int pid, String pname, double price, int qty) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.price = price;
		this.qty = qty;
	}
	public ProductDTO() {
		System.out.println("ProductDTO.ProductDTO()");
	}
}
