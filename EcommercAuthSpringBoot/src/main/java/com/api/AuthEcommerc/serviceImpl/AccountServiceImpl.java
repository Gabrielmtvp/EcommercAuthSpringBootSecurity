package com.api.AuthEcommerc.serviceImpl;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.api.AuthEcommerc.model.Account;
import com.api.AuthEcommerc.repository.AccountRepository;
import com.api.AuthEcommerc.service.AccountService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{
	
//	private final PasswordEncoder encoder;
	private final AccountRepository accountRepository;

	@Override
	public Account createAccount(Account account) {
//		account.setPassword(encoder.encode(account.getPassword()));
		return accountRepository.save(account);
	}

	@Override
	public Account findByUsername(String username) {
		return accountRepository.findByUsername(username);
	}

	@Override
	public List<Account> findAllAccounts() {
		return accountRepository.findAll();
	}
	
	

}
