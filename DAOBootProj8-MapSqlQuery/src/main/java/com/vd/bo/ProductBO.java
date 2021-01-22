package com.vd.bo;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductBO{
	private int pid;
	private String pname;
	private int qty;
	private float price;

}
