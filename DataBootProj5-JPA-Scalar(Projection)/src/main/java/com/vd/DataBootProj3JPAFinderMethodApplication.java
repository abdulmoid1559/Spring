package com.vd;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.vd.repository.CustomerRepository;
import com.vd.repository.CustomerRepository.ResultView1;
import com.vd.repository.CustomerRepository.ResultView2;



@SpringBootApplication
public class DataBootProj3JPAFinderMethodApplication {

	public static void main(String[] args) {
		ApplicationContext context=null;
		CustomerRepository repository=null;
		List<ResultView1> v1List=null;
		List<ResultView2> v2List=null;
		
		context=SpringApplication.run(DataBootProj3JPAFinderMethodApplication.class, args);
		repository=context.getBean(CustomerRepository.class);
		/*DataBootProj5-JPA-Scalar(Projection)
		 * v1List=repository.findByAddress("Pune"); v1List.forEach(v1->{
		 * System.out.println(v1.getCno()+" "+v1.getCname()); });
		 */
		v2List=repository.findByAddress("Pune"); 
		v2List.forEach(v2->{
			System.out.println(v2.getCname()+" "+v2.getBillAmt()+" "+v2.getBillAmt());
		});
		((ConfigurableApplicationContext) context).close();
	}

}
