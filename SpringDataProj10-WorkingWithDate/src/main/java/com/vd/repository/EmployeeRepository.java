package com.vd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vd.entity.EmployeeInfo;

public interface EmployeeRepository extends JpaRepository<EmployeeInfo, Integer> {

}
