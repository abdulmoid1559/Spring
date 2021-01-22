package com.vd.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vd.document.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, Integer> {

}
