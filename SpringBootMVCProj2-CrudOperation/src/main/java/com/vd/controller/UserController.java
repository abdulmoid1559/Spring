package com.vd.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vd.dto.UserDTO;
import com.vd.model.User;
import com.vd.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService uservice;
	
	//for generating login page 
	@GetMapping("/login")
	public String homePageGenerater(Map map,@ModelAttribute User dto) {
		return "home";
	}
	
	//for processing Login request
	@PostMapping("/login")
	public String logIn(Map map,@ModelAttribute User user) {
		UserDTO dto=new UserDTO();
		Integer flag=0;
		BeanUtils.copyProperties(user, dto);
		flag=uservice.AuthenticatUser(dto);
		System.out.println("Flag::"+flag);
		if(flag>0)
			return "success";
		else
			return "failed";
	}
	
	@GetMapping("/uregister")
	public String generateUserRegisterPage(ModelMap map,@ModelAttribute("user") UserDTO dto) {
		return "registeruser";
	}
	
	@PostMapping("/uregister")
	public String registerUser(RedirectAttributes map,@ModelAttribute("user") UserDTO dto) {
		String msg=uservice.registerUser(dto);
		map.addAttribute("msg", msg);
		System.out.println(msg);
		return "redirect:login";
	}
	@GetMapping("/home")
	public String generateHome(Map map) {
		return "success";
	}
}
