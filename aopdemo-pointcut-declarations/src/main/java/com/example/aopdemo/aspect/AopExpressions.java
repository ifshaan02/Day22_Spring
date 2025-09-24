package com.example.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {
	
	@Pointcut("execution(* com.example.aopdemo.dao.*.*  (..))")
	public void forDaoPackage() {}
	
	// for getter
	@Pointcut("execution(* com.example.aopdemo.dao.*.get*  (..))")
	public void getter() {}
	
	// for setter
	@Pointcut("execution(* com.example.aopdemo.dao.*.set*  (..))")
	public void setter() {}
	
	// exclude getter and setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {}

}
