package com.vd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.vd.service.ShoppingStore;

@SpringBootApplication
public class AopProj14BootThrowsAdviceApplication {

	public static void main(String[] args) {
		ApplicationContext context;
		ShoppingStore store;
		context=SpringApplication.run(AopProj14BootThrowsAdviceApplication.class, args);
		store=context.getBean("store",ShoppingStore.class);
	   	System.out.println("Bill Amount is ::"+store.shopping("Shoes",10000.0));
	   	System.out.println("------------------------------------------------------------------------------------------------");
	   	System.out.println("Bill Amount is ::"+store.shopping("t-shirt",0.0));
	   	((AbstractApplicationContext) context).close();
	}

}
