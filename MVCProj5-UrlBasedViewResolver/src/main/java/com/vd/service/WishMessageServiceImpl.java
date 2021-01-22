package com.vd.service;

import java.util.Calendar;

public class WishMessageServiceImpl implements WishMessageService {

	@Override
	public String GenerateWishMessage() {
		int hour=0;
		String msg=new String();
		Calendar calendor=Calendar.getInstance();
		
		hour=Calendar.HOUR_OF_DAY;
		if(hour>12)
			return "Good Morning";
		else if(hour>16)
			return "Good afternoon";
		else if(hour>20)
			return "Good Evening";
		else
			return "Good night";
	}

}
