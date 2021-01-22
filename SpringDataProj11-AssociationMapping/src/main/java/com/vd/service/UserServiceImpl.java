package com.vd.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vd.dto.PhoneNumberDTO;
import com.vd.dto.UserInfoDTO;
import com.vd.entity.PhoneNumber;
import com.vd.entity.UserInfo;
import com.vd.repository.PhoneNumberRepository;
import com.vd.repository.UserRepository;

@Service("uservice")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository urepo;
	private PhoneNumberRepository pnrepo;
	@Override
	public String registrationService(UserInfoDTO dto) {
		UserInfo userEntity=null;
		Set<PhoneNumber> childEntities=new HashSet();
		Set<PhoneNumberDTO> childDTOS=null;
		   //convert DTO to Entity
		 userEntity=new UserInfo();
		 userEntity.setUserName(dto.getUserName());
		 userEntity.setAddress(dto.getAddress());
		 childDTOS=(Set<PhoneNumberDTO>) dto.getContactNo();
		 childDTOS.forEach(phDTO->{
			 PhoneNumber phEntity=new PhoneNumber();
			 BeanUtils.copyProperties(phDTO,phEntity);
			 childEntities.add(phEntity);
		 });
		 userEntity.setNumber(childEntities);
		  
		   //save object
		  return "customer is saved havid  id :"+urepo.save(userEntity).getUserId();
		 
		 
	}


}
