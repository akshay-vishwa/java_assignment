package com.example.demo.advices;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import lombok.extern.slf4j.Slf4j;


@Configuration
@Aspect
@EnableAspectJAutoProxy
@Slf4j
public class Advices {

	@Around("execution (* com.example.demo.services.TourService.*(..))")
	public Object specialOffer(ProceedingJoinPoint pjp) throws Throwable {
		
		log.info("invoking :>"+pjp.getSignature().getName());
		long start = System. currentTimeMillis();
		Object obj =pjp.proceed();
		long endTime =System. currentTimeMillis() - start;
		System.out.println("The time taken to execute: "+endTime);
		return obj;
	}
	
	@Before("execution (* com.example.demo.services.TourController.findAll())")
	public void LogMessages(JoinPoint jp) {
		
		log.info("invoking :>"+jp.getSignature().getName());
	}
}
