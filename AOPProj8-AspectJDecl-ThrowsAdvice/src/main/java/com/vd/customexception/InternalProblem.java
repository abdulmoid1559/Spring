package com.vd.customexception;

public class InternalProblem extends RuntimeException {
	public InternalProblem(String msg) {
		super(msg);
	}
}
