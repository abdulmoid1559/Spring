package com.vd.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.vd.dto.UserDTO;
import com.vd.model.User;
import com.vd.service.AuthenticationService;
@Controller
public class LoginController {
	@Autowired
	private AuthenticationService  service;
	
	@GetMapping("/login")
	public String showLogin(@ModelAttribute User user,Map map) {
		return "login";
	}
	
	@PostMapping("/login")
	public String processRequest(@ModelAttribute User user,Map map) {
		UserDTO dto=null;
		String msg=null;
		dto=new UserDTO();
		BeanUtils.copyProperties(user, dto);
		msg=service.IsAuthenticate(dto);
		map.put("status", msg);
		return "login";
	}
}
