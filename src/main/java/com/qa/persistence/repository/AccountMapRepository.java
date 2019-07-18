package com.qa.persistence.repository;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.awt.List;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Alternative;

import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

@Alternative
public class AccountMapRepository implements AccountRepository {
	
	
	private JSONUtil json = new JSONUtil();

	Map<Long, Account> accountMap = new HashMap<Long, Account>();

	// You must provide concrete implementation for each of these methods
	// do not change the method signature
	// THINK - if the parameter is a String, or the return type is a String
	// How can I convert to a String from an Object?
	// What utility methods do I have available?

	// You must complete this section using TDD
	// You can use the suggested tests or build your own.

	public String getAllAccounts() {

		for (Long n : accountMap.keySet()) {
			System.out.println("id: " + n.toString() + "\n: " + ((Account) accountMap.get(n)).getAccNum()
					+ "\nFirst name: " + ((Account) accountMap.get(n)).getfName() + "\nLast name: "
					+ ((Account) accountMap.get(n)).getlName());
		}
		return "";
	}

	private long count = 1;
	
	
	

//	public String createAccount(int accNum, String fName, String lName) {
//		Account a = new Account(accNum, fName, lName);
//		a.setId((int) count);
//		accountMap.put(count, a);
//		count++;
//		return a.getfName() + " " + a.getlName() + " Account created";
//	}

//	public String deleteAccount(long id) {
//
//		accountMap.remove(id);
//
//		return null;
//	}

//	public String updateAccount(long id, int accNum, String fName, String lName) {
//		Account a = new Account(accNum, fName, lName);
//		a.setId((int) id);
//		accountMap.replace(id, a);
//
//		return null;
//	}

	public String toJson(long a) {
		ObjectMapper mapper = new ObjectMapper();

		try {

			String jsonString = mapper.writeValueAsString(accountMap);
			System.out.println(jsonString);
			return jsonString;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}

	public int sameNames(String fName) {

		int count = 0;

		for (Long y : accountMap.keySet()) {
			if (accountMap.get(y).getfName().equals(fName)) {
				count++;
			}
		}
		System.out.println("Fist name: " + fName + "\nAppears:" + count + "x");
		return count;

	}

	

	// public void toObj(String jsonString) {
	// ObjectMapper mapper = new ObjectMapper();
	//
	// try {
	//
	//
	//
	// // Java objects to JSON string - compact-print
	// Account staff2 = mapper.readValue(jsonString, Account.class);
	//
	// System.out.println(staff2);
	//
	//
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	//
	// }
	
	
	
	public String createAccount(String account) {
		Account toAdd = this.json.getObjectForJSON(account, Account.class);
		this.accountMap.put((long) toAdd.getId(), toAdd);
		if (this.accountMap.containsValue(toAdd)) {
			return SUCCESS;
		} else {
			return "Failed to add account";
		}
	}
	
	public String deleteAccount(int id) {
//		Account toUpdate = this.json.getObjectForJSON(account, Account.class);
//		int key = toUpdate.getId();
//		accountMap.remove(key);

		return null;
	}
	
	
	
	
	public String updateAccount(int id, String account) {
//		Account toUpdate = this.json.getObjectForJSON(account, Account.class);
//		this.accountMap.replace(accNum, toUpdate);
//		if (this.accountMap.containsValue(toUpdate)) {
//			return FAILURE;
//		} else {
//			return "Failed to add account";
//		}
		return null;
	}

}
