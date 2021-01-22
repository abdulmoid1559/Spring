package com.vd.service;

public interface BankService {
	public float simpleInterest(float amt,int rate,int time);
	public float compoundInterest(float amt,int rate,int time);
}
