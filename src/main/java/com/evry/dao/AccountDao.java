package com.evry.dao;

import java.util.List;

import com.evry.model.Account;

public interface AccountDao {

	public Account getAccount(int aid);

	public List<Account> getAllAccounts();

	public int addAccount(Account account);

	public int updateAccount(Account account);

	public int deleteAccount(int aid);
}
