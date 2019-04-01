package com.evry.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.evry.model.Account;

public class AccountRowMapper implements RowMapper<Account> {

	public Account mapRow(ResultSet rs, int row) throws SQLException {
		 Account ac=new Account();
		 ac.setAid(rs.getInt("aid"));
		 ac.setAccountNumber(rs.getInt("accountNumber"));
		 ac.setAccountName(rs.getString("accountName"));
		 ac.setBankName(rs.getString("bankName"));
		 ac.setBranchName(rs.getString("branchName"));
		 ac.setBalance(rs.getInt("balance"));
		
		return ac;
	}

}
