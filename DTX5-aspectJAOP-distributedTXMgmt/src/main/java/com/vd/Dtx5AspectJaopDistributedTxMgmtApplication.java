package com.vd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.vd.service.BankServiceImpl;

@SpringBootApplication
public class Dtx5AspectJaopDistributedTxMgmtApplication {

	public static void main(String[] args) {
		ApplicationContext context=null;
		BankServiceImpl service=null;
		context=SpringApplication.run(Dtx5AspectJaopDistributedTxMgmtApplication.class, args);
		service=context.getBean("service",BankServiceImpl.class);
		try {
		System.out.println(service.getClass());
		System.out.println(service.moneyTransfer(1004L, 1010L, 4000.0));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
