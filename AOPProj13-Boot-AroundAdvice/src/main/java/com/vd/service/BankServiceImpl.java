package com.vd.service;

import java.lang.annotation.Target;

import org.springframework.stereotype.Component;

@Component("service")

public class BankServiceImpl implements BankService {
	public float simpleInterest(float amt,int rate,int time) {
		System.out.println("BankInterestService.simpleInterest()");
		return amt*rate*time/100.0f;
	}
	
	public float compoundInterest(float amt,int rate,int time) {
		System.out.println("BankInterestService.compoundInterest()");
		return (float) ((amt*Math.pow((1+rate/100),time)));
	}
}
