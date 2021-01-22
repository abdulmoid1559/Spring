package com.vd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.vd.model.Student;

@Controller
public class StudentController {
	@GetMapping("/registerstudent")
	public String generateRegisterPage(Model map,@ModelAttribute Student stud) {
		return "registerstud";
		
	}
	@PostMapping("/registerstudent")
	public String registerStud(@ModelAttribute Student stud,BindingResult errors,Model model) {
		model.addAttribute("stud", stud);
		return "sucess";
	}
	@GetMapping("/home")
	public String generateHomepage(Model model) {
		return "home.html";
	}
}
