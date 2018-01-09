package com.lyq.dao;

import com.lyq.entity.Admin;

public interface AdminDao {
	/**
	 * 查询超管，用于登陆
	 * @param admin
	 * @return
	 */
	public Admin queryAdmin(Admin admin);
	/**
	 * 根据账号查询超管
	 * @param adminAccount
	 * @return
	 */
	public Admin queryAdminByAccount(String adminAccount);
}
