package com.vd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.vd.service.CustomerService;

@SpringBootApplication
public class DataBootProj2PaggingAndSortingApplication {

	public static void main(String[] args) {
		ApplicationContext context=null;
		CustomerService service=null;
		
		
		context=SpringApplication.run(DataBootProj2PaggingAndSortingApplication.class, args);
		service=context.getBean("service",CustomerService.class);
		/*
		 * service.fetchSortedRecordByProperty("cName",
		 * false).forEach(System.out::println);
		 * System.out.println(".......................................................")
		 * ;
		 * service.fetchSortedRecordByPropertis(true,"cName","address").forEach(System.
		 * out::println);
		 */
		System.out.println("---------------------------------------------------------------------------");
		service.fetchCustomerByPagination(4, 4).forEach(System.out::println);
		
		((ConfigurableApplicationContext) context).close();
	}

}
