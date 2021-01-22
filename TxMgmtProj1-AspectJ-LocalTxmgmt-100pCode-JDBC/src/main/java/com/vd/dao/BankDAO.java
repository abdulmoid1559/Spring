package com.vd.dao;

public interface BankDAO {
	public Integer withdraw(Long accno,Double amt);
	public Integer deposite(Long accno,Double amt );
}
