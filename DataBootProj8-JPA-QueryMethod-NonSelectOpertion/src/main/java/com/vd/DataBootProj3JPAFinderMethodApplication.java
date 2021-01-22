package com.vd;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.vd.repository.CustomerRepository;




@SpringBootApplication
public class DataBootProj3JPAFinderMethodApplication {

	public static void main(String[] args) {
		ApplicationContext context=null;
		CustomerRepository repository=null;
		Object[] data=null;
		List<Object[]> list=null;
		Integer count=0;
				
		context=SpringApplication.run(DataBootProj3JPAFinderMethodApplication.class, args);
		repository=context.getBean(CustomerRepository.class);
//		count=repository.updateBillAmtByCity("Pune", 1000.0);
		//count=repository.updateAddressByCustNo("Pune", 3);
//		count=repository.deleteRowByCity("Amravati");
//		count=repository.deleteRowByCno(10);
		//------------------------NATIVE QUERY
		count=repository.insertRecord("Pune", 12020.0, "Naweed");
		System.out.println("Number of record inserted"+count);
		
		((ConfigurableApplicationContext) context).close();
	}

}
