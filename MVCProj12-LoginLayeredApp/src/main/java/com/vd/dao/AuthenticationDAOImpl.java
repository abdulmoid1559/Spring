package com.vd.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.vd.bo.UserBO;
@Repository
public class AuthenticationDAOImpl implements AuthenticationDAO {
	@Autowired
	private SimpleJdbcCall call;
	@Override
	public String authenticate(UserBO bo) {
		Map inParam=null;
		Map outParam=null;
		String status=null;
		
		call.setProcedureName("P_AUTHENTICATION");
		inParam=Map.of("uname", bo.getUsername(), "pwd",bo.getPassword());
		outParam=call.execute(inParam);
		System.out.println(outParam.get("STATUS"));
		status=(String) outParam.get("STATUS");
		return status;
	}

}
