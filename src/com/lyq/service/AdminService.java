package com.lyq.service;

import com.lyq.entity.Admin;

public interface AdminService {
	public Admin queryAdmin(Admin admin);
	public Admin queryAdminByAccount(String adminAccount);
}
