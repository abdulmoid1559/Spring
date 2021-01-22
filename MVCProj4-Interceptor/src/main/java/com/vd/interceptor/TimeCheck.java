package com.vd.interceptor;

import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class TimeCheck implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler)
			throws Exception {
		var hour=Calendar.HOUR_OF_DAY;
		System.out.println("TimeCheck.preHandle()");
		if(hour<9 && hour>17) {
			RequestDispatcher rd=req.getRequestDispatcher("timeout.jsp");
			rd.forward(req, res);
			return false;
		}
		else {
			return true;
		}
	}
}
