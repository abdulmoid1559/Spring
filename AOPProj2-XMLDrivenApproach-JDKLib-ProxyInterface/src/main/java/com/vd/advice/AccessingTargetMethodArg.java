package com.vd.advice;

import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AccessingTargetMethodArg implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object arg[]=null;
		Object retVal;
		System.out.println("AccessingTargetMethod.invoke(-)");
		arg=invocation.getArguments();
		if((float)arg[0]>100000)
			arg[1]=(int)arg[1]-1;
		
		System.out.println(Arrays.deepToString(invocation.getArguments()));
		retVal=invocation.proceed();
		return retVal;
	}

}
