package com.vd.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vd.utility.AuthenticationManager;
@Component
@Aspect
public class SecurityCheckAspect {
	@Autowired
	private AuthenticationManager manager;

	@Before(value = "execution(java.lang.String com.vd.service.BankServiceImpl.depositeMoney(..)",argNames = "accno,amt")
	public void check(JoinPoint point) {
		boolean flag;
		System.out.println("In Aspect class");
		flag=manager.isAuthencate();
		if(!flag)
			throw new IllegalAccessError("Please enter valid credentials");
	}
}
