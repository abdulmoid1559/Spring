package com.vd.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component("pfAdvice")
@Aspect
public class PerformanceAdvice{
	
	@Around("execution(* com.vd.service.BankServiceImpl.*(..))")
	public Object invoke(ProceedingJoinPoint point) throws Throwable {
		long start=0l,end=0l;
		Object retVal=null;
		start=System.currentTimeMillis();
		
		retVal=point.proceed();
		end=System.currentTimeMillis();
		System.out.println("time has taken"+(end-start)+"ms. Method name::"+point.getSignature()+" Method Argument"+point.getArgs());
		return retVal;
	}

}
