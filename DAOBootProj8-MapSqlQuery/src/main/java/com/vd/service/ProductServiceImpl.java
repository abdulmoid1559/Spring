package com.vd.service;

import java.util.ArrayList;
import java.util.List;

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
	public ProductDTO getProductById(int id) {
		ProductBO bo=null;
		ProductDTO dto=null;
		
		bo=dao.getProduct(id);
		dto=new ProductDTO();
		BeanUtils.copyProperties(bo, dto);
		return dto;
	}

	@Override
	public List<ProductDTO> getProductByQty(int start, int end) {
		List<ProductDTO> listDTO;
		List<ProductBO> listBO=null;
		
		listBO=dao.getProductByQty(start, end);
		listDTO=new ArrayList();
		listBO.forEach(bo->{
			ProductDTO DTO=new ProductDTO();
			BeanUtils.copyProperties(bo, DTO);
			listDTO.add(DTO);
		});
		return listDTO;
	}

	@Override
	public String updateQtyByName(int qty, int id) {
		int count=0;
		
		count=dao.updateQtyByName(qty, id);
		return count==0?"Quantity is not update":"Quantity is update"+count;
	}
	

}
