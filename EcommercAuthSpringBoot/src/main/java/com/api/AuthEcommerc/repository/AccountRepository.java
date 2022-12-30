package com.api.AuthEcommerc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.AuthEcommerc.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
	
	Account findByUsername(String username);

}
