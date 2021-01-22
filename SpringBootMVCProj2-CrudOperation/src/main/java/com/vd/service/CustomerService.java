package com.vd.service;

import java.util.Set;

import com.vd.dto.CustomerDTO;

public interface CustomerService {
	public String registerCustomer(CustomerDTO dto);
	public CustomerDTO getCustomerById(Integer id);
	public Set getAllCustomer();
	public String updateCustomerById(CustomerDTO dto);
	public String deleteCustomer(Integer id);
}
