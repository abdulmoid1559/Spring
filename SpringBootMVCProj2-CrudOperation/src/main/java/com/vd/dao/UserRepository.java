package com.vd.dao;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.vd.bo.UserBO;

public interface UserRepository extends CrudRepository<UserBO,String> {
	@Procedure(outputParameterName = "CNT")
	public Integer P_AUTHENTICATE_ADMIN(@Param(value = "uname") String uname, @Param(value = "pwd")String pwd);
}
