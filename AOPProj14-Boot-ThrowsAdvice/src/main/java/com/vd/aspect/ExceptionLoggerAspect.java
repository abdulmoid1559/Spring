package com.vd.aspect;








import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
@Component
@Aspect
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
	@AfterThrowing(pointcut = "execution(double com.vd.service.ShoppingStoreImpl.shopping(..))",throwing = "ex")
	public void exceptionLogger(JoinPoint jp,Exception ex) {
		System.out.println("ExceptionLoggerAspect.exceptionLogger()");
		logger.fatal(ex+"Exception raised in "+jp.getSignature());
	}
}
