package com.vd.service;

import com.vd.dto.UserDTO;

public interface UserService {
	public Integer AuthenticatUser(UserDTO dto);
	public String registerUser(UserDTO dto);
}
