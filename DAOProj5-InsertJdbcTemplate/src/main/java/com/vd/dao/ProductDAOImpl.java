package com.vd.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.vd.bo.ProductBO;

//@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO {
	@Autowired
	private SimpleJdbcInsert insert;
	@Override
	public int insertProduct(ProductBO bo) {
		int count =0;
		MapSqlParameterSource source=null;
		
		source=new MapSqlParameterSource();
		insert.setTableName("Product");
		source.addValue("pid", bo.getPid());
		source.addValue("pname", bo.getPname());
		source.addValue("qty", bo.getQty());
		source.addValue("price", bo.getPrice());
		count=insert.execute(source);
		return count;
	}

}
