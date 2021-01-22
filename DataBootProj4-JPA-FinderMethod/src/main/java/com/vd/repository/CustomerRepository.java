package com.vd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vd.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer>{
	//public List<Customer> findByAddress(String address);
	/*
	 * public Customer findByCname(String name); public List<Customer>
	 * findByAddressLike(String ch); public List<Customer>
	 * findByBillAmtGreaterThan(Double billAmt);
	 */
	public List<Customer> findByBillAmtLessThan(Double amt);
	//public List<Customer> findByBillAmtIsNotNull();
	//public List<Customer> findByBillAmtIsNull();
	public List<Customer> findByCnameLike(String name);
}
