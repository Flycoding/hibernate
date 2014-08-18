package com.flyingh.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();;
	private static ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();

	public static Session getSession() {
		Session session = threadLocal.get();
		if (session != null) {
			return session;
		}
		session = sessionFactory.openSession();
		threadLocal.set(session);
		return session;
	}

	public static void close() {
		Session session = threadLocal.get();
		if (session != null) {
			session.close();
		}
	}
}
