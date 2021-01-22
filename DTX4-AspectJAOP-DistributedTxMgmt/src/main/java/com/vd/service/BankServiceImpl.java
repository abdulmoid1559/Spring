package com.vd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.vd.dao.BankDAO;
import com.vd.dao.MySqlBankDaoImpl;
import com.vd.dao.OraBankDAOImpl;

@Service("service")
public class BankServiceImpl implements BankService {
	@Autowired
	private MySqlBankDaoImpl dao1;
	@Autowired
	private OraBankDAOImpl dao2;
	@Override
	@Transactional(propagation = Propagation.REQUIRED,transactionManager = "jta")
	public String moneyTransfer(Long srcAcc, Long destAcc, Double amt) {
		int count1=0,count2=0;
		
		count1=dao2.withdrawMoney(srcAcc, amt);
		count2=dao1.depositeMoney(destAcc, amt);
		if(count1==0||count2==0) {
			throw new IllegalArgumentException("Transaction failed............");
		}
		return "transaction successfull money tranfer into "+destAcc; 
	}

}
