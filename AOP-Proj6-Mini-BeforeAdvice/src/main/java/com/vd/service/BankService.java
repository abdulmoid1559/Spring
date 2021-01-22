package com.vd.service;

import com.vd.dto.AccountDTO;

public interface BankService {
	public String depositeMoney(int accno,float amt);
	public String withdrawMoney(int accno,float amt);
}
