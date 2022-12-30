package com.api.AuthEcommerc.service;

import java.util.List;

import com.api.AuthEcommerc.model.Account;

public interface AccountService {
	
	Account createAccount(Account account);
	Account findByUsername(String username);
	List<Account> findAllAccounts();

}
