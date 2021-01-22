package com.vd.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository("oraDao")
public class OraBankDAOImpl{
	private static final String WITHDRAW_MONEY="UPDATE ACCOUNT SET BALANCE=BALANCE-? WHERE ACCNO=?";
	@Autowired
	@Qualifier("orajt")
	private JdbcTemplate template;
	
	public Integer withdrawMoney(Long accno, Double amt) {
		Integer count=0;
		
		System.out.println("OraBankDAOImpl.withdrawMoney()");
		System.out.println(template.getClass());
		count=template.update(WITHDRAW_MONEY,amt,accno);
		System.out.println(count);
		return count;
	}
}
