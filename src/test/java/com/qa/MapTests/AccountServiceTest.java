package com.qa.MapTests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountMapRepository;

public class AccountServiceTest {
	

	@Before
	public void setup() {
	
	}
	
	@Test
	public void addAccountTest() {
		AccountMapRepository amr = new AccountMapRepository();
		assertEquals("hmmm","jim bam Account created",amr.createAccount( 123, "jim", "bam"));
		
	}
	
	@Test
	public void add2AccountsTest() {
		fail("TODO");	
	}

	@Test
	public void removeAccountTest() {
		fail("TODO");	
	}
	
	@Test
	public void remove2AccountsTest() {
		fail("TODO");	
	}
	
	@Test
	public void remove2AccountTestAnd1ThatDoesntExist() {
		fail("TODO");	
	}
	
	@Test
	public void jsonStringToAccountConversionTest() {
		// testing JSONUtil
		fail("TODO");	
	}


	@Test
	public void accountConversionToJSONTest() {
		//testing JSONUtil
		fail("TODO");	
	}

	@Test
	public void getCountForFirstNamesInAccountWhenZeroOccurances() {
		AccountMapRepository amr = new AccountMapRepository();
		amr.createAccount( 123, "jim", "bam");
		amr.createAccount( 321, "james", "topson");
		amr.createAccount( 563, "sam", "biggs");
		amr.createAccount( 123, "jim", "bambo");
		
		assertEquals("hmmm",0,amr.sameNames("jake"));
		
		
	}
	
	@Test
	public void getCountForFirstNamesInAccountWhenOne() {
		AccountMapRepository amr = new AccountMapRepository();
		amr.createAccount( 123, "jim", "bam");
		amr.createAccount( 321, "james", "topson");
		amr.createAccount( 563, "sam", "biggs");
		amr.createAccount( 123, "jim", "bambo");
		
		assertEquals("hmmm",1,amr.sameNames("sam"));
	}

	@Test
	public void getCountForFirstNamesInAccountWhenTwo() {
		
		AccountMapRepository amr = new AccountMapRepository();
		amr.createAccount( 123, "jim", "bam");
		amr.createAccount( 321, "james", "topson");
		amr.createAccount( 563, "sam", "biggs");
		amr.createAccount( 123, "jim", "bambo");
		
		assertEquals("hmmm",2,amr.sameNames("jim"));
	}

}
