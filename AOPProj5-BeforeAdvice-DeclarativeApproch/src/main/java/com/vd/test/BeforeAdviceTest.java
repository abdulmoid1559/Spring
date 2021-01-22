package com.vd.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vd.dto.CarDTO;
import com.vd.service.CarService;

public class BeforeAdviceTest {

	public static void main(String[] args) {
		ApplicationContext context=null;
		CarService service=null;
		CarDTO dto=null;
		
		context=new ClassPathXmlApplicationContext("com/vd/cfgs/applicationContext.xml");
		dto=new CarDTO();
		dto.setModelNo(10010);
		dto.setName("i10");
		dto.setPrice(200000.0f);
		dto.setGstRate(5);
		service=context.getBean("cService",CarService.class);
		service.purchaseCar(dto);
		((AbstractApplicationContext) context).close();
	}

}
