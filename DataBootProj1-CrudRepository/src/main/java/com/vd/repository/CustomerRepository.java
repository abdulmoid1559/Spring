package com.vd.repository;

import org.springframework.data.repository.CrudRepository;

import com.vd.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer,Integer>{

}
