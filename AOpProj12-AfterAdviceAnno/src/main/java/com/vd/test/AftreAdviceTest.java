package com.vd.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vd.service.ShoppingService;

public class AftreAdviceTest {

	public static void main(String[] args) {
		ApplicationContext context=null;
		ShoppingService service=null;
		
		context=new ClassPathXmlApplicationContext("com/vd/cfgs/applicationContext.xml");
		service=context.getBean("service",ShoppingService.class);
		System.out.println(service.getClass());
		System.out.println("Total Amount::"+service.shopping(new String[]{"chair","table"},new double[] {10000,10000}));
		((AbstractApplicationContext) context).close();
	}

}
