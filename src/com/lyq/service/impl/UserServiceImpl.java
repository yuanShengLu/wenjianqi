package com.lyq.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyq.dao.UserDao;
import com.lyq.entity.User;
import com.lyq.service.UserService;
import com.lyq.util.App;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	
	public void addUser(User user) {
		String password = user.getUserPassword();
		password = App.md5(password);
		user.setUserPassword(password);
		userDao.addUser(user);
	}

	public User queryUserByAccount(String name) {
		return userDao.queryUserByAccount(name);
	}
	
	public User queryUser(User user) {
		String password = user.getUserPassword();
		password = App.md5(password);
		user.setUserPassword(password);
		return userDao.queryUser(user);
	}
	
	public void updatePassword(User user) {
		String password = user.getUserPassword();
		password = App.md5(password);
		user.setUserPassword(password);
		userDao.updatePassword(user);
	}
}
