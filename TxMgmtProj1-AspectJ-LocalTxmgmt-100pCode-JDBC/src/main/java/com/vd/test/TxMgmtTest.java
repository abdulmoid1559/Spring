package com.vd.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;


import com.vd.config.AppConfig;
import com.vd.service.BankService;

public class TxMgmtTest {

	public static void main(String[] args) throws IllegalAccessException {
		ApplicationContext context=null;
		BankService service;
		
		context=new AnnotationConfigApplicationContext(AppConfig.class);
		service=context.getBean("service",BankService.class);
		System.out.println(service.transferMoney(1001L, 10010L, 30000.0));
		((AbstractApplicationContext) context).close();
	}

}
