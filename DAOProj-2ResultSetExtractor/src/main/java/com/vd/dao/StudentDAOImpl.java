package com.vd.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.vd.bo.StudentBO;
@Repository("StudDao")
public class StudentDAOImpl implements StudentDAO {
	private static  final String GET_STUDENT_BY_ADDRS="SELECT SID,SNAME,ADDRESS,COURSE,FEE FROM STUDENT WHERE ADDRESS=?"; 
	@Autowired
	private JdbcTemplate template;
	@Override
	public List<StudentBO> getStudentByAddrs(String addrs) throws DataAccessException {
		List<StudentBO> listBo;
		listBo=template.query(GET_STUDENT_BY_ADDRS,
																								new ResultSetExtractor<List<StudentBO>>() {
																									@Override
																									public List<StudentBO> extractData(ResultSet rs)throws SQLException,DataAccessException {
																										List<StudentBO> listBO=null;
																										StudentBO bo=null;													
																										listBO=new ArrayList();
																										while(rs.next()) {
																											bo=new StudentBO();
																											bo.setSid(rs.getInt(1));
																											bo.setSname(rs.getString(2));
																											bo.setAddress(rs.getString(3));
																											bo.setCourse(rs.getString(4));
																											bo.setFee(rs.getFloat(5));
																											listBO.add(bo);
																											
																										}
																										return listBO;
																									}
																								},addrs);
		return listBo;
	}

}
