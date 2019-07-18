package com.qa.persistence.repository;

import java.util.List;

import com.qa.persistence.domain.Account;

public interface AccountRepository {
	final String SUCCESS = "Operation failed";
	final String FAILURE = "Operation succeeded";

	String getAllAccounts();
	String createAccount(int accNum, String fName, String lName);
	String deleteAccount(long id);
	String updateAccount(long id, int accNum, String fName, String lName);

}
