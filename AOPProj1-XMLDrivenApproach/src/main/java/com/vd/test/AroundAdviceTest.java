package com.vd.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vd.service.BankInterestService;

public class AroundAdviceTest {

	public static void main(String[] args) {
		ApplicationContext context=null;
		BankInterestService service =null;
		
		context=new ClassPathXmlApplicationContext("com/vd/cfgs/applicationContext.xml");
		service=context.getBean("fproxy",BankInterestService.class);
		System.out.println("Proxy class name::"+service.getClass()+"Super"+service.getClass().getSuperclass());
		System.out.println(service.compoundInterest(100000, 4, 12));

	}

}
