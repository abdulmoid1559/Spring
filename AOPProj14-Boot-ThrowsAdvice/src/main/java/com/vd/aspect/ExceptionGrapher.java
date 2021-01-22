package com.vd.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.vd.customexception.InternalProblem;

@Component
@Aspect
public class ExceptionGrapher {
	@AfterThrowing(pointcut = "execution(double com.vd.service.ShoppingStoreImpl.shopping(..))",throwing = "iae")
	public void graphing(IllegalArgumentException iae) {
		System.out.println("ExceptionGrapher.graphing()");
		throw new InternalProblem("Internal problem try again");
	}
}
