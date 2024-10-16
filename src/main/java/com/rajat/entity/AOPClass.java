package com.rajat.entity;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AOPClass {
	
	@Bean
	public String getName() {//here getName() is JoinPoint
		System.out.println("AOPClass called");
//		System.out.println(5/0);//Inthis case AfterReturning will not called but AfterThrowing called
		return "AOP class";
	}
}
