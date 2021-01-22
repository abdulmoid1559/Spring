package com.vd.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vd.dto.ProductDTO;
import com.vd.service.ECommerceStoreService;
import com.vd.service.ECommerceStoreServiceImpl;

public class AroundAdviceTest {

	public static void main(String[] args) {
		ApplicationContext context=null;
		ECommerceStoreService service=null;
		ProductDTO dto=null;
		ProductDTO dto2=null;
		ProductDTO dto3=null;
		//create IOC container 
		context=new ClassPathXmlApplicationContext("com/vd/cfgs/applicationContext.xml");
		service=context.getBean("service",ECommerceStoreServiceImpl.class);
		System.out.println(service.getClass()+" "+service.getClass().getSuperclass());
		dto=new ProductDTO();
		dto.setPid(101);
		dto.setPname("Table");
		dto.setPrice(90000);
		dto.setQty(4);
		service.addItemToCart(dto);
		System.out.println("--------------------------------------------------------------------------------------------");
		dto2=new ProductDTO();
		dto2.setPid(102);
		dto2.setPname("Chair");
		dto2.setPrice(10000);
		dto2.setQty(20);
		service.addItemToCart(dto2);
		System.out.println("--------------------------------------------------------------------------------------------");
		dto3=new ProductDTO();
		dto3.setPid(103);
		dto.setPname("Bench");
		dto.setPrice(20000);
		dto.setQty(10);
		service.addItemToCart(dto);
		System.out.println("\n--------------------------------------------------------------------------------------------------");
		service.showCartItem();
		System.out.println(service.totalBillAmt(5));
		System.out.println(service.totalBillAmt(5));
		((AbstractApplicationContext) context).close();
	}

}
