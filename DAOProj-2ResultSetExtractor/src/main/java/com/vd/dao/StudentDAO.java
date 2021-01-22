package com.vd.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.vd.bo.StudentBO;

public interface StudentDAO {
	public List<StudentBO> getStudentByAddrs(String addrs) throws DataAccessException;
}
