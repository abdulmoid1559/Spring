package com.vd.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductDTO implements Serializable {
private int pid;
private String pname;
private int qty;
private float price;
@Override
public String toString() {
	return "ProductDTO [pid=" + pid + ", pname=" + pname + ", qty=" + qty + ", price=" + price + "]";
}
}
