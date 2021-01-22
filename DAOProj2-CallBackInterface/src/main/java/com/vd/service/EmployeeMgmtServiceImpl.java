package com.vd.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vd.bo.EmployeeBO;
import com.vd.dao.EmployeeDao;
import com.vd.dto.EmployeeDTO;
@Service("empService")
public class EmployeeMgmtServiceImpl implements EmployeeMgmtService {
	@Autowired
	private EmployeeDao dao=null;

	@Override
	public EmployeeDTO fetchEmployeeById(int id) {
		EmployeeDTO dto=null;
		EmployeeBO bo=null;
		
		bo=dao.GetEmployeById(id);
		dto=new EmployeeDTO();
		BeanUtils.copyProperties(bo, dto);
		return dto;
	}

	@Override
	public List<EmployeeDTO> fetchEmployeeByAdd(String Addrs) {
		List<EmployeeBO> listBo=null;
		List<EmployeeDTO> listDto=null;
		
		System.out.println("EmployeeMgmtServiceImpl.fetchEmployeeByAdd()");
		listBo=dao.getEmployeeByAddrs(Addrs);
		listDto=new ArrayList();
		System.out.println(listBo.isEmpty());
		BeanUtils.copyProperties(listBo, listDto);
		return listDto;
	}

}
