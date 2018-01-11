package com.lyq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyq.dao.PositionDao;
import com.lyq.entity.Position;
import com.lyq.service.PositionService;
@Service("positionService")
public class PositionServiceImpl implements PositionService {
	@Autowired
	private PositionDao positionDao;
	
	public void addPosition(Position position) {
		positionDao.addPosition(position);
	}

	@Override
	public List<Position> queryPositionByDept(Integer deptId) {
		return positionDao.queryPositionByDept(deptId);
	}
	
	public Position queryEmployeesByPositionName(String posiName) {
		return positionDao.queryEmployeesByPositionName(posiName);
	}
	public Position queryPositionByPoName(String posiName) {
		return positionDao.queryPositionByPoName(posiName);
	}
	public void delPosiByPoName(String posiName) {
		positionDao.delPosiByPoName(posiName);
	}
	public void updatePoName(String oldName,String updatePoName) {
		Integer poId = positionDao.queryPositionByPoName(oldName).getPoId();
		positionDao.updatePoName(poId, updatePoName);
	}
}
