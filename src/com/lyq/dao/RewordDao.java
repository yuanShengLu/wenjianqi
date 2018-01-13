package com.lyq.dao;

import java.util.List;

import com.lyq.entity.Reword;
/**
 * rewType 0:惩 1：奖
 * @author Administrator
 *
 */
public interface RewordDao {
	/**
	 * 添加奖惩
	 * @param reword
	 */
	public void addReword(Reword reword);
	/**
	 * 根据员工ID查询奖惩记录
	 * @param empId
	 * @param rewType
	 * @return
	 */
	public List<Reword> queryReword(Integer empId,Integer rewType,Integer rewYear,Integer rewMonth);
}
