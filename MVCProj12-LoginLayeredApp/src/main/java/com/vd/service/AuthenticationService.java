package com.vd.service;

import com.vd.dto.UserDTO;

public interface AuthenticationService {
	public String IsAuthenticate(UserDTO dto);
}
