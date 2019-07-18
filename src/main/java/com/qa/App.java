package com.qa;

import com.qa.persistence.repository.AccountDBRepo;
import com.qa.persistence.repository.AccountMapRepository;

public class App {

	public static void main(String[] args) {



		AccountMapRepository amr = new AccountMapRepository();
		System.out.println(amr.createAccount( 123, "jim", "bam"));
		System.out.println(amr.createAccount( 321, "james", "topson"));
		System.out.println(amr.createAccount( 563, "sam", "biggs"));
		System.out.println(amr.createAccount( 123, "jim", "bambo"));
		
		AccountDBRepo adb = new AccountDBRepo();
		
		
//		
//		amr.getAllAccounts();
//		
//		amr.updateAccount(3, 987, "ana", "smith");
//		
//		amr.getAllAccounts();
		
//		amr.deleteAccount(1);
//		amr.getAllAccounts();
//		String strx = (amr.toJson(1));
//		
//		
//		amr.sameNames("jim");

//		amr.toObj(strx);
		
		//hmm
	}

}
