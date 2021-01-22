package com.vd.advice;

import java.util.Arrays;
import java.util.HashMap;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component("cache")
@Aspect
public class CachAdvice{
	HashMap map=new HashMap<String,Object>();
	@Around(value = "execution(* com.vd.service.BankServiceImpl.*(..))")
	
	public Object invoke(ProceedingJoinPoint point) throws Throwable {
		System.out.println("CachAdvice.invoke()");
		String key=null;
		Object retVal;
		key=point.getSignature()+Arrays.deepToString(point.getArgs());
		
		if(!map.containsKey(key)) {
			
			retVal=point.proceed();
			map.put(key, retVal);
			System.out.println("From main class");
		}
		else {
			retVal=map.get(key);
			System.out.println("from Cache memory");
		}
		return retVal;
	}

}
