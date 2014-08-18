package com.flyingh.dao;

import java.util.List;

import com.flyingh.vo.User;

public interface UserDao {
	void save(User user);

	void update(User user);

	void delete(int id);

	User get(int id);

	List<User> getAll();

	void addAmount(int id, double amount);
}
