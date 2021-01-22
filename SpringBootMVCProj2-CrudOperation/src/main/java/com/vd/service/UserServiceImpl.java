package com.vd.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vd.bo.UserBO;
import com.vd.dao.UserRepository;
import com.vd.dto.UserDTO;

@Service("uservice")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository repo;
	@Override
	public Integer AuthenticatUser(UserDTO dto) {
		Integer count=0;
		UserBO bo=new UserBO();
		
		BeanUtils.copyProperties(dto, bo);
		count=repo.P_AUTHENTICATE_ADMIN(bo.getUsername(), bo.getPassword());
		return count;
	}
	@Override
	public String registerUser(UserDTO dto) {
		UserBO bo=new UserBO();
		UserBO bo2=new UserBO();
		BeanUtils.copyProperties(dto, bo);
		bo2=repo.save(bo);
		return bo2==null?"User registration failed":"User Registration Succeded";
	}
}
