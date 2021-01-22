package com.vd.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggingAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object retVal=null;
		
		System.out.println("Entering into "+invocation.getMethod());
		retVal=invocation.proceed();
		System.out.println("Exiting from "+invocation.getMethod()); 
		return retVal;
	}

}
