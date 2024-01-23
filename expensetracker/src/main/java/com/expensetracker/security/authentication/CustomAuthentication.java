package com.expensetracker.security.authentication;

import org.springframework.security.authentication.AbstractAuthenticationToken;

public class CustomAuthentication extends AbstractAuthenticationToken {

    private String username;

    public CustomAuthentication() {
        super(null);
    }

    public CustomAuthentication(String username, Object userId) {
        super(null);
        this.username = username;
        this.setDetails(userId);
        setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return username;
    }

    @Override
    public String getName() {
        return username;
    }
}

