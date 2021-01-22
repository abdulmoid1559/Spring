package com.vd.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.vd.bo.AccountBO;
@Repository

public class AuthenticationDAO {
	private static final String VALIDATE_QUERY="SELECT COUNT(*) FROM USERS WHERE USERNAME=? AND PASSWORD=?";
	@Autowired
	private JdbcTemplate template;
	public boolean validate(AccountBO bo) {
		int count=0;
		
		count=template.queryForObject(VALIDATE_QUERY, Integer.class, bo.getUserName(),bo.getPassword());
		return count==0?false:true;
	}
}
