package com.lyq.service;

import java.util.List;

import com.lyq.entity.Position;

public interface PositionService {
	public void addPosition(Position position);
	public List<Position> queryPositionByDept(Integer deptId);
	public Position queryEmployeesByPositionName(String posiName);
}
