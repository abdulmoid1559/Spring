package com.vd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@SpringBootApplication
public class SpringBootMvcProj3FileUploadAndDowloadApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMvcProj3FileUploadAndDowloadApplication.class, args);
	}
	@Bean("multipartResolver")
	public CommonsMultipartResolver getMpr() {
		CommonsMultipartResolver cmr=new CommonsMultipartResolver();
		cmr.setMaxUploadSizePerFile(5*1024*1024);
		cmr.setMaxUploadSize(50*1024*1024);
		return cmr;
	}
}
