package com.vd.dao;

import java.util.List;

import com.vd.bo.EmployeeBO;

public interface EmployeeDao {
	public EmployeeBO GetEmployeById(int eid);
	//public List<EmployeeBO> getEmployeeByAddrs(String Addrs);
}
