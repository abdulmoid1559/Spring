package com.vd.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.vd.dto.CustomerDTO;
import com.vd.entity.Customer;
import com.vd.repository.CustomerRepository;

@Service("service")
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository repository;
	public List<CustomerDTO> fetchExampleByGivenProperty(CustomerDTO dto){
		List<CustomerDTO> listDto=new ArrayList<CustomerDTO>();
		List<Customer> listEntity=null;
		Customer entity=null;
		Example<Customer> ex=null;
		
		entity=new Customer();
		BeanUtils.copyProperties(dto, entity);
		//create Example object by passing Entity class object
		ex=Example.of(entity);
		//use repository 
		listEntity=repository.findAll(ex);
		//copy property list of dto
		listEntity.forEach(entity1->{
			CustomerDTO dto1=new CustomerDTO();
			BeanUtils.copyProperties(entity1, dto1);
			listDto.add(dto1);
		});
		return listDto;
	}
	@Override
	public String removeAll(List<CustomerDTO> listDTO) {
		Boolean flag=false;
		
		//check record is available or not then delete
		if(repository.count()>=1) {
			
			//use Repository
			repository.deleteAllInBatch();
			flag=true;
		}
		return flag?"All record are deleted ":"single record also not available";
	}
}
