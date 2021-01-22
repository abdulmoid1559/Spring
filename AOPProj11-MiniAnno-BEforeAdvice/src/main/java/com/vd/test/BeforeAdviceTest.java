package com.vd.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.vd.service.BankService;
import com.vd.utility.AuthenticationManager;

public class BeforeAdviceTest {

	public static void main(String[] args) {
		ApplicationContext context;
		BankService service=null;
		AuthenticationManager manager=null;
		
		context=new ClassPathXmlApplicationContext("com/vd/cfg/applicationContext.xml");
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
