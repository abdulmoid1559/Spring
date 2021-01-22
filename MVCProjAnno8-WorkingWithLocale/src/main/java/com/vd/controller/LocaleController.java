package com.vd.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vd.service.LocaleService;

@Controller
public class LocaleController {
	@Autowired
	private LocaleService service;
	@RequestMapping("welcome")
	public String homePageGenerate() {
		return "home";
	}
	
	@RequestMapping("/getAllCountries")
	public String wishMessage(ModelMap map) {
		Set listCountries=null;
		int size=0;
		String  operation=null;
		
		listCountries=service.getAllCountries();
		size=listCountries.size();
		operation="contries";
		map.put("listInfo", listCountries);
		map.put("opt",operation);
		map.put("count", size);	
		return "result";
	}
	
	@RequestMapping("/allLanguage")
	public String getAllLanguage(ModelMap map) {
		Set listLangs=null;
		String  operation=null;
		Integer size;
		
		listLangs=service.getAllLanguage();
		operation="Language";
		size=listLangs.size();
		map.put("listInfo",listLangs);
		map.put("opt",operation);
		map.put("count",size);
		return "result";
	}
}
