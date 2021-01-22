package com.vd.aspect;

import org.aspectj.lang.JoinPoint;

import com.vd.utility.AuthenticationManager;

public class SecurityCheckAspect {
	private AuthenticationManager manager;

	public SecurityCheckAspect(AuthenticationManager manager) {
		this.manager = manager;
	}
	
	public void check(JoinPoint point) {
		if(!manager.isAuthencate())
			throw new IllegalAccessError("Please enter valid credentials");
	}
}
