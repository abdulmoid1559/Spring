package com.vd.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service("service")
public class WishServiceImpl implements WishService {

	@Override
	public String genrateWishMsg() {
		LocalDateTime time=LocalDateTime.now();
		int hour=time.getHour();
		String msg;
		if(hour<12) {
			msg="Good morning";
		}
		else if(hour<16) {
			msg="Good Afternoon";
		}
		else if(hour<20) {
			msg="Good evening";
		}
		else {
			msg="Good Night";
		}
		return msg;
	}

}
