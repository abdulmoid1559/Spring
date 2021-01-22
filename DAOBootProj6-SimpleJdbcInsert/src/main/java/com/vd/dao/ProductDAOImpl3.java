package com.vd.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.vd.bo.ProductBO;

@Repository("productdao")
public class ProductDAOImpl3 implements ProductDAO {
	@Autowired
	private SimpleJdbcInsert insert;
	@Override
	public int insertProduct(ProductBO bo) {
		int count=0;
		BeanPropertySqlParameterSource source=new BeanPropertySqlParameterSource(bo);
		insert.setTableName("product");
		count=insert.execute(source);
		return count;
	}

}
