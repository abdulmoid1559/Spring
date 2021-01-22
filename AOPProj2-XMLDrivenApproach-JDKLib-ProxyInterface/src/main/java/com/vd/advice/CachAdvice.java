package com.vd.advice;

import java.util.Arrays;
import java.util.HashMap;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class CachAdvice implements MethodInterceptor {
	HashMap map=new HashMap<String,Object>();

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		String key=null;
		Object retVal;
		key=invocation.getMethod().getName()+Arrays.deepToString(invocation.getArguments());
		
		if(!map.containsKey(key)) {
			
			retVal=invocation.proceed();
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
