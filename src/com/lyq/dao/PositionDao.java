package com.lyq.dao;

import java.util.List;

import com.lyq.entity.Position;

public interface PositionDao {
	/**
	 * ����ְλ
	 * @param position
	 */
	public void addPosition(Position position);
	/**
	 * ���ݲ��źŲ�ѯְλ,������Ա����Ϣ
	 * @param deptId
	 * @return
	 */
	public List<Position> queryPositionByDept(Integer deptId);
	/**
	 * ����ְλ����ѯְλ������Ա����Ϣ
	 * @param posiName
	 * @return
	 */
	public Position queryEmployeesByPositionName(String posiName);
}