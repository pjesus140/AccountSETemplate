package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {

	// This class needs to have:
	// An id
	// An Account Number
	// A First Name
	// A last Name
	public Account(int accNum, String fName, String lName) {
		this.accNum = accNum;
		this.fName = fName;
		this.lName = lName;

	}
	
	public Account() {
		super();

	}

	

	@Override
	public String toString() {
		return "Account [accNum=" + accNum + ", fName=" + fName + ", lName=" + lName + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int accNum;
	private String fName;
	private String lName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAccNum() {
		return accNum;
	}

	public void setAccNum(int accNum) {
		this.accNum = accNum;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

}
