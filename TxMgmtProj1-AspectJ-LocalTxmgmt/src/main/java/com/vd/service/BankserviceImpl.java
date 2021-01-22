package com.vd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.vd.dao.BankDAO;

@Service("service")
public class BankserviceImpl implements BankService {
	@Autowired
	private BankDAO dao;
	@Override
	//@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class,timeout =10 )
	@Transactional(propagation = Propagation.REQUIRED,transactionManager = "txMgmr",rollbackForClassName = "java.lang.Exception")
	public String transferMoney(Long srcAcc, Long destAcc, Double amt) throws IllegalAccessException {
		Integer count1=0;
		Integer count2=0;
		
		count1=dao.withdraw(srcAcc, amt);
		
		/* try { Thread.sleep(15000); } catch (Exception e) { e.printStackTrace(); } */
		 
		count2=dao.deposite(destAcc, amt);
		if(count1==0||count2==0)
			throw new IllegalAccessException("Transaction failed...");
		else
		return "Money transfered successfully to "+destAcc+" amount is "+amt;
	}

}
