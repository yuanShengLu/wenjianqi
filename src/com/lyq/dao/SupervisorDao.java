package com.lyq.dao;

import com.lyq.entity.Supervisor;

public interface SupervisorDao {
	/**
	 * ��½
	 * @param supervisor
	 * @return
	 */
	public Supervisor login(Supervisor supervisor);
	/**
	 * ����ID��ѯ����
	 * @param supId
	 * @return
	 */
	public Supervisor querySupBySupId(Integer supId);
}
