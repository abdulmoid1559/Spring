package com.vd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.vd.entity.Customer;
@Transactional
public interface CustomerRepository extends JpaRepository<Customer,Integer>{
//	@Procedure(procedureName = "CUSTOMERCOUNTBYADDRS")
//	public Integer getCustomerCountByAddrs(String addrs);
	@Procedure
	public Integer CUSTOMERCOUNTBYADDRS(String addrs);
}
