package com.vd.service;

import com.vd.dto.ProductDTO;

public interface ECommerceStoreService {
	public void addItemToCart(ProductDTO dto);
	public float totalBillAmt(int discount);
	public void showCartItem();
}
