package com.lyq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyq.dao.TrainDao;
import com.lyq.entity.Train;
import com.lyq.service.TrainService;
@Service("trainService")
public class TrainServiceImpl implements TrainService {
	@Autowired
	private TrainDao trainDao;

	public void addTrain(Train train) {
		trainDao.addTrain(train);
	}


	public List<Train> queryTrain(String date, Integer deptId) {
		return trainDao.queryTrain(date, deptId);
	}


	public void updateTrain(Train train) {
		trainDao.updateTrain(train);
	}
	
	public void delTrain(Integer tId) {
		trainDao.delTrain(tId);
	}
}
