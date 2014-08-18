package com.flyingh.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.flyingh.annotation.Transaction;
import com.flyingh.dao.impl.UserDaoImpl;
import com.flyingh.service.UserService;
import com.flyingh.service.impl.UserServiceImpl;

public class UserServiceFactory {
	private static final ThreadLocal<UserService> THREAD_LOCAL = new ThreadLocal<UserService>() {
		@Override
		protected UserService initialValue() {
			final UserServiceImpl userService = new UserServiceImpl(new UserDaoImpl());
			return (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(), userService.getClass().getInterfaces(),
					new InvocationHandler() {

						@Override
						public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
							before(method);
							Object result = method.invoke(userService, args);
							after(method);
							return result;
						}

						private void after(Method method) {
							if (needTransaction(method)) {
								System.out.println("commit");
								HibernateUtils.getSession().getTransaction().commit();
							}
						}

						private void before(Method method) {
							if (needTransaction(method)) {
								System.out.println("begin");
								HibernateUtils.getSession().beginTransaction();
							}
						}

						private boolean needTransaction(Method method) {
							return method.isAnnotationPresent(Transaction.class);
						}
					});

		}
	};

	public static final UserService newInstance() {
		return THREAD_LOCAL.get();
	}
}
