package com.vd.aspect;

import com.vd.customexception.InternalProblem;

public class ExceptionGrapher {
	public void graphing(IllegalArgumentException iae) {
		System.out.println("ExceptionGrapher.graphing()");
		throw new InternalProblem("Internal problem try again");
	}
}
