package com.lyq.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyq.dao.AdminDao;
import com.lyq.entity.Admin;
import com.lyq.service.AdminService;
import com.lyq.util.App;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDao adminDao;
	
	public Admin queryAdmin(Admin admin) {
		String password = App.md5(admin.getAdminPassword());
		admin.setAdminPassword(password);
		return adminDao.queryAdmin(admin);
	}
	
	public Admin queryAdminByAccount(String adminAccount) {
		return adminDao.queryAdminByAccount(adminAccount);
	}
}
