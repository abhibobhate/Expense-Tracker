package com.expensetracker.security.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
		
//		EPerson user = new 
		// TODO passoword match logic
		
		return new CustomAuthentication(username, null);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return CustomAuthentication.class.isAssignableFrom(authentication);
	}

}
