package com.example.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAsyncAspect {
	

	@Before("com.example.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void logToCLoudAsync() {
		System.out.println("\n=====>>> logging to CLoud in async fashion");
	}

}
