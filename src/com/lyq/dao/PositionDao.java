package com.lyq.dao;

import java.util.List;

import com.lyq.entity.Position;

public interface PositionDao {
	/**
	 * 增加职位
	 * @param position
	 */
	public void addPosition(Position position);
	/**
	 * 根据部门号查询职位,不包含员工信息
	 * @param deptId
	 * @return
	 */
	public List<Position> queryPositionByDept(Integer deptId);
	/**
	 * 根据职位名查询职位，包括员工信息
	 * @param posiName
	 * @return
	 */
	public Position queryEmployeesByPositionName(String posiName);
	/**
	 * 根据职位查询职位，不包括员工信息
	 * @param posiName
	 * @return
	 */
	public Position queryPositionByPoName(String posiName);
	/**
	 * 根据职位名称删除职位
	 * @param posiName
	 */
	public void delPosiByPoName(String posiName);
	/**
	 * 更新职位名字
	 * @param poId
	 * @param updatePoName
	 */
	public void updatePoName(Integer poId,String updatePoName);
	/**
	 * 根据职位ID查询职位不包括员工信息
	 * @param poId
	 * @return
	 */
	public Position queryPositionById(Integer poId);
}
