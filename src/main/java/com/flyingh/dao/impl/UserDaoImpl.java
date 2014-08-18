package com.flyingh.dao.impl;

import java.util.List;

import com.flyingh.dao.UserDao;
import com.flyingh.util.HibernateUtils;
import com.flyingh.vo.User;

public class UserDaoImpl implements UserDao {

	@Override
	public void save(User user) {
		HibernateUtils.getSession().save(user);
	}

	@Override
	public void update(User user) {
		HibernateUtils.getSession().update(user);
	}

	@Override
	public void delete(int id) {
		HibernateUtils.getSession().delete(HibernateUtils.getSession().load(User.class, id));
	}

	@Override
	public User get(int id) {
		return (User) HibernateUtils.getSession().get(User.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAll() {
		return HibernateUtils.getSession().createQuery("from User").list();
	}

	@Override
	public void addAmount(int id, double amount) {
		User user = get(id);
		user.setAmount(user.getAmount() + amount);
		HibernateUtils.getSession().update(user);
	}

}
