package com.vd.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vd.service.BankService;

public class SpringAdviceTest {

	public static void main(String[] args) {
		ApplicationContext context=null;
		BankService service =null;
		
		context=new ClassPathXmlApplicationContext("com/vd/cfgs/applicationContext.xml");
		service=context.getBean("fproxy",BankService.class);
		System.out.println("Proxy class name::"+service.getClass()+"Super"+service.getClass().getSuperclass());
		System.out.println(service.compoundInterest(100000, 4, 12));
		System.out.println(service.compoundInterest(100000, 4, 12));
		System.out.println(".............................................................................................");
		System.out.println(service.simpleInterest(200000, 2, 20));
		System.out.println(service.simpleInterest(200000, 2, 20));

	}

}
