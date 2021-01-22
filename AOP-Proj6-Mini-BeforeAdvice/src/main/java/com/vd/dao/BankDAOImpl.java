package com.vd.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class BankDAOImpl implements BankDAO{
	private static final String DEPOSITE_QUERY="UPDATE ACCOUNT SET balance=balance+? WHERE accno=? ";
	private static final String WITHDRAW_QUERY="UPDATE ACCOUNT SET balance=balance+? WHERE accno=?";
	private JdbcTemplate template;

	public BankDAOImpl(JdbcTemplate template) {
		this.template = template;
	}

	
	  @Override 
	  public String deposite(int accno,float amt) { 
		  int count=0;
		  count=template.queryForObject(DEPOSITE_QUERY, Integer.class, amt,accno);
		  return count==0?"Transaction Failed": "money deposited in"+accno;
	  }
	 
	@Override
    public String withdraw(int accno,float amt) {
    	int count=0;
    	
    	count=template.queryForObject(WITHDRAW_QUERY, Integer.class, amt,accno);
    	return count==0?"Transaction Failed": "money withdrawn from"+accno;
    }
}
