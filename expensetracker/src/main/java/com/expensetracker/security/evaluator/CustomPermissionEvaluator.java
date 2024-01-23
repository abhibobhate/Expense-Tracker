package com.expensetracker.security.evaluator;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import java.io.Serializable;

@Component
public class CustomPermissionEvaluator implements PermissionEvaluator {

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        authentication.getName();
        System.out.println("evalue------------<>");
        return true;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        System.out.println("second eval-->");
        return true;
    }
}


