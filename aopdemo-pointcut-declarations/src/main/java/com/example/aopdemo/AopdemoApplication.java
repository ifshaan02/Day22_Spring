package com.example.aopdemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.aopdemo.dao.AccountDAO;
import com.example.aopdemo.dao.MembershipDAO;
import com.example.aopdemo.service.TrafficService;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO
			, TrafficService theTrafficService) {
		return runner -> {
			// demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);
			// demoTheAfterReturningAdvice(theAccountDAO);
			// demoTheAfterThrowingAdvice(theAccountDAO);
			// demoTheAfterAdvice(theAccountDAO);
			// demoTheAroundAdvice(theTrafficService);
			// demoTheAroundAdviceHandleException(theTrafficService);
			demoTheAroundAdviceRethrowException(theTrafficService);
		};
	}

	private void demoTheAroundAdviceRethrowException(TrafficService theTrafficService) {
		System.out.println("\n\nMain Program: demoTheAroundAdviceRethrowException");
		
		System.out.println("Calling getTraffic() ");
		
		boolean tripWire = true;
		String data = theTrafficService.getTraffic(tripWire);
		
		System.out.println("\nMy city traffic: " + data);
		
		System.out.println("Finished");
		
	}

	private void demoTheAroundAdviceHandleException(TrafficService theTrafficService) {
		System.out.println("\n\nMain Program: demoTheAroundAdviceHandleException");
		
		System.out.println("Calling getTraffic() ");
		
		boolean tripWire = true;
		String data = theTrafficService.getTraffic(tripWire);
		
		System.out.println("\nMy city traffic: " + data);
		
		System.out.println("Finished");
		
	}

	private void demoTheAroundAdvice(TrafficService theTrafficService) {
		System.out.println("\n\nMain Program: demoTheAroundAdvice");
		
		System.out.println("Calling getTraffic() ");
		
		String data = theTrafficService.getTraffic();
		
		System.out.println("\nMy city traffic: " + data);
		
		System.out.println("Finished");
		
	}

	private void demoTheAfterAdvice(AccountDAO theAccountDAO) {
		List<Account> theAccounts = null;
		
		try {
			
			// boolean flag to simulate exception
			boolean tripWire = false;
			
			
			theAccounts = theAccountDAO.findAccounts(tripWire);
		} 
		
		catch (Exception exc) {
			System.out.println("\n\nMain Program: caught exception: " + exc);
		}
		theAccountDAO.findAccounts();
		
		System.out.println("\n\nMain Program: demoTheAfterThrowingAdvice");
		System.out.println("---");
		System.out.println(theAccounts);
		System.out.println("\n");
		
	}

	private void demoTheAfterThrowingAdvice(AccountDAO theAccountDAO) {
		List<Account> theAccounts = null;
		
		try {
			
			// boolean flag to simulate exception
			boolean tripWire = true;
			
			
			theAccounts = theAccountDAO.findAccounts(tripWire);
		} 
		
		catch (Exception exc) {
			System.out.println("\n\nMain Program: caught exception: " + exc);
		}
		theAccountDAO.findAccounts();
		
		System.out.println("\n\nMain Program: demoTheAfterThrowingAdvice");
		System.out.println("---");
		System.out.println(theAccounts);
		System.out.println("\n");
		
	}

	private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO) {
		// call method to find accounts
		
		List<Account> theAccounts = theAccountDAO.findAccounts();
		
		System.out.println("\n\nMain Program: demoTheAfterReturningAdvice");
		System.out.println("---");
		System.out.println(theAccounts);
		System.out.println("\n");
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
		
		Account myAccount = new Account();
		myAccount.setName("Nikki");
		myAccount.setLevel("Platinum");
		theAccountDAO.addAccount(myAccount, true);
		
		theAccountDAO.doWork();
		
		// call getter/setter
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");
		
		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();
		
		
		
		theMembershipDAO.addSillyMember();
		
		theMembershipDAO.goToSleep();
		
		
		
	}

}
