package com.lyq.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyq.dao.SupervisorDao;
import com.lyq.entity.Supervisor;
import com.lyq.service.SupervisorService;
import com.lyq.util.App;

@Service("supervisorService")
public class SupervisorServiceImpl implements SupervisorService{
	@Autowired
	private SupervisorDao supervisorDao;
	
	public Supervisor login(Supervisor supervisor) {
		String password = App.md5(supervisor.getSupPassword());
		supervisor.setSupPassword(password);
		return supervisorDao.login(supervisor);
	}
	
	public Supervisor querySupBySupId(Integer supId) {
		return supervisorDao.querySupBySupId(supId);
	}
}
