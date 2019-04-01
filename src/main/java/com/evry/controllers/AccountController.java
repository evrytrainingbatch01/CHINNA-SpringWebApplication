package com.evry.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.evry.model.Account;
import com.evry.service.AccountService;

@Controller
@RequestMapping("/")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value = "account/{aid}", method = RequestMethod.GET)
	public String getUserDetails(@PathVariable int aid, ModelMap userModel) {
		userModel.addAttribute("account", accountService.getAccount(aid));
		return "account";
	}
	
	@RequestMapping(value = "accounts", method = RequestMethod.GET)
	public String getUsersDetails(ModelMap userModel) {
		userModel.addAttribute("account", accountService.getAllAccounts());
		return "accounts";
	}
	
	@RequestMapping(value = "addAccount")
	public String addPage() {
		return "add";
	}
	
	@RequestMapping(value = "add/account", method = RequestMethod.POST)
	public String addAccount(@RequestParam(value = "accountNumber", required = true) int accountNumber,
			@RequestParam(value = "accountName", required = true) String accountName,
			@RequestParam(value = "bankName", required = true) String bankName,
			@RequestParam(value = "branchName", required = true) String branchName,
			@RequestParam(value = "balance", required = true) int balance,	ModelMap userModel) {
	   
		  Account account=new Account();
		  account.setAccountNumber(accountNumber);
		  account.setAccountName(accountName);
		  account.setBankName(bankName);
		  account.setBankName(branchName);
		  account.setBalance(balance);
		  
		int resp = accountService.addAccount(account);
		if (resp > 0) {
			userModel.addAttribute("msg", "Account with aid : " + resp + " added successfully.");
			userModel.addAttribute("account", accountService.getAllAccounts());
			return "accounts";
		} else {
			userModel.addAttribute("msg", "Account addition failed.");
			return "add";
		}
	}
	
	@RequestMapping(value = "delete/account/{aid}", method = RequestMethod.GET)
	public String deleteAccount(@PathVariable("aid") int aid, ModelMap userModel) {
		int resp = accountService.deleteAccount(aid);
		userModel.addAttribute("account", accountService.getAllAccounts());
		if (resp > 0) {
			userModel.addAttribute("msg", "account with aid : " + aid + " deleted successfully.");
		} else {
			userModel.addAttribute("msg", "account with aid : " + aid + " deletion failed.");
		}
		return "accounts";
	}
	
	@RequestMapping(value = "update/account/{aid}", method = RequestMethod.GET)
	public String updatePage(@PathVariable("aid") int aid, ModelMap userModel) {
		userModel.addAttribute("aid", aid);
		userModel.addAttribute("account", accountService.getAccount(aid));
		return "update";
	}
	
	@RequestMapping(value = "update/account", method = RequestMethod.POST)
	public String updateAccount(@RequestParam int aid, 
			@RequestParam(value = "accountNumber", required = true) int accountNumber,
			@RequestParam(value = "accountName", required = true) String accountName,
			@RequestParam(value = "bankName", required = true) String bankName,
			@RequestParam(value = "branchName", required = true) String branchName,
			@RequestParam(value = "balance", required = true) int balance,	ModelMap userModel) {
		
		 Account account=new Account();
		 account.setAccountNumber(accountNumber);
		 account.setAccountName(accountName);
		 account.setBankName(bankName);
		 account.setBankName(branchName);
		 account.setBalance(balance);
		  
		int resp = accountService.updateAccount(account);
		userModel.addAttribute("aid", aid);
		if (resp > 0) {
			userModel.addAttribute("msg", "Account with aid : " + aid + " updated successfully.");
			userModel.addAttribute("accountDetails", accountService.getAllAccounts());
			return "accounts";
		} else {
			userModel.addAttribute("msg", "account with aid : " + aid + " updation failed.");
			userModel.addAttribute("account", accountService.getAccount(aid));
			return "update";
		}
	}
}
