package com.qa.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.qa.persistence.domain.Account;
import com.qa.service.AccountService;

@Path("/account")
public class AccountController {

	@Inject
	private AccountService service;

	@GET
	@Path("/getAll")
	public String getAllAccounts() {
		return this.service.getAllAccounts();
	}
	
	@POST
	@Path("/create")
	public String createAccount(String account) {
		return this.service.createAccount(account);
	}
	@POST
	@Path("/delete")
	public String deleteAccount(int id) {
		return this.service.deleteAccount(id);
	}
	
	@POST
	@Path("/update")
	public String updateAccount(int id, String account) {
		return this.service.updateAccount(id,account);
	}
	
	@GET
	@Path("/findFName")
	public List<Account> findAccountsByFirstName(String fName) {
		return this.service.findAccountsByFirstName(fName);
	}

}
