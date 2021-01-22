package com.vd;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.dao.DataAccessException;

import com.vd.repository.CustomerRepository;



@SpringBootApplication
public class DataBootProj3JPAFinderMethodApplication {

	public static void main(String[] args) {
		ApplicationContext context=null;
		CustomerRepository repository=null;
		
		context=SpringApplication.run(DataBootProj3JPAFinderMethodApplication.class, args);
		repository=context.getBean(CustomerRepository.class);
		//repository.findByAddress("Pune").forEach(System.out::println);
		//repository.findByCname("Utkarsha").forEach(System.out::println);
		/*
		 * System.out.println(repository.findByCname("Mosin"));
		 * repository.findByAddressLike("Pu%").forEach(System.out::println);
		 */
		//repository.findByBillAmtGreaterThan(2000.0).forEach(System.out::println);
		//repository.findByBillAmtLessThan(3000.0).forEach(System.out::println);
		//repository.findByBillAmtIsNotNull().forEach(System.out::println);
		//repository.findByBillAmtIsNull().forEach(System.out::println);
		repository.findByCnameLike("____").forEach(System.out::println);
		((ConfigurableApplicationContext) context).close();
	}

}
