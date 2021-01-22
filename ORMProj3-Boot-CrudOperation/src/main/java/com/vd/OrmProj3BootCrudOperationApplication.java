package com.vd;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.vd.dto.ProjectDTO;
import com.vd.service.ProjectService;

@SpringBootApplication
public class OrmProj3BootCrudOperationApplication {

	public static void main(String[] args) {
		ApplicationContext context=null;
		ProjectService service=null;
		context=SpringApplication.run(OrmProj3BootCrudOperationApplication.class, args);
		service=context.getBean("service",ProjectService.class);
		List<ProjectDTO> listDto = service.GetProjectByRange(1000000.0, 2000000.0);
		listDto.forEach(System.out::println);
	}

}
