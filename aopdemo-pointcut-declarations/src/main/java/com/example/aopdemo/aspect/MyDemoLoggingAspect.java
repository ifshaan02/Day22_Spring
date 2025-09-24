package com.example.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	
	@Around("execution(* com.example.aopdemo.service.*.getTraffic(..))")
	public Object aroundGetTraffic(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		
		// method we are advising on
		
		String method = theProceedingJoinPoint.getSignature().toShortString();
		System.out.println("\n====>>> Executing @Around on method: " + method);
		
		
		// begin timestamp
		// long begin = System.currentTimeMillis();
		
		long begin = System.nanoTime();
		Object result = null;
		
		try {
			
			result = theProceedingJoinPoint.proceed();
		} 
		
		catch (Exception exc) {
			// log the exception
			System.out.println(exc.getMessage());
			
			// rethrow
			
			throw exc;
		}
		
		
		// long end = System.currentTimeMillis();
		
		long end = System.nanoTime();
		
		long duration = end - begin;
		
		System.out.println("\n======> Duration: " + duration / 1000.0 + " nano seconds");
		
		return result;
	}
	
	
	@After("execution(* com.example.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n====>>> Executing @After on method: " + method);
		
		
	}
	
	
	@AfterThrowing(
			pointcut = "execution(* com.example.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing = "theExc")
	public void afterThrowingingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {
		
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n====>>> Executing @AfterThrowing on method: " + method);
		
		// log the exception
		System.out.println("\n====>>> The exception is : " + theExc);
		
	}
	
	// add a new advice for @AfterReturning on findAccounts
	
	@AfterReturning(
			pointcut = "execution(* com.example.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
		
		
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n====>>> Executing @AfterReturning on method: " + method);
		
		// print out the results of the method call
		System.out.println("\n====>>> result is: " + result);
		
		// post process the data and modify it		
		// convert the account names to uppercase
		convertAccountNamesToUpperCase(result);
		
		System.out.println("\n====>>> result is: " + result);
	}

	private void convertAccountNamesToUpperCase(List<Account> result) {
		// loop through accounts
		
		for (Account tempAccount : result) {
			
			//get uppercase of name
			String theUpperName = tempAccount.getName().toUpperCase();
			
			
			// update the name
			tempAccount.setName(theUpperName);
		}
		
	}

	// @Before("execution(public void add*())")
	@Before("com.example.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n=====>>> Executing @Before advice on addAccount() ");
	
		
		// display method signature and arguments
		
		MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
		
		System.out.println("Method: " + methodSignature);
		
		
		// get args
		Object[] args = theJoinPoint.getArgs();
		
		
		// loop through them
	
		for (Object tempArg : args) {
			System.out.println(tempArg);
			
			if (tempArg instanceof Account) {
				// downcast and print account specific stuff
				
				Account theAccount = (Account) tempArg;
				
				System.out.println("Account name: " + theAccount.getName());
				System.out.println("Account level: " + theAccount.getLevel());
			}
		}
	
	
	}
	
	
}
