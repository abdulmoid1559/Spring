package com.vd.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.vd.service.WishServiceImpl;

@Controller
public class WishController {
	@Autowired
	private WishServiceImpl service;
	
	@GetMapping("/home")
	public String getHomePage() {
		return "home";
	}
	
	@GetMapping("/wish")
	public String generateWishMessage(Map map) {
		String msg;
		
		msg=service.genrateWishMsg();
		map.put("msg", msg);
		return "result";
	}
}
