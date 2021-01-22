package com.vd;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.dao.DataAccessException;

import com.vd.entity.CustomerDTO;
import com.vd.service.CustomerService;

@SpringBootApplication
public class DataBootProj1CrudRepositoryApplication {

	public static void main(String[] args) {
		ApplicationContext context=null;
		CustomerService service=null;
		CustomerDTO dto=null,dto2,dto3,dto4;
		CustomerDTO opt=null;
		
		context=SpringApplication.run(DataBootProj1CrudRepositoryApplication.class, args);
		dto=new CustomerDTO();
		dto.setCName("Moid");
		dto.setBillAmt(100010.0);
		dto.setAddress("Pune");
		dto2=new CustomerDTO();
		
		dto2.setCName("Noushin");
		dto2.setBillAmt(100010.0);
		dto2.setAddress("Pune");
		dto3=new CustomerDTO();
		
		dto3.setCName("Arshi");
		dto3.setBillAmt(100010.0);
		dto3.setAddress("Amravati");
		dto4=new CustomerDTO();
		dto4.setCName("Utkarsha");
		dto4.setBillAmt(100010.0);
		dto4.setAddress("Pune");
		try {
			service=context.getBean("service",CustomerService.class);
		//	System.out.println(service.register(dto));
			System.out.println(service.registerAll(Arrays.asList(dto,dto2,dto3,dto4)));
			//System.out.println(service.removeClientById(20));
			//System.out.println(service.removeGivenCustomer(Arrays.asList(new CustomerDTO(61),new CustomerDTO(62))));
			
			  System.out.println(service.countOfCustomer());
			  List<CustomerDTO> listDTO =service.fetchAllCustomner();
			  listDTO.forEach(System.out::println);
			 
//			opt=service.accessCustomerById(63);
			//System.out.println(opt.get());
			/*
			 * if(opt.isPresent() && opt.isEmpty()) { System.out.println(opt.get()); } else
			 * { System.out.println("record not found"); }
			 */
//			System.out.println(opt);
		}
		catch (DataAccessException e) {
			e.printStackTrace();
		}
		
		((ConfigurableApplicationContext) context).close();
	}

}
