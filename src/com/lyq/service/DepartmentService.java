package com.lyq.service;

import java.util.List;

import com.lyq.entity.Department;

public interface DepartmentService {
	public void addDept(Department dept);
	public List<Department> queryAllDept();
	public Department queryDeptByName(String deptName);
	public List<Department> queryAllDeptNameAndId();
	public Department queryDeptById(Integer deptId);
	/**
	 * 查看部门下有没有员工
	 * @param deptId
	 * @return 员工数量
	 */
	public Integer hasEmployee(Integer deptId);
	public void delDept(Integer deptId);
	public void updateDept(Integer deptId,String deptNewName);
}
