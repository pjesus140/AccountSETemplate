package com.qa.persistence.repository;

public interface AccountRepository {

	String getAllAccounts();
	String createAccount(int accNum, String fName, String lName);
	String deleteAccount(long id);
	String updateAccount(long id, int accNum, String fName, String lName);

}
