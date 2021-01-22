package com.vd.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.vd.bo.ProductBO;

//@Repository("productdao")
public class ProductDAOImpl2 implements ProductDAO {
	@Autowired
	private SimpleJdbcInsert insert;
	@Override
	public int insertProduct(ProductBO bo) {
		int count=0;
		Map<String,Object> params=null;
		params=new HashMap();
		insert.setTableName("Product");
		params.put("PID", bo.getPid());
		params.put("PNAME", bo.getPname());
		params.put("QTY", bo.getQty());
		params.put("PRICE", bo.getPrice());
		count=insert.execute(params);
		return count;
	}

}
