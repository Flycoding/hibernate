package com.flyingh.service.impl;

import java.util.List;

import com.flyingh.dao.UserDao;
import com.flyingh.service.UserService;
import com.flyingh.vo.User;

public class UserServiceImpl implements UserService {
	private final UserDao dao;

	public UserServiceImpl(UserDao dao) {
		super();
		this.dao = dao;
	}

	@Override
	public void save(User user) {
		dao.save(user);
	}

	@Override
	public void update(User user) {
		dao.update(user);
	}

	@Override
	public void delete(int id) {
		dao.delete(id);
	}

	@Override
	public User get(int id) {
		return dao.get(id);
	}

	@Override
	public List<User> getAll() {
		return dao.getAll();
	}

	@Override
	public void translate(int from, int to, double amount) {
		dao.addAmount(from, -amount);
		dao.addAmount(to, amount);
	}

}
