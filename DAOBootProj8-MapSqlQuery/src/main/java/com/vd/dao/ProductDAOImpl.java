package com.vd.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.asm.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.jdbc.object.SqlUpdate;
import org.springframework.jdbc.object.UpdatableSqlQuery;
import org.springframework.stereotype.Repository;

import com.vd.bo.ProductBO;

@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO {
	private static final String GET_PRODUCT_BY_ID="SELECT PID,PNAME,QTY,PRICE FROM PRODUCT WHERE PID=? ";
	private static final String GET_PRODUCT_BY_QTY="SELECT PID,PNAME,QTY,PRICE FROM PRODUCT WHERE QTY BETWEEN ? AND ? ";
	private static final String UPDATE_QTY_BY_NAME="UPDATE PRODUCT SET QTY=QTY+? WHERE PID=? ";
	
	private Selection s1=null;
	private Selection2 s2=null;
	private Selection3 s3=null;
	private DataSource ds=null;
	@Autowired
	public ProductDAOImpl(DataSource ds) {
		this.ds=ds;
		s1=new Selection(ds, GET_PRODUCT_BY_ID);
		s2=new Selection2(ds, GET_PRODUCT_BY_QTY);
		s3=new Selection3(ds, UPDATE_QTY_BY_NAME);
	}
	@Override
	public ProductBO getProduct(int id) {
		ProductBO bo=null;
		bo=s1.findObject(id);
		return bo;
	}
	
	@Override
	public List<ProductBO> getProductByQty(int start, int end) {
		List<ProductBO> listbo=null;
		
		listbo=s2.execute(start,end);
		return listbo;
	}
	
	
@Override
public int updateQtyByName(int qty, int id) {
	int count=0;
	count=s3.update(qty,id);
	return count;
}
	
	//..............................................................................................................................................................
	
	private static class Selection extends MappingSqlQuery<ProductBO>{
				
		public Selection(DataSource ds,String sql) {
			super(ds,sql);
			super.declareParameter(new SqlParameter(Type.INT));
			super.compile();
		}

		@Override
		protected ProductBO mapRow(ResultSet rs, int index) throws SQLException {
			ProductBO bo=null;
			
			bo=new ProductBO();
			System.out.println("ProductDAOImpl.Selection.mapRow()");
			System.out.println("index number ::"+index);
			bo.setPid(rs.getInt(1));
			bo.setPname(rs.getString(2));
			bo.setPrice(rs.getFloat(3));
			bo.setQty(rs.getInt(4));
			return bo;
		}//Maprow
		
	}//inner class

	

	private static class Selection2 extends MappingSqlQuery<ProductBO>{
		
		public Selection2(DataSource ds,String sql) {
			super(ds, sql);
			super.declareParameter(new SqlParameter(Type.INT));
			super.declareParameter(new SqlParameter(Type.INT));
			super.compile();
		}

		@Override
		protected ProductBO mapRow(ResultSet rs, int arg1) throws SQLException {
ProductBO bo=null;
			
			bo=new ProductBO();
			System.out.println("ProductDAOImpl.Selection2.mapRow()");
			bo.setPid(rs.getInt(1));
			bo.setPname(rs.getString(2));
			bo.setPrice(rs.getFloat(4));
			bo.setQty(rs.getInt(3));
			return bo;
		}//map row		
	}//inner class
	
	private static class Selection3 extends SqlUpdate{
		public Selection3(DataSource ds,String sql) {
			super(ds,sql);
			super.declareParameter(new SqlParameter(Type.INT));
			super.declareParameter(new SqlParameter(Type.INT));
			super.compile();
		}
		
	}
}
