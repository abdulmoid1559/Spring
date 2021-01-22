package com.vd.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.vd.dto.ProductDTO;

public class ECommerceStoreServiceImpl implements ECommerceStoreService  {
	private List<ProductDTO> cart=new ArrayList();
	
	public void addItemToCart(ProductDTO dto) {
		System.out.println("ECommerceStoreServiceImpl.addItemToCart()");
		cart.add(dto);
		System.out.println(dto.getPname()+" added to cart ");
	}

	
	public float totalBillAmt(int discount) {
		float billAmt=0.0f;
		float fAmt=0.0f;
		
		billAmt=(float)cart.stream().mapToDouble(dto->
			dto.getPrice()*dto.getQty()).sum();
			fAmt=(float) (billAmt-(billAmt*(discount/100.0)));
		return fAmt;
	}

	
	public void showCartItem() {
		cart.forEach(System.out::println);
	}

}
