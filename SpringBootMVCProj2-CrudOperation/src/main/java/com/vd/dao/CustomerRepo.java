package com.vd.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.vd.bo.CustomerBO;

public interface CustomerRepo extends CrudRepository<CustomerBO, Integer> {
	
}
