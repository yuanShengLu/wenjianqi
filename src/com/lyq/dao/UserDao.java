package com.lyq.dao;

import com.lyq.entity.User;

public interface UserDao {
	/**
	 * 添加游客
	 * @param user
	 */
	public void addUser(User user);
	/**
	 * 根据账号查询用户，用于注册重名检查
	 * @param name
	 * @return User
	 */
	public User queryUserByAccount(String name);
	/**
	 * 登陆
	 * @param user
	 * @return User
	 */
	public User queryUser(User user);
	/**
	 * 更改密码
	 * @param password
	 */
	public void updatePassword(User user);
}
