package com.vd.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	@Autowired
	JdbcTemplate template=null;
	@Override
	public List<Map<String, Object>> GetEmployeeByJob(String desg) {
		List<Map<String,Object>> listMap=null;
		//use Template object for calling method
		listMap=template.queryForList("select ENO,NAME,ADDRESS,DEPT,SALARY,DOB from Employee WHERE DEPT IN "+desg+" ORDER BY ENO",new Object[] {});
		return listMap;
	}

}
