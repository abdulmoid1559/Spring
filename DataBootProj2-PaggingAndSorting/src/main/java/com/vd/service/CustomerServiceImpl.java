package com.vd.service;

import java.util.ArrayList;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.vd.dto.CustomerDTO;
import com.vd.entity.Customer;
import com.vd.repository.CustomerRepository;

@Service("service")
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository repository;

	@Override
	public Iterable<CustomerDTO> fetchSortedRecordByProperty(String property, Boolean asc) {
		Iterable<Customer> itEntity=null;
		Iterable<CustomerDTO> itDTO=new ArrayList();
		
		itEntity=repository.findAll(Sort.by(asc?Direction.ASC:Direction.DESC, property));
		itEntity.forEach(entity->{
			CustomerDTO dto=new CustomerDTO();
			BeanUtils.copyProperties(entity, dto);
			((ArrayList) itDTO).add(dto);
		});
		return itDTO;
	}

	@Override
	public Iterable<CustomerDTO> fetchSortedRecordByPropertis(Boolean direction, String... properties) {
		Iterable<Customer> itEntity=null;
		Iterable<CustomerDTO> itDTO=new ArrayList<CustomerDTO>();
		
		itEntity=repository.findAll(Sort.by(direction?Direction.ASC:Direction.DESC, properties));
		itEntity.forEach(entity->{
			CustomerDTO dto=new CustomerDTO();
			BeanUtils.copyProperties(entity, dto);
			((ArrayList) itDTO).add(dto);
		});
		return itDTO;
	}

	@Override
	public Iterable<CustomerDTO> fetchCustomerByPagination(Integer pageNo, Integer pageSize) {
		Pageable pageable=null;
		//Page<Customer> page=null;
		Slice<Customer> slice=null;
		Iterable<Customer>itEntity=null;
		Iterable<CustomerDTO> itDTO=new ArrayList<CustomerDTO>();
		
		//create Pageable object
		pageable=PageRequest.of(pageNo, pageSize);
		//page=repository.findAll(pageable);
		//copy data to dto Iterable object
		//itEntity=page.getContent();
		//System.out.println("No. of pages "+page.getNumber()+" "+page.hasContent());
		slice=repository.findAll(pageable);
		System.out.println(slice.hasContent());
		itEntity.forEach(entity->{
			CustomerDTO dto=new CustomerDTO();
			BeanUtils.copyProperties(entity, dto);
			((ArrayList) itDTO).add(dto);
		});
		return itDTO;
	}
}
