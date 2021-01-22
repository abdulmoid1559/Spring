package com.vd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.vd.service.WishMessageService;

public class WishMessageController extends AbstractController {
	private WishMessageService service;
	public WishMessageController(WishMessageService service) {
		this.service=service;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		var msg=new String();
		msg=service.GenerateWishMessage();
		
		return new ModelAndView("result" ,"wmsg",msg);
	}

}
