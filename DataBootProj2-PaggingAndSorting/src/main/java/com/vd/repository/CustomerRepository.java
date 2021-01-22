package com.vd.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.vd.entity.Customer;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Integer>{

}
