package com.expensetracker.security.filter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import javax.crypto.SecretKey;

import com.expensetracker.constants.SecurityConstants;
import com.expensetracker.security.authentication.CustomAuthentication;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JWTTokenValidatorFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String token = request.getHeader("Authorization");
        if (null != token) {
            try {
                SecretKey key = Keys.hmacShaKeyFor(
                        SecurityConstants.JWT_KEY.getBytes(StandardCharsets.UTF_8));

                Claims claims = Jwts.parser()
                        .verifyWith(key)
                        .build()
                        .parseSignedClaims(token)
                        .getPayload();

                String username = String.valueOf(claims.get("username"));
                Object userId = claims.get("userId");
                //String authorities = (String) claims.get("authorities");
                Authentication auth = new CustomAuthentication(username, userId);
                SecurityContextHolder.getContext().setAuthentication(auth);
            } catch (Exception e) {
                throw new BadCredentialsException("Invalid Token received!");
            }

        }
        filterChain.doFilter(request, response);
	}
	
	@Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        return request.getServletPath().startsWith("/auth/");
    }

}
