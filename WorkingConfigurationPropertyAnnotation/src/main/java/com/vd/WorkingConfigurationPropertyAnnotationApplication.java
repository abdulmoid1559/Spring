package com.vd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import com.vd.model.Person;

@SpringBootApplication
public class WorkingConfigurationPropertyAnnotationApplication {

	public static void main(String[] args) {
		ApplicationContext context=null;
		Person p1=null;
		
		
		
		context=SpringApplication.run(WorkingConfigurationPropertyAnnotationApplication.class, args);
		p1=context.getBean("per",Person.class);
		System.out.println(p1);
		System.out.println(".......................................");
		p1.displayByEnv();
		((ConfigurableApplicationContext) context).close();
	}

}
