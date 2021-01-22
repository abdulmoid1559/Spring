package com.vd.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vd.dto.StudentDTO;
import com.vd.service.StudentMgmtService;
import com.vd.service.StudentMgmtServiceImpl;

public class ResultSetExtracterApp{
    public static void main( String[] args ){
        ApplicationContext ctx=null;
        List<StudentDTO> listDTO=null; 
    	StudentMgmtService service=null;
    	
    	ctx= new ClassPathXmlApplicationContext("com/vd/cfgs/applicationContext.xml");
    	service=ctx.getBean("service",StudentMgmtServiceImpl.class);
    	listDTO=service.fetchStudent("usa");
    	listDTO.forEach(dto->{
    			System.out.println(dto);
    			});
    	
    }
}
