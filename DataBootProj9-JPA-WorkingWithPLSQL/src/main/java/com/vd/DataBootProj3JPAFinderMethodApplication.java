package com.vd;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.object.StoredProcedure;

import com.vd.repository.CustomerRepository;




@SpringBootApplication
public class DataBootProj3JPAFinderMethodApplication {

	public static void main(String[] args) {
		ApplicationContext context=null;
		CustomerRepository repository=null;
		Object[] data=null;
		List<Object[]> list=null;
		Integer count=0;
		EntityManager manager=null;
		StoredProcedureQuery procedure=null;
				
		context=SpringApplication.run(DataBootProj3JPAFinderMethodApplication.class, args);
		repository=context.getBean(CustomerRepository.class);
//		count=repository.CUSTOMERCOUNTBYADDRS("Pune");
		//get entity manager class object  
		manager=context.getBean(EntityManager.class);
		//register Procedure 
		procedure=manager.createNamedStoredProcedureQuery("CUSTOMERCOUNTBYADDRS");
		//register parameter with query  
		procedure.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
		procedure.registerStoredProcedureParameter(2,Integer.class,ParameterMode.OUT);
		// set Params value
		procedure.setParameter(1, "Pune");
		procedure.execute();
		//get Out param 
		count=(Integer) procedure.getOutputParameterValue(2);
		System.out.println("Number of record on this given Address"+count);
		
		((ConfigurableApplicationContext) context).close();
	}

}
