package com.vd.dao;

public interface BankDAO {
	public String deposite(int accno,float amt);
	public String withdraw(int accno,float amt);
}
