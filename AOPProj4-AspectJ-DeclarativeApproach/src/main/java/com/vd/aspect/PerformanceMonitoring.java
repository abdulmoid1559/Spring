package com.vd.aspect;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.aspectj.lang.ProceedingJoinPoint;

public class PerformanceMonitoring {
	private static Logger log=Logger.getLogger(PerformanceMonitoring.class);
	
	static {
		try {
		PropertyConfigurator.configure("src/main/java/com/vd/common/log4j-PerformanceMointoring.properties");
		log.info("Log4j activated");
		}
		catch (Exception e) {
			log.fatal("unknown");
		}
	} 
	public Object monitor(ProceedingJoinPoint point) throws Throwable {
		Object retVal=null;
		long start=0,end=0;
		
		start=System.currentTimeMillis();
		retVal=point.proceed();
		end=System.currentTimeMillis();
		log.debug(point.getSignature()+"has taken"+(end-start));
		return retVal;
	}
}
