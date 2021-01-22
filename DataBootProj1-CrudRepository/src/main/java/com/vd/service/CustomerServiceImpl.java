package com.vd.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vd.entity.Customer;
import com.vd.entity.CustomerDTO;
import com.vd.repository.CustomerRepository;

@Service("service")
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerRepository repository;
	
	public String register(CustomerDTO dto){
		
		Customer bo=null,entity=null;
		
		bo=new Customer();
		BeanUtils.copyProperties(dto, bo);
		entity=repository.save(bo);
		return entity==null?"Registration failed":"Registration succeded";
	}

	@Override
	public String registerAll(Iterable itDto) {
		Iterable<Customer> itEntites=new ArrayList();
		String ids=null;
		Iterable<Customer> itEntities1=null;
		
		itDto.forEach(dto->{
			Customer bo=new Customer();
			BeanUtils.copyProperties(dto, bo);
			((List) itEntites).add(bo);
		});
		itEntities1=repository.saveAll(itEntites);
//		ids=((Collection) itEntities1).stream().map(e->((Object) e).getCNo()).collect(Collectors.toList()).toString();
		for(Customer e:itEntities1) {
			ids=ids+","+e.getCno();
		}
		
		return itEntities1==null?"Registration failed":"Registration sucessed"+ids;
	}

	@Override
	public String removeCustomerById(Integer id) {
		Boolean flag=false;
		
		flag=repository.existsById(id);
		if(flag) {
			repository.deleteById(id);
		}
		return flag?"Customer deleted from DB":"Customer not found";
	}

	@Override
	public String removeGivenCustomer(Iterable<CustomerDTO> itDTO) {
		Iterable<Customer> entity=new ArrayList<Customer>();
		
		itDTO.forEach(dto->{
			Customer bo= new Customer();
			BeanUtils.copyProperties(dto, bo);
			((List) entity).add(bo);
		});
		repository.deleteAll(entity);
		return "Records Deleted ";
	}

	@Override
	public Long countOfCustomer() {
		return repository.count();
	}

	@Override
	public List<CustomerDTO> fetchAllCustomner() {
		Iterable<Customer> listEntity=null;
		List<CustomerDTO> listDto=new ArrayList<CustomerDTO>();
		
		listEntity=repository.findAll();
		listEntity.forEach(entity->{
			CustomerDTO dto=new CustomerDTO();
			BeanUtils.copyProperties(entity, dto);
			listDto.add(dto);
		});
		
		return listDto;
	}
	
	@Override
	public CustomerDTO accessCustomerById(Integer id) {
		CustomerDTO dto=null;
		Optional<Customer> entity=null ;
		
		
		entity=repository.findById(id);
		
			dto=new CustomerDTO();
			BeanUtils.copyProperties(entity.get(), dto);
		
		
		return dto;
	}

}
