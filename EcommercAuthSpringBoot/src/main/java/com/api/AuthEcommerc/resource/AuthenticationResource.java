package com.api.AuthEcommerc.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.AuthEcommerc.model.Authentication;
import com.api.AuthEcommerc.repository.UserDao;
import com.api.AuthEcommerc.security.JwtUtils;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationResource {
	
	private final AuthenticationManager authenticationManager;
	private final UserDao userDao;
	private final JwtUtils jwtUtils;
	
	@PostMapping("/authenticate")
	public ResponseEntity<String> authenticate(@RequestBody Authentication request) {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
		);
		
		final UserDetails user = userDao.findUserByEmail(request.getEmail());
		if(user != null) {
			return ResponseEntity.ok(jwtUtils.generateToken(user));
		}
		return ResponseEntity.status(400).body("Some error has occurred");
	}
	
}
