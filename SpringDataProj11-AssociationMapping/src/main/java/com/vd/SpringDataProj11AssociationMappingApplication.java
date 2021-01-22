package com.vd;

import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.vd.dto.PhoneNumberDTO;
import com.vd.dto.UserInfoDTO;
import com.vd.service.UserService;

@SpringBootApplication
public class SpringDataProj11AssociationMappingApplication {

	public static void main(String[] args) {
		ApplicationContext context=null;
		UserService	 service=null;
		UserInfoDTO dto=null;
		PhoneNumberDTO pndto=null;
		
		context=SpringApplication.run(SpringDataProj11AssociationMappingApplication.class, args);
		service=context.getBean("uservice",UserService.class);
		dto=new UserInfoDTO();
		dto.setUserName("Noushin");
		dto.setAddress("Pune");
		pndto=new PhoneNumberDTO();
		pndto.setMobileNo(98574658673L);
		pndto.setServiceProvider("Idea");
		pndto.setType("personal");
		dto.setContactNo(Set.of(pndto));
		System.out.println(service.registrationService(dto));
	}

}
