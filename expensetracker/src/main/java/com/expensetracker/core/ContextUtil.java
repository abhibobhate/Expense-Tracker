package com.expensetracker.core;

import com.expensetracker.core.Context;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


@Service
public class ContextUtil {
	
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		return session;
	}

	public Context getContext() {
		Context context = new Context();
		context.setSession(getSession());
		return context;
	}

	public Context getContextWithUser() {
		Context context = new Context();
		context.setSession(getSession());
		
		// get user from security context
//		context.setUser(context
//				.getSession()
//				.get(EPerson.class, getCurrentLoginUserId()));
		
		return context;
	}

	public static Long getCurrentLoginUserId() {
		return Long.parseLong(SecurityContextHolder
								.getContext()
								.getAuthentication()
								.getDetails()
								.toString());
	}

}
