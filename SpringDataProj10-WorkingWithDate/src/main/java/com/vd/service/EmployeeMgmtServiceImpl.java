package com.vd.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vd.dto.EmployeeInfoDTO;
import com.vd.entity.EmployeeInfo;	
import com.vd.repository.EmployeeRepository;
@Service("empService")
public class EmployeeMgmtServiceImpl implements EmployeeMgmtService {
	@Autowired
	EmployeeRepository repo=null;
	@Override
	public String registerEmployee(EmployeeInfoDTO dto) {
		EmployeeInfo entity;
		
		//copy dto to entity
		entity=new EmployeeInfo();
		BeanUtils.copyProperties(dto, entity);
		
		return "Registration succeded . Id is: "+repo.save(entity).getEid();
	}

}
