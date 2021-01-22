package com.vd.dao;

import com.vd.bo.UserBO;

public interface AuthenticationDAO {
	public String authenticate(UserBO bo);
}
