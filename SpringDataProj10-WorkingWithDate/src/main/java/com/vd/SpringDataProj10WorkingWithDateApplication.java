package com.vd;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.vd.dto.EmployeeInfoDTO;
import com.vd.service.EmployeeMgmtService;

@SpringBootApplication
public class SpringDataProj10WorkingWithDateApplication {

	public static void main(String[] args) {
		ApplicationContext context=null;
		EmployeeMgmtService service=null;
		EmployeeInfoDTO dto=null;
		
		context=SpringApplication.run(SpringDataProj10WorkingWithDateApplication.class, args);
		service=context.getBean("empService",EmployeeMgmtService.class);
		dto=new EmployeeInfoDTO();
		dto.setName("Moid");
		dto.setSalary(202000.0);
		dto.setDoj(LocalDate.of(2020, 12, 15));
		dto.setBatchTime(LocalTime.of(10, 30));
		System.out.println(service.registerEmployee(dto));
		((ConfigurableApplicationContext) context).close();
	}

}
