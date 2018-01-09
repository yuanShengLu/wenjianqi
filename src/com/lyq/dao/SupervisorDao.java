package com.lyq.dao;

import com.lyq.entity.Supervisor;

public interface SupervisorDao {
	/**
	 * 登陆
	 * @param supervisor
	 * @return
	 */
	public Supervisor login(Supervisor supervisor);
	/**
	 * 根据ID查询主管
	 * @param supId
	 * @return
	 */
	public Supervisor querySupBySupId(Integer supId);
}
