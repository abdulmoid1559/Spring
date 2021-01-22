package com.vd.initializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.vd.config.RootAppConfig;
import com.vd.config.WebMVCConfig;

public class DispatcherServletIntialiser implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext ctx) throws ServletException {
		//create parent container
		AnnotationConfigWebApplicationContext pcfg=new AnnotationConfigWebApplicationContext();
		pcfg.register(RootAppConfig.class);
		ContextLoaderListener listener=new ContextLoaderListener( pcfg);
		//create  child container
		AnnotationConfigWebApplicationContext context=new AnnotationConfigWebApplicationContext();
		context.register(WebMVCConfig.class);
		
		//create Ds Obj
		DispatcherServlet ds=new DispatcherServlet(context);
		ServletRegistration.Dynamic dyna=ctx.addServlet("dispatcher", ds);
		dyna.addMapping("/");
		dyna.setLoadOnStartup(2);
	}

}
