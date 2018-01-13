package com.lyq.dao;

import java.util.Date;
import java.util.List;

import com.lyq.entity.Train;

public interface TrainDao {
	/**
	 * 添加培训信息
	 * @param train
	 */
	public void addTrain(Train train);
	/**
	 * 查询还未结束的培训，date为日期格式为2018-1-1的String
	 * @param date
	 * @param deptId
	 * @return
	 */
	public List<Train> queryTrain(String date,Integer deptId);
	/**
	 * 修改培训表的时间
	 * @param deptId
	 */
	public void updateTrain(Train train);
	/**
	 * 删除培训
	 * @param tId
	 */
	public void delTrain(Integer tId);
}
