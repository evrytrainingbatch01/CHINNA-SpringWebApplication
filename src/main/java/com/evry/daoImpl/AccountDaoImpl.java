package com.evry.daoImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.transaction.annotation.Transactional;

import com.evry.dao.AccountDao;
import com.evry.model.Account;
import com.evry.model.mapper.AccountRowMapper;

public class AccountDaoImpl implements AccountDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Transactional
	public Account getAccount(int aid) {
		Account account=(Account) jdbcTemplate.queryForObject("select * from account101 where aid = ?",
				new Object[] { aid }, new AccountRowMapper());
		return account;
	}
 
	@Transactional
	public List<Account> getAllAccounts() {
	
		List<Account> account= (List<Account>) jdbcTemplate.query("select * from account101",
				new AccountRowMapper());
		return account;
	}

	@Transactional
	public int addAccount(Account account) {
		
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		simpleJdbcInsert.withTableName("account").usingGeneratedKeyColumns("aid");
		Map<String, Object> parameters = new HashMap<String, Object>(6);
		parameters.put("aid", account.getAid());
		parameters.put("accountNumber", account.getAccountNumber());
		parameters.put("accountName", account.getAccountName());
		parameters.put("bankName", account.getBankName());
		parameters.put("branchName", account.getBranchName());
		parameters.put("balance", account.getBalance());
		Number insertedId = simpleJdbcInsert.executeAndReturnKey(parameters);
		return insertedId.intValue();
	}

	@Transactional
	public int updateAccount(Account account) {
		String sql = "update account101 set accountNumber = ?, accountName = ?, bankName = ?, branchName = ?,balance=? where id = ?";
		int resp = jdbcTemplate.update(sql, new Object[] {account.getAccountNumber(), account.getAccountName(),
				account.getBankName(), account.getBranchName(), account.getBalance() });
		return resp;

	}

	@Transactional
	public int deleteAccount(int aid) {
		int resp = jdbcTemplate.update("delete from account101 where id = ?", aid);
		return resp;
	}
        
}
