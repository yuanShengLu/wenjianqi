package com.lyq.service;

import java.util.List;

import com.lyq.entity.Train;

public interface TrainService {
	public void addTrain(Train train);

	public List<Train> queryTrain(String date,Integer deptId);

	public void updateTrain(Train train);
	
	public void delTrain(Integer tId);
}
