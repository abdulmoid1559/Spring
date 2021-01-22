package com.vd.controller;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.vd.service.LocaleService;

@Controller
public class LocaleController {
	@Autowired
	private LocaleService service;
	@GetMapping("/welcome")
	public String getHomePage() {
		return "home";
	}
	
	@GetMapping("/contries")
	public String getAllCountries(Map map) {
		Set list=service.showCountries();
		map.put("list", list);
		return "result";
	}
}
