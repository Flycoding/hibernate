package com.flyingh.demo;

import org.junit.Test;

import com.flyingh.util.UserServiceFactory;
import com.flyingh.vo.User;

public class UserServiceTest {
	@Test
	public void testSave() {
		User user = new User();
		user.setName("flyingh");
		user.setAge(22);
		user.setAmount(10000);
		UserServiceFactory.newInstance().save(user);
	}

	@Test
	public void testUpdate() {
		User user = UserServiceFactory.newInstance().get(1);
		user.setName("Flycoding");
		UserServiceFactory.newInstance().save(user);
	}

	@Test
	public void delete() {
		UserServiceFactory.newInstance().delete(2);
	}

	@Test
	public void testGet() {
		System.out.println(UserServiceFactory.newInstance().get(1));
	}

	@Test
	public void testGetAll() {
		System.out.println(UserServiceFactory.newInstance().getAll());
	}

	@Test
	public void testTranslate() {
		UserServiceFactory.newInstance().translate(1, 2, -5000);
	}

}
