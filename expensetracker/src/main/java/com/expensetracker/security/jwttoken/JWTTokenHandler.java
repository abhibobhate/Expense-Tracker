package com.expensetracker.security.jwttoken;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.crypto.SecretKey;

import com.expensetracker.constants.SecurityConstants;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JWTTokenHandler {

	public void setAuthorizationToken(String username, Object userId, HttpServletResponse response) {		
		
		SecretKey key = Keys.hmacShaKeyFor(SecurityConstants.JWT_KEY.getBytes(StandardCharsets.UTF_8));
		String jwt = Jwts.builder()
				.issuer("ESarkar")
				.claim("username", username)
				.claim("userId", userId)
				.issuedAt(new Date())
				.expiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(SecurityConstants.JWT_EXPIRY_TIME)))
				.signWith(key).compact();
		
		// set header
		response.setHeader(SecurityConstants.JWT_HEADER, jwt);
	}
	
}
