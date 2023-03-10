package com.api.AuthEcommerc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Account {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(unique = true)
	private String username;
	
	private String password;
	
	

}
