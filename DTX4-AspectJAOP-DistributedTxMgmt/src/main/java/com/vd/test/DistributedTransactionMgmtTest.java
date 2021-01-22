package com.vd.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vd.service.BankService;

public class DistributedTransactionMgmtTest {
	public static void main(String[] args) {
		ApplicationContext context=null;
		BankService service=null;
		
		context=new ClassPathXmlApplicationContext("com/vd/cfgs/applicationContext.xml");
		service=context.getBean("service",BankService.class);
		System.out.println(service.getClass());
		System.out.println(service.moneyTransfer(1001L, 1001L, 3000.0));
		((AbstractApplicationContext) context).close();
	}
}
