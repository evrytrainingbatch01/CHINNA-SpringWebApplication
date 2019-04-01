package com.evry.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.evry.dao.AccountDao;
import com.evry.model.Account;
import com.evry.service.AccountService;

public class AccountServiceImpl implements AccountService {

	 @Autowired
	 private AccountDao accountdao;
	 
	 
	public AccountDao getAccountdao() {
		return accountdao;
	}

	public void setAccountdao(AccountDao accountdao) {
		this.accountdao = accountdao;
	}

	public Account getAccount(int aid) {
		return accountdao.getAccount(aid);
	}

	public List<Account> getAllAccounts() {
		// TODO Auto-generated method stub
		return accountdao.getAllAccounts();
	}

	public int addAccount(Account account) {
		// TODO Auto-generated method stub
		return accountdao.addAccount(account);
	}

	public int updateAccount(Account account) {
		// TODO Auto-generated method stub
		return accountdao.updateAccount(account);
	}

	public int deleteAccount(int aid) {
		// TODO Auto-generated method stub
		return accountdao.deleteAccount(aid);
	}

}
