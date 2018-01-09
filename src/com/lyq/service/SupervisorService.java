package com.lyq.service;

import com.lyq.entity.Supervisor;

public interface SupervisorService {
	public Supervisor login(Supervisor supervisor);
	public Supervisor querySupBySupId(Integer supId);
}
