package com.vd.controller;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	@GetMapping("/home")
	public String genrateHomePage() {
		return "home";
	}
	
	@GetMapping("/getData")
	public String getData(Model model) {
		String [] names= {"moid","Mosin"};
		Set<Long> phoneNo= Set.of(9874664L,9087574L);
		List<String> course=List.of("Java","C++");
		model.addAttribute("name",names);
		model.addAttribute("phoneNo", phoneNo);
		model.addAttribute("course", course);
		return "displayinfo";
	}
}
