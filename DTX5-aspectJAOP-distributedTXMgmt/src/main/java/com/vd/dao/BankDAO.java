package com.vd.dao;

public interface BankDAO {
	public Integer withdrawMoney(Long accno,Double amt);
	public Integer depositeMoney(Long accno,Double amt);
}
