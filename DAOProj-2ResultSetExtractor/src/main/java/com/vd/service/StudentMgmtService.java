package com.vd.service;

import java.util.List;

import com.vd.dto.StudentDTO;

public interface StudentMgmtService {
	public List<StudentDTO> fetchStudent(String addrs);
}
