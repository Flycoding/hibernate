package com.flyingh.service;

import java.util.List;

import com.flyingh.annotation.Transaction;
import com.flyingh.vo.User;

public interface UserService {

	@Transaction
	void save(User user);

	@Transaction
	void update(User user);

	@Transaction
	void delete(int id);

	User get(int id);

	List<User> getAll();

	@Transaction
	void translate(int from, int to, double amount);
}
