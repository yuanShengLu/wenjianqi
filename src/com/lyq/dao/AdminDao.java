package com.lyq.dao;

import com.lyq.entity.Admin;

public interface AdminDao {
	/**
	 * ��ѯ���ܣ����ڵ�½
	 * @param admin
	 * @return
	 */
	public Admin queryAdmin(Admin admin);
	/**
	 * �����˺Ų�ѯ����
	 * @param adminAccount
	 * @return
	 */
	public Admin queryAdminByAccount(String adminAccount);
}
