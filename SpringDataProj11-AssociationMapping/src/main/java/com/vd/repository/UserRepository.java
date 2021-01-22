package com.vd.repository;

import org.springframework.data.repository.CrudRepository;

import com.vd.entity.UserInfo;

public interface UserRepository extends CrudRepository<UserInfo, Integer> {

	
}
