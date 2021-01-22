package com.vd.dao;

import java.util.List;

import com.vd.bo.ProductBO;

public interface ProductDAO {
	public ProductBO getProduct(int id);
	public List<ProductBO> getProductByQty(int start,int end);
	public int updateQtyByName(int qty,int id);
}
