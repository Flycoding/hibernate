package com.flyingh.demo;

import java.util.Arrays;

import org.hibernate.Session;
import org.junit.Test;

import com.flyingh.util.HibernateUtils;
import com.flyingh.vo.Customer;

public class CustomerTest {
	@Test
	public void testSave() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		Customer customer = new Customer();
		customer.setName("haha");
		customer.setAddresses(Arrays.asList("a", "b", "c"));
		session.save(customer);
		session.getTransaction().commit();
		HibernateUtils.getSession().close();
	}
}
