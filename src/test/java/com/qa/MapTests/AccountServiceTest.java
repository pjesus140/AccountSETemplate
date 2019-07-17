package com.qa.MapTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.qa.exceptions.AccountNotFoundException;
import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountMapRepository;
import com.qa.persistence.repository.AccountRepository;
import com.qa.util.JSONUtil;

public class AccountServiceTest {

	private AccountMapRepository amr;
	private final String ACCOUNT_JSON_1 = "{\"id\":1,\"accountNumber\":\"ADC123\",\"firstName\":\"SCOOT\",\"lastName\":\"PACINO\"}";
	private final String ACCOUNT_JSON_2 = "{\"id\":1,\"accountNumber\":\"ADC123\",\"firstName\":\"CHAD\",\"lastName\":\"THUNDER\"}";

	private final Account ACCOUNT_1 = new Account(1, "ADC123", "SCOOT", "PACINO");

	private final JSONUtil JSON = new JSONUtil();

	@Before
	public void setup() {
		this.amr = new AccountMapRepository();
	}

	@Test
	public void addAccountTest() {
		assertEquals("Failed to add account", AccountRepository.SUCCESS, this.amr.createAccount(this.ACCOUNT_JSON_1));
	}

	@Test
	public void updateAccountTest() {
		this.amr.createAccount(this.ACCOUNT_JSON_1);
		assertEquals("Failed to update account", AccountRepository.SUCCESS,
				this.amr.updateAccount(1, this.ACCOUNT_JSON_2));
	}

	@Test
	public void removeAccountThatDoesntExistTest() {
		boolean exceptionThrown = false;
		try {
			this.amr.deleteAccount(4494);
		} catch (AccountNotFoundException anfe) {
			exceptionThrown = true;
		}
		assertTrue("Failed to throw exception", exceptionThrown);

	}

	@Test
	public void jsonStringToAccountConversionTest() {
		assertEquals("Failed to convert to Account from JSON", this.ACCOUNT_1,
				this.JSON.getObjectForJSON(this.ACCOUNT_JSON_1, Account.class));
	}

	@Test
	public void accountConversionToJSONTest() {
		assertEquals("Failed to convert to JSON", this.ACCOUNT_JSON_1, this.JSON.getJSONForObject(this.ACCOUNT_1));
	}

	@Test
	public void getCountForFirstNamesInAccountWhenZeroOccurances() {
		this.amr.createAccount(ACCOUNT_JSON_2);
		assertTrue("Not found empty collection", this.amr.findAccountsByFirstName("SCOOT").isEmpty());
	}

	@Test
	public void getCountForFirstNamesInAccountWhenOne() {
		this.amr.createAccount(ACCOUNT_JSON_1);
		this.amr.createAccount(ACCOUNT_JSON_2);
		assertEquals("Hasn't found exactly one account", 1, this.amr.findAccountsByFirstName("SCOOT").size());
	}

	@Test
	public void getCountForFirstNamesInAccountWhenTwo() {
		this.amr.createAccount(ACCOUNT_JSON_1);
		this.amr.createAccount(ACCOUNT_JSON_2);
		this.amr.createAccount(ACCOUNT_JSON_1);
		assertEquals("Hasn't found exactly one account", 2, this.amr.findAccountsByFirstName("SCOOT").size());
	}

}
