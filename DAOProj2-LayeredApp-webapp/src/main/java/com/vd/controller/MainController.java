package com.vd.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.vd.service.EmployeeMgmtService;
import com.vd.service.EmployeeMgmtServiceImpl;

@WebServlet("controller")
public class MainController extends HttpServlet {
	EmployeeMgmtService service=null;
    
    @Override
    public void init() throws ServletException {
    	super.init();
    	ApplicationContext ctx=null;
    	ctx=new ClassPathXmlApplicationContext("com/vd/cfg/ApplicationContext.xml");
    	service=ctx.getBean("service",EmployeeMgmtServiceImpl.class);
    }

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String desg[]=null;
		List<Map<String,Object>> listMap=null;
		RequestDispatcher rd=null;
		
		try {
		//read the form value
		desg=request.getParameterValues("job");
		//Call service Class Method
		listMap=service.getEmployeebyDesg(desg);
		//put it into requset scope
		request.setAttribute("listOfEmployee", listMap);
		//forword request to result.jsp
		rd=request.getRequestDispatcher("/result.jsp");
		rd.forward(request, response);
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
			// keep Exception object in request scope
			request.setAttribute("dae", dae.getMessage());
			rd=request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		}//catch
		
	}//doget

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
