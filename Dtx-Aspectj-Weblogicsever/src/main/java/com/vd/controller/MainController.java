package com.vd.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vd.service.BankService;

/**
 * Servlet implementation class MainController
 */
@WebServlet("/controllerurl")
public class MainController extends HttpServlet {
	private ApplicationContext context;
    public MainController() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
		context=new ClassPathXmlApplicationContext("com/vd/cfgs/applicationContext.xml");
	}

	public void destroy() {
		((AbstractApplicationContext) context).close();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Long srcAccNo,destAccNo;
		Double amt;
		BankService service;
		String msg=null;
		RequestDispatcher  rd;
		
		srcAccNo=Long.parseLong(req.getParameter("srcAcc"));
		destAccNo=Long.parseLong(req.getParameter("destAcc"));
		amt=Double.parseDouble(req.getParameter("amt"));
		try {
		service=context.getBean("service",BankService.class);
		msg=service.moneyTransfer(srcAccNo, destAccNo, amt);
		req.setAttribute("result", msg);
		}
		catch(Exception e) {
			req.setAttribute("result", e);
			e.printStackTrace();
		}
		rd=req.getRequestDispatcher("result.jsp");
		rd.forward(req, res);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
