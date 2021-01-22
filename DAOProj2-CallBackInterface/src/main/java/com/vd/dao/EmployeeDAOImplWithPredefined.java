package com.vd.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.vd.bo.EmployeeBO;

import oracle.jdbc.proxy.annotation.GetDelegate;
@Repository("empDao")
public class EmployeeDAOImplWithPredefined implements EmployeeDao {
	private final String GET_EMP_BY_ID="select ENO,NAME,ADDRESS,DEPT,SALARY,DOB FROM EMPLOYEE WHERE ENO=?";
	private final String GET_EMP_BY_ADDRS="select ENO,NAME,ADDRESS,DEPT,SALARY,DOB FROM EMPLOYEE WHERE ADDRESS=?";
	
	@Autowired
	private JdbcTemplate template;

	@Override
	public EmployeeBO GetEmployeById(int eid) {
		EmployeeBO bo=null;
		
		bo=template.queryForObject(GET_EMP_BY_ID,new BeanPropertyRowMapper<EmployeeBO>(EmployeeBO.class), eid);
		return bo;
	}

	/*
	 * @Override public List<EmployeeBO> getEmployeeByAddrs(String addrs) {
	 * List<EmployeeBO> listBO=null; listBO=template.query(GET_EMP_BY_ADDRS,new
	 * RowMapperResultSetExtractor<EmployeeBO>(new
	 * BeanPropertyRowMapper<EmployeeBO>(EmployeeBO.class)),addrs);
	 * 
	 * return listBO; }
	 */
}
