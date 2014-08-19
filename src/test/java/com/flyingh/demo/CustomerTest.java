package com.flyingh.demo;

import java.util.HashMap;
import java.util.Map;

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
		Map<String, String> map = new HashMap<String, String>();
		map.put("a", "first");
		map.put("b", "second");
		map.put("c", "third");
		customer.setMap(map);
		session.save(customer);
		session.getTransaction().commit();
		HibernateUtils.getSession().close();
	}
}
