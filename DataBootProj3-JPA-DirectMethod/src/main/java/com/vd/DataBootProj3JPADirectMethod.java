package com.vd;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.vd.dto.CustomerDTO;
import com.vd.service.CustomerService;

@SpringBootApplication
public class DataBootProj3JPADirectMethod {

	public static void main(String[] args) {
		ApplicationContext context=null;
		CustomerService service=null;
		CustomerDTO dto=null;
		List<CustomerDTO> listDTO=null;
		
		
		context=SpringApplication.run(DataBootProj3JPADirectMethod.class, args);
		service=context.getBean("service",CustomerService.class);
		/*
		 * service.fetchSortedRecordByProperty("cName",
		 * false).forEach(System.out::println);
		 * System.out.println(".......................................................")
		 * ;
		 * service.fetchSortedRecordByPropertis(true,"cName","address").forEach(System.
		 * out::println);
		 */
		dto=new CustomerDTO();
		dto.setAddress("Badnera");
		System.out.println("---------------------------------------------------------------------------");
		listDTO=service.fetchExampleByGivenProperty(dto);
		listDTO.forEach(System.out::println);
		System.out.println(service.removeAll(listDTO));
		
		((ConfigurableApplicationContext) context).close();
	}

}
