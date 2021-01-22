package com.vd.aspect;

import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAspect {
	private static Logger log=Logger.getLogger(LoggingAspect.class);
	
	static {
		try {
		PropertyConfigurator.configure("src/main/java/com/vd/common/log4j-Logging.properties");
		log.info("log4j Activated");
		}
		catch (Exception e) {
			log.fatal("Unknown Exception");
			e.printStackTrace();
		}
		
	}

	public Object logging(ProceedingJoinPoint point) throws Throwable {
		Object retVal;
		log.debug("Enterring into "+point.getSignature()+" at "+new Date());
		retVal=point.proceed();
		log.debug("Exiting form"+point.getSignature()+" at "+new Date());
		return retVal;
	}
}
