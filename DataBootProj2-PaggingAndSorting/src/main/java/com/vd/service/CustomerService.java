package com.vd.service;

import com.vd.dto.CustomerDTO;

public interface CustomerService {
	public Iterable<CustomerDTO> fetchSortedRecordByProperty(String property,Boolean asc);
	public Iterable<CustomerDTO> fetchSortedRecordByPropertis(Boolean direction,String ...properties);
	public Iterable<CustomerDTO> fetchCustomerByPagination(Integer pageNo,Integer pageSize);
}
