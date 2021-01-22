package com.vd.service;

import java.util.Calendar;

public class WishMessageServiceImpl implements WishMessageService {

	@Override
	public String GenerateWishMessage() {
		var hour=0;
		var msg=new String();
		var calendor=Calendar.getInstance();
		
		hour=Calendar.HOUR_OF_DAY;
		if(hour<12)
			return "Good Morning";
		else if(hour<16)
			return "Good afternoon";
		else if(hour<20)
			return "Good Evening";
		else
			return "Good night";
	}

}
