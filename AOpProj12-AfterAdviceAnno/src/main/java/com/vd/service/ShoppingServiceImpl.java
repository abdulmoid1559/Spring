package com.vd.service;

import java.util.stream.DoubleStream;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service(value = "service")
public class ShoppingServiceImpl implements ShoppingService {
	
	@Override
	public double shopping(String[] itemsName, double[] prices) {
		double totalAmt=0.0;
		totalAmt=DoubleStream.of(prices).sum();
		return totalAmt;
	}

}
