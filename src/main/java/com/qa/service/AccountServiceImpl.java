package com.qa.service;

import java.util.List;

import javax.inject.Inject;

import com.qa.exceptions.AccountNotFoundException;
import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountRepository;

public class AccountServiceImpl implements AccountService {

	@Inject
	private AccountRepository repo;

	
	public String getAllAccounts() {
		return this.repo.getAllAccounts();
	}

	
	public String createAccount(String account) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public String deleteAccount(int id) throws AccountNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public String updateAccount(int id, String account) throws AccountNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Account> findAccountsByFirstName(String fName) throws AccountNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public List<Account> findAccountsByFirstName(String firstName) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
