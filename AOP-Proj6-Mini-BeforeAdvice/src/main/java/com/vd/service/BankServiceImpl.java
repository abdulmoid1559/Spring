package com.vd.service;

import com.vd.dao.BankDAO;

public class BankServiceImpl implements BankService {
	private BankDAO dao;

	public BankServiceImpl(BankDAO dao) {
		this.dao = dao;
	}

	@Override
	public String depositeMoney(int accno, float amt) {
		return dao.deposite(accno, amt);
	}

	@Override
	public String withdrawMoney(int accno, float amt) {
		return dao.withdraw(accno, amt);
	}

}
