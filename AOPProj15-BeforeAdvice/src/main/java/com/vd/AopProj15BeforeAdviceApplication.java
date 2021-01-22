package com.vd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.DataAccessException;

import com.vd.service.BankService;
import com.vd.utility.AuthenticationManager;

@SpringBootApplication
public class AopProj15BeforeAdviceApplication {

	public static void main(String[] args) {
		ApplicationContext context;
		BankService service;
		AuthenticationManager manager;
		
		context=SpringApplication.run(AopProj15BeforeAdviceApplication.class, args);
		manager=context.getBean("authManager",AuthenticationManager.class);
		service=context.getBean("bService",BankService.class);
		System.out.println("BeforeAdviceTest.main()");
		manager.signIn("moid123", "moid");
		try {
			System.out.println("In try");
			System.out.println(service.depositeMoney(1001, 20000));
			System.out.println(service.withdrawMoney(1001, 10000));
			
		} catch (DataAccessException dae) {
			dae.printStackTrace();
		  }
	}

}
