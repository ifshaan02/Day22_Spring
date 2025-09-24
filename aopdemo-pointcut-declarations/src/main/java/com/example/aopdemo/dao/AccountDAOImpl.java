package com.example.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.aopdemo.Account;

@Repository
public class AccountDAOImpl implements AccountDAO{

	private String name;
	
	private String serviceCode;
	
	
	
	@Override
	public void addAccount(Account theAccount, boolean vipFlag) {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
		
	}

	@Override
	public boolean doWork() {
		System.out.println(getClass() + ": doWork()");
		return false;
	}

	public String getName() {
		System.out.println(getClass() + ": in getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ": in setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ": in getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": setServiceCode()");
		this.serviceCode = serviceCode;
	}

	@Override
	public List<Account> findAccounts() {
		return findAccounts(false);
	}

	@Override
	public List<Account> findAccounts(boolean tripWire) {
		if (tripWire) {
			throw new RuntimeException("Exception found!");
		}
		
		List<Account> myAccounts = new ArrayList<>();
		
		// create sample accounts and add to list
		
		Account temp1 = new Account("Nikki", "Platinum");
		Account temp2 = new Account("Chotu", "Silver");
		Account temp3 = new Account("Sanah", "Platinum");
		Account temp4 = new Account("Samah", "Gold");
		
		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);
		myAccounts.add(temp4);
		
		return myAccounts;
	}
	
	
	

}
