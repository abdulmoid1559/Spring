package com.vd.service;

import java.util.List;

import com.vd.dto.ProductDTO;

public interface ProductService {
	public ProductDTO getProductById(int id);
	public List<ProductDTO> getProductByQty(int start,int end);
	public String updateQtyByName(int qty,int id);
}
