package com.vd.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.vd.bo.UserBO;
import com.vd.dao.AuthenticationDAO;
import com.vd.dto.UserDTO;
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
	@Autowired
	private AuthenticationDAO dao;
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public String IsAuthenticate(UserDTO dto) {
		UserBO bo=null;
		String msg=null;
		
		bo=new UserBO();
		BeanUtils.copyProperties(dto, bo);
		msg=dao.authenticate(bo);
		System.out.println("AuthenticationServiceImpl.IsAuthenticate()");
		return msg;
	}

}
