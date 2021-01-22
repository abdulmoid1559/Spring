package com.vd.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.vd.config.AppConfig;
import com.vd.dto.ProjectDTO;
import com.vd.service.ProjectService;

public class HibernateWithSpringTest {

	public static void main(String[] args) {
		ApplicationContext context=null;
		ProjectService service=null;
		ProjectDTO dto=null;
		List<ProjectDTO> listDto=null;
		context=new AnnotationConfigApplicationContext(AppConfig.class);
		service=context.getBean("service",ProjectService.class);
		
		/*
		 * dto=new ProjectDTO(); dto.setProjName("OpenFX"); dto.setTeamSize(30);
		 * dto.setCost(10101001000.0); dto.setCompany("Oracle");
		 * dto.setLocation("pune"); try {
		 * System.out.println(service.registerProject(dto)); } catch
		 * (DataAccessException dae) { dae.printStackTrace(); }
		 */
		 
		System.out.println("--------------------------------------------------------");
		System.out.println(service.accessProject(4));
		/*
		 * System.out.println("-------------Update Method result -----------------");
		 * System.out.println(service.modifyProject(22, 2000000.0, 20));
		 */
		/*
		 * System.out.println("---------------------delete method test-------------");
		 * System.out.println(service.removeProjectById(21));
		 */
		System.out.println("Bulk Operation");
		listDto=service.GetProjectByRange(1000000.0, 2000000.0);
		listDto.forEach(System.out::println);
		((AbstractApplicationContext) context).close();
	}

}
