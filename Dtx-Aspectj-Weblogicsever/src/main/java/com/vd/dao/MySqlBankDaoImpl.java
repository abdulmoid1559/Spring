package com.vd.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository("mysqldao")
public class MySqlBankDaoImpl {
private static final String DEPOSITE_QUERY="UPDATE ACCOUNT SET BALANCE=BALANCE+? WHERE ACCNO=?";
	@Autowired
	@Qualifier("mysqlJT")
	private JdbcTemplate template;

		public Integer depositeMoney(Long accno, Double amt) {
		Integer count=0;
		
		count=template.update(DEPOSITE_QUERY,amt,accno);
		System.out.println("MySqlBankDaoImpl.depositeMoney()");
		return count;
	}

}
