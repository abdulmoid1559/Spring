package com.vd.aspect;

import org.aspectj.lang.JoinPoint;

public class CuponGenratorAspect {
	public void generate(JoinPoint point, double bAmt) {
		if(bAmt<10000) {
			System.out.println("Congrat you got 10% discount on next purchase");
		}
		else if (bAmt<15000) {
			System.out.println("Congrat you got 20% discount on next purchase");
		}
		else
			System.out.println("Congrat you got 40% discount on next purchase");
	}
}
