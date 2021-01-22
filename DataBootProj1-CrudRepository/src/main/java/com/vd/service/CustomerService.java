package com.vd.service;

import java.util.List;
import java.util.Optional;

import com.vd.entity.CustomerDTO;

public interface CustomerService {
	public String register(CustomerDTO dto);
	public String registerAll(Iterable itDto);
	public String removeCustomerById(Integer id);
	public String removeGivenCustomer(Iterable<CustomerDTO> itDTO);
	public Long countOfCustomer();
	public List<CustomerDTO> fetchAllCustomner();
	//public Optional<CustomerDTO> accessCustomerById(Integer id);
	public CustomerDTO accessCustomerById(Integer id);
	
}
