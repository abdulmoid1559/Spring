package com.vd.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vd.model.Employee;

@Controller
public class HomePageController {
	@GetMapping("/register")
	public String showHomePage(@ModelAttribute("emp")Employee emp) {
		emp.setAddress("Mumbai");
		return "register";
	}
	@PostMapping("/register")
	public String register(@ModelAttribute("emp")Employee emp,Map map) {
		map.put("data", emp);
		return "result";
	}
	@GetMapping("/link")
	public String linkProcess(@RequestParam String name,@RequestParam String add,Map map) {
		System.out.println("name::"+name+" "+"Add::"+add);
		map.put("name",name);
		map.put("add", add);
		return "show_data";
	}
}
