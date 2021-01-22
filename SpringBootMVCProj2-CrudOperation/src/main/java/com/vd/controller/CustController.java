package com.vd.controller;

import java.util.Map;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vd.dto.CustomerDTO;
import com.vd.model.Customer;
import com.vd.service.CustomerService;
import com.vd.validator.CustomerValidator;

@Controller
public class CustController {
	@Autowired
	private CustomerValidator validate;
	@Autowired
	private CustomerService cservice;
		//this Method is generating customer registration page
	@GetMapping("/register")
	public String registerCustomerForm(@ModelAttribute Customer dto,BindingResult errors) {
		return "registerCustomer";
	}
	
	//this method for processing register request
	@PostMapping("/register")
	public String registerCustomer(RedirectAttributes map,@Valid @ModelAttribute Customer model,BindingResult error) {
		String msg=null;
		CustomerDTO dto=new CustomerDTO();
		if(validate.supports(Customer.class))
			validate.validate(model, error);
		if(error.hasErrors()) {
			return "registerCustomer";
		}
		if(error.hasErrors()) {
			validate.validate(model, error);
		}
		BeanUtils.copyProperties(model, dto);
		msg=cservice.registerCustomer(dto);
		map.addFlashAttribute("msg", msg);
		return "redirect:home";
	}
	
	//this method shows all customer from db table
	@GetMapping("/allcustomer")
	public String getAllCustomer(Map map) {
		Set<CustomerDTO> custList=null;
		custList=cservice.getAllCustomer();
		map.put("custList", custList);
		
		return "allcustomers";
	}
	@GetMapping("/editcust")
	public String updatePageGenerate(@ModelAttribute Customer cust,@RequestParam Integer cid) {
		CustomerDTO dto=null;
		dto=cservice.getCustomerById(cid);
		BeanUtils.copyProperties(dto, cust);
		
		return "updatecustomer";
	}
	@PostMapping("/editcust")
	public String updateCustomer(@Valid @ModelAttribute Customer cust,RedirectAttributes map,BindingResult errors) {
		var msg="";
		CustomerDTO dto=new CustomerDTO();
		if(validate.supports(Customer.class))
			System.out.println("CustController.updateCustomer()");
			validate.validate(cust, errors);
		if(errors.hasErrors())
			return "updatecustomer";
		BeanUtils.copyProperties( cust,dto);
		msg=cservice.updateCustomerById(dto);
		System.out.println(msg);
		map.addFlashAttribute("message", msg);
		return "redirect:allcustomer";
	}
	@GetMapping("/deletecust")
	public String deleteCustomer(RedirectAttributes map,@RequestParam("cid") Integer id) {
	
		String msg=cservice.deleteCustomer(id);
		System.out.println(msg);
		map.addFlashAttribute("msg",msg);
		return"redirect:allcustomer";
	}
}
