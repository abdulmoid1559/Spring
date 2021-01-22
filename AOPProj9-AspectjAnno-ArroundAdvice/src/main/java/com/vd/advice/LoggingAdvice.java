package com.vd.advice;

import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component("logAdvice")
@Aspect
public class LoggingAdvice{

	@Around("execution(* com.vd.service.BankServiceImpl.*(..))")
	public Object invoke(ProceedingJoinPoint point) throws Throwable {
		Object retVal=null;
		
		System.out.println("Entering into "+point.getSignature());
		retVal=point.proceed();
		System.out.println("Exiting from "+point.getSignature()); 
		return retVal;
	}

}
