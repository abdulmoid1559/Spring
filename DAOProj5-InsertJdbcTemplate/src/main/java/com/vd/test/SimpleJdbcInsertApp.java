package com.vd.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.DataAccessException;

import com.vd.config.AppConfig;
import com.vd.dto.ProductDTO;
import com.vd.service.ProductService;

/**
 * Hello world!
 *
 */
public class SimpleJdbcInsertApp{
    public static void main( String[] args ){
    	ApplicationContext context=null;
    	ProductService service=null;
    	ProductDTO dto=null;
    	
    	dto=new ProductDTO();
    	dto.setPid(10104);
    	dto.setPname("Eraser");
    	dto.setQty(100);
    	dto.setPrice(5);
    	try {
    	context=new AnnotationConfigApplicationContext(AppConfig.class);
    	service=context.getBean("prodservice",ProductService.class);
        System.out.println( service.registerProduct(dto) );
    	}
    	catch (DataAccessException dae) {
    		dae.printStackTrace();
		}
    	catch (Exception e) {
			e.printStackTrace();
		}
    }
}
