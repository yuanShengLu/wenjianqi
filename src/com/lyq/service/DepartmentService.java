package com.lyq.service;

import java.util.List;

import com.lyq.entity.Department;

public interface DepartmentService {
	public void addDept(Department dept);
	public List<Department> queryAllDept();
	public Department queryDeptByName(String deptName);
	public List<Department> queryAllDeptNameAndId();
	public Department queryDeptById(Integer deptId);
}
