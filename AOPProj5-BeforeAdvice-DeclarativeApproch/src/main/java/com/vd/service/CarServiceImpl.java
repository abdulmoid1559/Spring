package com.vd.service;

import com.vd.dto.CarDTO;

public class CarServiceImpl implements CarService {

	@Override
	public void purchaseCar(CarDTO dto) {
		float totalAmt=0.0f,tax;
		
		tax=dto.getPrice()*dto.getGstRate()/100;
		totalAmt=dto.getPrice()+tax;
		System.out.println("Car name::"+dto.getModelNo());
		System.out.println("Model number::"+dto.getName());
		System.out.println("Price::"+dto.getPrice());
		System.out.println("Total amount::"+totalAmt);
	}

}
