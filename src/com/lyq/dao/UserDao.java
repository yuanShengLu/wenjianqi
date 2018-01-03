package com.lyq.dao;

import com.lyq.entity.User;

public interface UserDao {
	/**
	 * ����ο�
	 * @param user
	 */
	public void addUser(User user);
	/**
	 * �����˺Ų�ѯ�û�������ע���������
	 * @param name
	 * @return User
	 */
	public User queryUserByAccount(String name);
	/**
	 * ��½
	 * @param user
	 * @return User
	 */
	public User queryUser(User user);
	/**
	 * ��������
	 * @param password
	 */
	public void updatePassword(User user);
}
