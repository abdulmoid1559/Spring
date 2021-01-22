package com.vd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

@SpringBootApplication
public class SpringBootMvcProj2ThymleafApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMvcProj2ThymleafApplication.class, args);
	}
	
	@Bean("messageSource")
	public ResourceBundleMessageSource createRBMS() {
		
		ResourceBundleMessageSource rbms=new ResourceBundleMessageSource();
		rbms.setBasenames("com/vd/commons/validation");
		return rbms;
		
	}

}
