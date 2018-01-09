package com.lyq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyq.dao.DepartmentDao;
import com.lyq.entity.Department;
import com.lyq.service.DepartmentService;
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentDao departmentDao;

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
}
