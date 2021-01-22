package com.vd.test;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.vd.config.AppConfig;
import com.vd.dto.BookDTO;
import com.vd.service.BookStoreService;

public class NamedParameterJdbcTemplateApp{
    public static void main( String[] args ){
    	ApplicationContext context=null;
    	BookStoreService service=null;
    	Scanner scn=null;
    	String res=null;
    	BookDTO dto=null;
    	List<BookDTO> listDto=null;
    	
    	scn=new Scanner(System.in);
    	context=new AnnotationConfigApplicationContext(AppConfig.class);
    	service=context.getBean("bookStoreService",BookStoreService.class);
    	dto=new BookDTO();
    	dto.setBookName("Oracle");
    	dto.setCategory("SQL");
    	dto.setPublisher("NIT ");
    	dto.setPrice(8000);
    	dto.setAuthor("Murli");
    	dto.setAvailabilityStatus("YES");
    	res=service.registerBook(dto);
        System.out.println( res );
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        listDto=service.getBookByAuthor("Durga", "Natraj", "Murli");
        listDto.forEach(System.out::println);
    }
}
