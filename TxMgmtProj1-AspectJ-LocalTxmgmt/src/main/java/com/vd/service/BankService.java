package com.vd.service;

public interface BankService {

	public String transferMoney(Long srcAcc, Long destAcc, Double amt) throws IllegalAccessException;
}
