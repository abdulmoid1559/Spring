package com.vd.service;

import java.util.List;

import com.vd.dto.CustomerDTO;
import com.vd.entity.Customer;

public interface CustomerService {
	public List<CustomerDTO> fetchExampleByGivenProperty(CustomerDTO dto);
	public String removeAll(List<CustomerDTO> listDTO);
}
