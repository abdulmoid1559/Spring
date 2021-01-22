package com.vd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {
	
	  @RequestMapping("/display")
	  public String getResult1(ModelMap map) { 
		  return "display"; 
		  }
	 
	@RequestMapping("/get")
	public String getResult(ModelMap map) {
		return "redirect:display";
	}
	
}
