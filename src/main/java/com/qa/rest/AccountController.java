package com.qa.rest;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.PostUpdate;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

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

	@DELETE
	@Path("/delete/{id}")
	public String deleteAccount(@PathParam("id") int id) {
		return this.service.deleteAccount(id);
	}

	@POST
	@Path("/update/{id}")
	public String updateAccount(@PathParam("id") int id, String account) {
		return this.service.updateAccount(id, account);
	}

	@GET
	@Path("/findFName/{fName}")
	public List<Account> findAccountsByFirstName(@PathParam("fName") String fName) {
		return this.service.findAccountsByFirstName(fName);
	}

}
