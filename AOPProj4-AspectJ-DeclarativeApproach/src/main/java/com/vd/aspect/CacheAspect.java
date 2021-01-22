package com.vd.aspect;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;

public class CacheAspect {
	private Map cache=new HashMap();
	
	public Object caching(ProceedingJoinPoint point) throws Throwable {
		String key=null;
		Object retVal=null;
		key=point.getSignature()+Arrays.deepToString(point.getArgs());
		if(!cache.containsKey(key)) {
			retVal=point.proceed();
			cache.put(key, retVal);
			System.out.println("From Service class");
		}
		else {
			retVal=cache.get(key);
			System.out.println("From Cache");
		}
		return retVal;
	}

}
