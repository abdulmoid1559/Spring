package com.vd.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("dao")
public class BankDAOImpl implements BankDAO {
	private static final String WITHDRAW_AMOUNT="UPDATE ACCOUNT SET BALANCE=BALANCE-? WHERE ACCNO=?";
	private static final String DEPOSITE_AMOUNT="UPDATE ACCOUNT SET BALANCE=BAlANCE+? WHERE ACCNO=?";
	@Autowired
	private JdbcTemplate template;

	@Override
	public Integer withdraw(Long accno, Double amt) {
		Integer count=0;
		count=template.update(WITHDRAW_AMOUNT,amt,accno);
		return count;
	}

	@Override
	public Integer deposite(Long accno, Double amt) {
		Integer count=0;
		
		count=template.update(DEPOSITE_AMOUNT,amt,accno);
		
		return count;
	}

}
