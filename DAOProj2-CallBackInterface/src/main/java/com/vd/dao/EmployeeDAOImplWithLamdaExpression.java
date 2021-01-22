package com.vd.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.vd.bo.EmployeeBO;

import oracle.jdbc.proxy.annotation.GetDelegate;
//@Repository("empDao")
public class EmployeeDAOImplWithLamdaExpression implements EmployeeDao {
	private final String GET_EMP_BY_ID="select ENO,NAME,ADDRESS,DEPT,SALARY,DOB FROM EMPLOYEE WHERE ENO=?";
	@Autowired
	private JdbcTemplate template;

	@Override
	public EmployeeBO GetEmployeById(int eid) {
		EmployeeBO bo=null;
		
		bo=template.queryForObject(GET_EMP_BY_ID, 	( rs, index) -> {
																								EmployeeBO bo2=null;
																								
																								bo2=new EmployeeBO();
																								bo2.setEno(rs.getInt(1));
																								bo2.setName(rs.getString(2));
																								bo2.setAddress(rs.getString(3));
																								bo2.setDept(rs.getString(4));
																								bo2.setSalary(rs.getFloat(5));
																								bo2.setDOB(rs.getDate(6));
																								return bo2;
																							}, eid);
		return bo;
	}

	//@Override
	public List<EmployeeBO> getEmployeeByAddrs(String Addrs) {
		// TODO Auto-generated method stub
		return null;
	}

}
