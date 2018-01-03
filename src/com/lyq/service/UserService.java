package com.lyq.service;

import com.lyq.entity.User;

public interface UserService {
	public void addUser(User user);
	public User queryUserByAccount(String name);
	public User queryUser(User user);
	public void updatePassword(User user);
}
