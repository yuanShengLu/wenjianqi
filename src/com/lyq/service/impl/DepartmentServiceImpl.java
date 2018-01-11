package com.lyq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyq.dao.DepartmentDao;
import com.lyq.dao.PositionDao;
import com.lyq.entity.Department;
import com.lyq.entity.Position;
import com.lyq.service.DepartmentService;
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentDao departmentDao;
	@Autowired
	private PositionDao positionDao;

	public void addDept(Department dept) {
		departmentDao.addDept(dept);
	}

	public List<Department> queryAllDept() {
		return departmentDao.queryAllDept();
	}
	
	public Department queryDeptByName(String deptName) {
		return departmentDao.queryDeptByName(deptName);
	}
	
	public List<Department> queryAllDeptNameAndId(){
		return departmentDao.queryAllDeptNameAndId();
	}
	
	public Department queryDeptById(Integer deptId) {
		return departmentDao.queryDeptById(deptId);
	}
	
	public Integer hasEmployee(Integer deptId) {
		int count = 0;
		List<Position> pList = positionDao.queryPositionByDept(deptId);
		for (Position position : pList) {
			Position po = positionDao.queryEmployeesByPositionName(position.getPoName());
			count+=po.getEmployees().size();
		}
		return count;
	}
	public void delDept(Integer deptId) {
		departmentDao.delDept(deptId);
	}
	public void updateDept(Integer deptId,String deptNewName) {
		departmentDao.updateDept(deptId, deptNewName);
	}
	
}
