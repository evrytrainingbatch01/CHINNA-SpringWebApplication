package com.evry.model;

public class Account {

	private int aid;
	private int accountNumber;
	private String accountName;
	private String bankName;
	private String branchName;
	private int balance;
	
	public Account() {
		super();
	}

	public Account(int aid, int accountNumber, String accountName, String bankName, String branchName, int balance) {
		super();
		this.aid = aid;
		this.accountNumber = accountNumber;
		this.accountName = accountName;
		this.bankName = bankName;
		this.branchName = branchName;
		this.balance = balance;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
	
	
}
