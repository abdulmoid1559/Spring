package com.vd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vd.dao.BankDAO;

@Service("bService")
public class BankServiceImpl implements BankService {
	@Autowired
	private BankDAO dao;

	
	@Override
	public String depositeMoney(int accno, float amt) {
		System.out.println("BankServiceImpl.depositeMoney()");
		return dao.deposite(accno, amt);
	}

	@Override
	public String withdrawMoney(int accno, float amt) {
		return dao.withdraw(accno, amt);
	}

}
