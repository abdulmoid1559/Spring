package com.vd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.vd.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
