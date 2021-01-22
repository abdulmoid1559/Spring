package com.vd.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class BankDAOImpl implements BankDAO{
	private static final String DEPOSITE_QUERY="UPDATE ACCOUNT SET BALANCE=BALANCE+? WHERE ACCNO=? ";
	private static final String WITHDRAW_QUERY="UPDATE ACCOUNT SET BALANCE=BALANCE+? WHERE ACCNO=?";
	@Autowired
	private JdbcTemplate template;

	

	
	  @Override 
	  public String deposite(int accno,float amt) { 
		  int count=0;
		  System.out.println("BankDAOImpl.deposite()");
		  count=template.update(DEPOSITE_QUERY, amt,accno);
		  return count==0?"Transaction Failed": "money deposited in"+accno;
	  }
	 
	@Override
    public String withdraw(int accno,float amt) {
    	int count=0;
    	System.out.println("BankDAOImpl.withdraw()");
    	count=template.update(WITHDRAW_QUERY, amt,accno);
    	System.out.println("After update");
    	return count==0?"Transaction Failed": "money withdrawn from"+accno;
    }
}
