package com.expensetracker.core;

import org.hibernate.Session;

public class Context implements AutoCloseable {
	
	//private EPerson user;
	
	private Session session;

	public Context() {
		
	}

//	//public EPerson getUser() {
//		return user;
//	}

//	//public void setUser(EPerson user) {
//		this.user = user;
//	}

	@Override
	public void close() throws Exception {
//		session.flush();
//		session.getTransaction().commit();
		session.close();
		session = null;
		//user = null;
	}
	
	public void setSession(Session session) {
		this.session = session;
	}

	public Session getSession() {
		return session;
	}

	public void commit() {
		session.flush();
		session.getTransaction().commit();
	}

}
