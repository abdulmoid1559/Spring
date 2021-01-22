package com.vd.aspect;








import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.aspectj.lang.JoinPoint;

public class ExceptionLoggerAspect {
	private static Logger logger=Logger.getLogger(ExceptionLoggerAspect.class);
	
	static {
		try {
		PropertyConfigurator.configure("src/main/java/com/vd/commons/log4j.properties");
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	public void exceptionLogger(JoinPoint jp,Exception ex) {
		System.out.println("ExceptionLoggerAspect.exceptionLogger()");
		logger.fatal(ex+"Exception raised in "+jp.getSignature());
	}
}
