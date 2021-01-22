package com.vd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.vd.service.BankService;
import com.vd.service.BankServiceImpl;

@SpringBootApplication
public class AopProj13BootAroundAdviceApplication {

	public static void main(String[] args) {
		ApplicationContext context;
		BankService service;
		context=SpringApplication.run(AopProj13BootAroundAdviceApplication.class, args);
		service=context.getBean(BankServiceImpl.class);
		System.out.println(service.compoundInterest(20000, 7, 12));
		System.out.println(service.simpleInterest(30000, 5, 20));
		((ConfigurableApplicationContext) context).close();
	}

}
