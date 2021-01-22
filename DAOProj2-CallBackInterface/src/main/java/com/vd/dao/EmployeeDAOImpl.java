package com.vd.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.vd.bo.EmployeeBO;
//@Repository("empDao")
public class EmployeeDAOImpl implements EmployeeDao {
	private final String GET_EMP_BY_ID="select ENO,NAME,ADDRESS,DEPT,SALARY,DOB FROM EMPLOYEE WHERE ENO=?";
	private final String GET_EMP_BY_ADDRESS="select ENO,NAME,DEPT,SALARY,DOB FROM EMPLOYEE WHERE Address=?";
	@Autowired
	private JdbcTemplate template;

	@Override
	public EmployeeBO GetEmployeById(int eid) {
		EmployeeBO bo=null;
		
		bo=template.queryForObject(GET_EMP_BY_ID, new RowMapper<EmployeeBO>(){

																							@Override
																							public EmployeeBO mapRow(ResultSet rs, int index) throws SQLException {
																								EmployeeBO bo2=null;
																								
																								bo2=new EmployeeBO();
																								bo2.setEno(rs.getInt(1));
																								bo2.setName(rs.getString(2));
																								bo2.setAddress(rs.getString(3));
																								bo2.setDept(rs.getString(4));
																								bo2.setSalary(rs.getFloat(5));
																								bo2.setDOB(rs.getDate(6));
																								return bo2;
																							}
																							}, eid);
		return bo;
	}

	/*
	 * @Override public List<EmployeeBO> getEmployeeByAddrs(String Addrs) {
	 * List<EmployeeBO> listbo=null;
	 * System.out.println("EmployeeDAOImpl.getEmployeeByAddrs()");
	 * listbo=template.query(GET_EMP_BY_ADDRESS, new
	 * ResultSetExtractor<List<EmployeeBO>>() {
	 * 
	 * @Override public List<EmployeeBO> extractData(ResultSet rs) throws
	 * SQLException, DataAccessException { List<EmployeeBO> listBO=null; listBO=new
	 * ArrayList(); while(rs.next()) { EmployeeBO bo=new EmployeeBO();
	 * bo.setEno(rs.getInt(1)); bo.setName(rs.getString(2));
	 * bo.setDept(rs.getString(3)); bo.setSalary(rs.getFloat(4));
	 * bo.setDOB(rs.getDate(5)); listBO.add(bo); } return listBO; }},Addrs); return
	 * listbo; }
	 */

}
