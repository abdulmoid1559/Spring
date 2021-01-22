package com.vd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.vd.service.BankService;
import com.vd.service.BankserviceImpl;

@SpringBootApplication
public class TxMgmtProj3AspectjLocalTxMgmtApplication {

	public static void main(String[] args) {
		ApplicationContext context=null;
		BankService service=null;
		
		context=SpringApplication.run(TxMgmtProj3AspectjLocalTxMgmtApplication.class, args);
		service=context.getBean("service",BankService.class);
		try {
			System.out.println(service.getClass()+"--------------------------------"+service.getClass().getSuperclass());
			System.out.println(service.transferMoney(1003L, 100L, 3000.0));
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		((ConfigurableApplicationContext) context).close();
	}

}
