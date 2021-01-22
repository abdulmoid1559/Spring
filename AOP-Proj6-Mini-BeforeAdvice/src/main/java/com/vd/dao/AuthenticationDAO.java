package com.vd.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.vd.bo.AccountBO;

public class AuthenticationDAO {
	private static final String VALIDATE_QUERY="SELECT COUNT(*) FROM USERS WHERE USERNAME=? AND PASSWORD=?";
	private JdbcTemplate template;

	public AuthenticationDAO(JdbcTemplate template) {
		this.template = template;
	}
	public boolean validate(AccountBO bo) {
		int count=0;
		
		count=template.queryForObject(VALIDATE_QUERY, Integer.class, bo.getUserName(),bo.getPassword());
		return count==0?false:true;
	}
}
