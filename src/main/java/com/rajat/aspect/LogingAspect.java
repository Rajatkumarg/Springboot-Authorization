package com.rajat.aspect;

import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Component
@Aspect
public class LogingAspect {

	private Log LOGGER = LogFactory.getLog(LogingAspect.class);
	
	@After("execution(* com.rajat.entity.AOPClass.getName(..))")
	public void adviceMethodAfter() throws Exception {
		LOGGER.info("LogingAspect After called");
	}
	
	@Before("execution(* com.rajat.entity.AOPClass.getName(..))")
	public void adviceMethodBefore(JoinPoint joinPoint) throws Exception {
		LOGGER.info("LogingAspect Before called "+joinPoint.getSignature());
	}
	
	@AfterReturning(pointcut = "execution(* com.rajat.entity.AOPClass.getName(..))", returning="returnVal")
	public void adviceMethodAfterReturning(Object returnVal) throws Exception {
		LOGGER.info("LogingAspect AfterReturning called "+returnVal);
	}
	
	@AfterThrowing(pointcut = "execution(* com.rajat.entity.AOPClass.getName(..))", throwing ="exc")
	public void adviceMethodAfterReturning(Exception exc) throws Exception {
		LOGGER.error("LogingAspect AfterThrowing called "+exc);
	}
	
	@Pointcut(value = "execution(* com.rajat.entity.AOPClass.getName(..))")
	private void pointCutExp() {
		
	}
	@Around("pointCutExp()")
	public Object adviceMethodAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		LOGGER.error("LogingAspect Around called ");
		long startTime = System.currentTimeMillis();
		LOGGER.info("start time "+startTime);
		
		Object returnValue = proceedingJoinPoint.proceed();
		
		long timeTaken = System.currentTimeMillis() - startTime;
		LOGGER.info("Total time taken "+timeTaken);
		
		return returnValue;
	}
}
