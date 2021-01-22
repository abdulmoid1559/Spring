package com.vd.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vd.bo.StudentBO;
import com.vd.dao.StudentDAO;
import com.vd.dto.StudentDTO;

@Service(value="service")
public class StudentMgmtServiceImpl implements StudentMgmtService {
	@Autowired
	StudentDAO dao=null;
	@Override
	public List<StudentDTO> fetchStudent(String addrs) {
		List<StudentBO> listBO=null;
		List<StudentDTO> listDTO=null;
		listBO=dao.getStudentByAddrs(addrs);
		listDTO=new ArrayList();
		for(StudentBO bo:listBO) {
			StudentDTO dto=new StudentDTO();
			/*
			 * dto.setSid(bo.getSid()); dto.setSname(bo.getSname());
			 * dto.setAddress(bo.getAddress()); dto.setCourse(bo.getCourse());
			 * dto.setFee(bo.getFee());
			 */
			BeanUtils.copyProperties(bo, dto);
			listDTO.add(dto);
		}
		return listDTO;
	}

}
