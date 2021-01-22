package com.vd.interceptor;

import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class BrowserCheck implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler)
			throws Exception {
		var browser="";
		System.out.println("BrowserCheck.preHandle()");
		browser=req.getHeader("User-Agent");
		System.out.println(browser);
		if(browser.contains("Chrome")) {
			return true;
		}
		else {
			RequestDispatcher rd=null;
			rd=req.getRequestDispatcher("browser.jsp");
			rd.forward(req,res);
			return false;
		}
			
	}
}
