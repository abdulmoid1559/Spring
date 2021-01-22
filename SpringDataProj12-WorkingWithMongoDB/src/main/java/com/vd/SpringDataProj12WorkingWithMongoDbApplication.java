package com.vd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.dao.DataAccessException;

import com.vd.dto.EmployeeDTO;
import com.vd.service.EmployeeService;

@SpringBootApplication
public class SpringDataProj12WorkingWithMongoDbApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		EmployeeService service=null;
		EmployeeDTO dto=null;
		
		ctx=SpringApplication.run(SpringDataProj12WorkingWithMongoDbApplication.class, args);
		service=ctx.getBean("eService",EmployeeService.class);
		dto=new EmployeeDTO();
		dto.setEno(145224);
		dto.setName("Mosin");
		dto.setAddress("Mumbai");
		dto.setSalary(125436.0);
		try {
			System.out.println(service.registerEmployee(dto));
		}
		catch(DataAccessException dae) {
			System.out.println("registration failed");
			dae.printStackTrace();
		}
		((ConfigurableApplicationContext) ctx).close();
	}

}
