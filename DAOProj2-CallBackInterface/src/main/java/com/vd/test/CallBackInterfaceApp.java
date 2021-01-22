package com.vd.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vd.dto.EmployeeDTO;
import com.vd.service.EmployeeMgmtService;

public class CallBackInterfaceApp{
    public static void main( String[] args ){
    	ApplicationContext ctx=null;
    	EmployeeMgmtService service=null;
    	EmployeeDTO dto=null;
    	List<EmployeeDTO> listDto=null;
    	
    	ctx=new ClassPathXmlApplicationContext("com/vd/cfgs/ApplicationContext.xml");
    	service=ctx.getBean("empService",EmployeeMgmtService.class);
    	dto=service.fetchEmployeeById(2022);
        System.out.println(dto);
        System.out.println("------------------------------------------------------------------------------------");
        //listDto=service.fetchEmployeeByAdd("USA");
        System.out.println("CallBackInterfaceApp.main()");
		/*
		 * listDto.stream().forEach(dto1 ->{ System.out.println(dto1); });
		 */
      //  listDto.forEach(System.out::println);
        ((AbstractApplicationContext) ctx).close();
    }
}
