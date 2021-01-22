package com.vd.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class PerformanceAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		long start=0l,end=0l;
		Object retVal=null;
		start=System.currentTimeMillis();
		
		retVal=invocation.proceed();
		end=System.currentTimeMillis();
		System.out.println("time has taken"+(end-start)+"ms. Method name::"+invocation.getMethod()+" Method Argument"+invocation.getArguments());
		return retVal;
	}

}
