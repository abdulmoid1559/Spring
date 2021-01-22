package com.vd.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CuponGenratorAspect {
	
	public  void pointcut() {}
	@AfterReturning(pointcut =  "execution(* com.vd.service.ShoppingServiceImpl.*(..))", returning = "bAmt",argNames = "itemsName,prices")
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
