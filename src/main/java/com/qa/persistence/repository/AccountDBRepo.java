package com.qa.persistence.repository;

import java.util.List;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

@Transactional(value = TxType.REQUIRED)@Default
public class AccountDBRepo implements AccountRepository {
	
	@Inject
	private JSONUtil json;

	@PersistenceContext(unitName = "primary")
	private EntityManager em;

//	public String createAccount(int accNum, String fName, String lName) {
//
//		Account newAcc = new Account(accNum, fName, lName);
//		em.persist(newAcc);
//		return null;
//	}

	public String createAccount(String account) {

		Account toAdd = this.json.getObjectForJSON(account, Account.class);
		em.persist(toAdd);
		return null;
	}

	@Transactional(value = TxType.SUPPORTS)
	public String getAllAccounts() {

		TypedQuery<Account> query = em.createQuery("SELECT m FROM Account m ORDER     	 BY m.ID DESC", Account.class);
		System.out.println(query.getResultList());
		return null;

	}

//	public String deleteAccount(long id) {
//
//		Account delAcc = em.find(Account.class, id);
//		em.remove(delAcc);
//
//		return null;
//	}
	
	public String deleteAccount(String account) {
		Account toDel = this.json.getObjectForJSON(account, Account.class);
		Account delAcc = em.find(Account.class, toDel.getId());
		em.remove(delAcc);

		return null;
	}

//	public String updateAccount(long id, int accNum, String fName, String lName) {
//
//		Account upAcc = em.find(Account.class, id);
//		upAcc.setAccNum(accNum);
//		upAcc.setfName(fName);
//		upAcc.setlName(lName);
//		em.persist(upAcc);
//
//		return null;
//	}
	
	
	public String updateAccount(Long accNum,String account) {
		Account toUp = this.json.getObjectForJSON(account, Account.class);
		Account upAcc = em.find(Account.class, accNum);
		upAcc.setAccNum(toUp.getAccNum());
		upAcc.setfName(toUp.getfName());
		upAcc.setlName(toUp.getlName());
		em.persist(upAcc);
		

		return null;
	}
	public List<Account> findAccountsByFirstName(String fName){
		
//		Account nameAcc = em.find(Account.class, firstName);
		TypedQuery<Account> query = this.em.createQuery("SELECT a FROM Account a WHERE a.fName = :fName",
				Account.class);
		query.setParameter("fName", fName);
		return query.getResultList();
	}

}
