package com.vd.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vd.document.Employee;
import com.vd.dto.EmployeeDTO;
import com.vd.repository.EmployeeRepository;
@Service("eService")
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository erepo;
	@Override
	public String registerEmployee(EmployeeDTO dto) {
		Employee entity=null;
		
		entity=new Employee();
		BeanUtils.copyProperties(dto, entity);
		return "Employee Registered"+erepo.save(entity).getEno();
	}

}
