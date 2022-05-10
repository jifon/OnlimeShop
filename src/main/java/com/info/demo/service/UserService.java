package com.info.demo.service;

import java.util.List;

import com.info.demo.model.User;

public interface UserService {

	public User findByEmail(String email);

	public void save(User user);

//	public void update(User user);

	public List<User> findAllUser();

	public void deleteUser(long userId);
}

