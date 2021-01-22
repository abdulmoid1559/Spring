package com.vd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.vd.dto.ProductDTO;
import com.vd.service.ProductService;

@SpringBootApplication
public class DaoBootProj6SimpleJdbcInsertApplication {

	public static void main(String[] args) {
		ProductService service=null;
		ApplicationContext context=null;
		ProductDTO dto=null;
		
		context=SpringApplication.run(DaoBootProj6SimpleJdbcInsertApplication.class, args);
		service=context.getBean("prodservice",ProductService.class);
		dto= new ProductDTO();
		dto.setPid(1020);
		dto.setPname("Note Book");
		dto.setPrice(30);
		dto.setQty(50);
		System.out.println("Registration Status:"+service.registerProduct(dto));
		System.out.println(dto);
	}

}
