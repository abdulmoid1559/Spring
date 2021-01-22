package com.vd.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.vd.model.Customer;

@Component("custValidator")
public class CustomerValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		System.out.println("CustomerValidator.supports()");
		return clazz.isAssignableFrom(Customer.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Customer cust=null;
		cust=(Customer)target;
		System.out.println("CustomerValidator.validate()");
		//checking value Of each property
		if(cust.getName()==null|| cust.getName().isEmpty()) 
			errors.rejectValue("name", "notempty.cust.name");
		if(cust.getAddress()==null|| cust.getAddress().isEmpty())
			errors.rejectValue("address",  "cust.address");
		if(cust.getContactNo()==null|| cust.getContactNo().toString().length()!=10)
			errors.rejectValue("contactNo",  "cust.contact");
	}

}
