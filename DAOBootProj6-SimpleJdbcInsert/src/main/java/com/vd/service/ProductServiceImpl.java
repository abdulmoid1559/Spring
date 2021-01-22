package com.vd.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vd.bo.ProductBO;
import com.vd.dao.ProductDAO;
import com.vd.dto.ProductDTO;

@Service("prodservice")
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDAO dao;
	@Override
	public String registerProduct(ProductDTO dto) {
		ProductBO bo=null;
		int count=0;
		
		bo=new ProductBO();
		BeanUtils.copyProperties(dto, bo);
		count=dao.insertProduct(bo);
		return count==0?"Registaration Failed":"Registration succeded";
	}

}
