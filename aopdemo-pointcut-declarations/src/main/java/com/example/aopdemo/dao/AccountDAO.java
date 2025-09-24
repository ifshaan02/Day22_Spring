package com.example.aopdemo.dao;

import java.util.List;

import com.example.aopdemo.Account;

public interface AccountDAO {

	List<Account> findAccounts();
	
	List<Account> findAccounts(boolean tripWire);
	
	void addAccount(Account theAccount, boolean vipFlag);
	
	boolean doWork();
	
	public String getName();

	public void setName(String name);

	public String getServiceCode();

	public void setServiceCode(String serviceCode);

	
	
}
