package com.vd;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.vd.repository.CustomerRepository;




@SpringBootApplication
public class DataBootProj3JPAFinderMethodApplication {

	public static void main(String[] args) {
		ApplicationContext context=null;
		CustomerRepository repository=null;
		Object[] data=null;
		List<Object[]> list=null;
				
		context=SpringApplication.run(DataBootProj3JPAFinderMethodApplication.class, args);
		repository=context.getBean(CustomerRepository.class);
//		repository.getCustomerByBillRange(3000.0, 5000.0).forEach(System.out::println);
		//repository.getCustomerByCity("Pune","Hyd").forEach(System.out::println);
//		repository.getCustomerDataByCity("Hyderbad", "Pune").forEach(row->{
//																												System.out.println(row[0]+" "+row[1]+" "+row[2]);
//		});
		//repository.getCustomerNameByCity("Nagpur", "Pune").forEach(System.out::println);
//		System.out.println(repository.getCustomerDetailByName("Moid"));
//		data=(Object[])repository.getValuesOfCustomerByCno(2);
//		list=repository.getValuesOfCustomerByCno(2);
//		data=list.get(0);
//		for(Object val:data)
//		System.out.print(val+" ");
		//System.out.println(repository.getCustomerNameByBillAmt(4000.0));
//		list=repository.getSum_MaxAndCount();
//		data=list.get(0);
//		for(Object val:data)
//			System.out.println(val+" ");
//		System.out.println(repository.getSystemDate());
//		repository.getCustomerByAddrs("Pune").forEach(System.out::println);
		repository.getRecordByAddress("Pune").forEach(System.out::println);
		((ConfigurableApplicationContext) context).close();
	}

}
