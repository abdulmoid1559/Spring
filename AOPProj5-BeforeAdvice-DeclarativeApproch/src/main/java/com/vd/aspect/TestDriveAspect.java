package com.vd.aspect;

import org.aspectj.lang.JoinPoint;

import com.vd.dto.CarDTO;

public class TestDriveAspect {
	public void check(JoinPoint point) {
		CarDTO dto=null;
		Object[] args=null;
		
		args=point.getArgs();
		dto=(CarDTO) args[0];
		if (dto.getName().equalsIgnoreCase("Honda city")) {
			System.out.println("test drive is not available for "+dto.getName());
		}
		else {
			System.out.println("Test drive is available");
		}
	}
}
