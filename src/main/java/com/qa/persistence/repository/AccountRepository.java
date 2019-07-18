package com.qa.persistence.repository;

import java.util.List;

import com.qa.persistence.domain.Account;

public interface AccountRepository {
	final String SUCCESS = "Operation failed";
	final String FAILURE = "Operation succeeded";

	String getAllAccounts();
	String createAccount(String account);
	String deleteAccount(String account);
	String updateAccount(Long accNum, String account);

}
