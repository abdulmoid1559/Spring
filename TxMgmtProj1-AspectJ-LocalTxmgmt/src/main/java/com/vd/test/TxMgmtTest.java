package com.vd.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vd.service.BankService;

public class TxMgmtTest {

	public static void main(String[] args) throws IllegalAccessException {
		ApplicationContext context=null;
		BankService service;
		
		context=new ClassPathXmlApplicationContext("com/vd/cfgs/applicationContext.xml");
		service=context.getBean("service",BankService.class);
		System.out.println(service.transferMoney(1001L, 1010L, 3000.0));
		((AbstractApplicationContext) context).close();
	}

}
