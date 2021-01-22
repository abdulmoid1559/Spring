package com.vd.pointcut;

import java.lang.reflect.Method;

import org.springframework.aop.support.DynamicMethodMatcherPointcut;

public class CommonLogingPointcut extends DynamicMethodMatcherPointcut {
	private String methodName=null;
	private Class className=null;

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public void setClassName(Class className) {
		this.className = className;
	}

	@Override
	public boolean matches(Method method, Class<?> targetClass, Object... args) {
		if(method.getName().equalsIgnoreCase(methodName)&&targetClass==className &&(Float)args[0]>50000)
			return true;
		else
			return false;
	}

}
