package com.vd;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.vd.dto.ProductDTO;
import com.vd.service.ProductService;

@SpringBootApplication
public class DaoBootProj8MapSqlQueryApplication {

	public static void main(String[] args) {
		ApplicationContext context=null;
		ProductService service=null;
		ProductDTO dto=null;
		List<ProductDTO> listDto=null;
		
		context=SpringApplication.run(DaoBootProj8MapSqlQueryApplication.class, args);
		service=context.getBean("prodservice",ProductService.class);
		dto=service.getProductById(1020);
		System.out.println(dto);
		System.out.println("-------------------------------------------------------------------------------------------------------");
		listDto=service.getProductByQty(10, 100);
		listDto.forEach(System.out::println);
		System.out.println("-------------------------------------------------------------------------------------------------------");
		System.out.print(service.updateQtyByName(100, 10103));
		
		((ConfigurableApplicationContext) context).close();
	}

}
