package com.lyq.dao;

import java.util.Date;
import java.util.List;

import com.lyq.entity.Train;

public interface TrainDao {
	/**
	 * �����ѵ��Ϣ
	 * @param train
	 */
	public void addTrain(Train train);
	/**
	 * ��ѯ��δ��������ѵ��dateΪ���ڸ�ʽΪ2018-1-1��String
	 * @param date
	 * @param deptId
	 * @return
	 */
	public List<Train> queryTrain(String date,Integer deptId);
	/**
	 * �޸���ѵ���ʱ��
	 * @param deptId
	 */
	public void updateTrain(Train train);
	/**
	 * ɾ����ѵ
	 * @param tId
	 */
	public void delTrain(Integer tId);
}
