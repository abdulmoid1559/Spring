package com.vd.service;

import java.util.stream.DoubleStream;

import org.springframework.stereotype.Component;

@Component("store")
public class ShoppingStoreImpl implements ShoppingStore {

	@Override
	public double shopping(String item, double prices) {
		double billAmt=0.0;
		
		if(item==null||prices==0) {
			throw new IllegalArgumentException("Prices and items must not be empty");
		}
		else {
			billAmt=DoubleStream.of(prices).sum();
		}
		return billAmt;
	}

	

}
