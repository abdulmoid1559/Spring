package com.vd.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vd.service.ShoppingStore;

public class ThrowsAdviceTest {
	   public static void main(String[] args) {
		   	ApplicationContext context=null;
		   	ShoppingStore store=null;
		   	
		   	context=new ClassPathXmlApplicationContext("com/vd/cfg/applicationContext.xml");
		   	store=context.getBean("store",ShoppingStore.class);
		   	System.out.println("Bill Amount is ::"+store.shopping("Shoes",10000.0));
		   	System.out.println("------------------------------------------------------------------------------------------------");
		   	System.out.println("Bill Amount is ::"+store.shopping("t-shirt",0.0));
		   	((AbstractApplicationContext) context).close();
	   }
}
