package com.api.AuthEcommerc.resource;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.AuthEcommerc.model.Account;
import com.api.AuthEcommerc.service.AccountService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/accounts")
public class AccountResource {
	
	private final AccountService accountService;
	
	@PostMapping()
	public ResponseEntity<Account> createAccount(@RequestBody Account account){
		Account newAccount = accountService.createAccount(account);
		return ResponseEntity.created(getLocation(newAccount.getId().intValue())).body(newAccount);
	}
	
	@GetMapping
	public ResponseEntity<List<Account>>  getAllAccounts() {
		return ResponseEntity.ok(accountService.findAllAccounts());
		
	}
	
	protected static URI getLocation(Integer id) {
        return fromCurrentRequest().path("{id}").buildAndExpand(id).toUri();
    }

}
