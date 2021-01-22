package com.vd.pointcut;

import java.lang.reflect.Method;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

public class PerformancePointcut extends StaticMethodMatcherPointcut{
	private String methodName=null;
	private Class className=null;
	
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public void setClassName(Class className) {
		this.className = className;
	}

	@Override
	public boolean matches(Method method, Class<?> targetClass) {
		if(method.getName().equalsIgnoreCase(methodName)&& targetClass==className)
			return true;
		else
			return false;
	}

	

}
