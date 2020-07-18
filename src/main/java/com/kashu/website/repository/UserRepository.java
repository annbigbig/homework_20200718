package com.kashu.website.repository;

import com.kashu.website.entity.User;

public interface UserRepository {
	public void save(User user);
	public User login(String account, String password);
	public User getById(String id);
	public User getByAccount(String account);
}
