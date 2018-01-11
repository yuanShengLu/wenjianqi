package com.lyq.dao;

import java.util.List;

import com.lyq.entity.Department;

public interface DepartmentDao {
	/**
	 * 增加部门
	 * @param dept
	 */
	public void addDept(Department dept);
	/**
	 * 查询所有部门
	 */
	public List<Department> queryAllDept();
	/**
	 * 查询所有部门的基础信息，不包含职位和员工信息
	 * @return
	 */
	public List<Department> queryAllDeptNameAndId();
	/**
	 * 根据名字查询一个部门不包含职位和员工信息
	 * @param dept
	 * @return
	 */
	public Department queryDeptByName(String deptName);
	/**
	 * 根据ID查询一个部门不包含职位和员工信息
	 * @param dept
	 * @return
	 */
	public Department queryDeptById(Integer deptId);
	/**
	 * 根据ID删除部门
	 * @param deptId
	 */
	public void delDept(Integer deptId);
	/**
	 * 更新部门名字
	 * @param deptId
	 */
	public void updateDept(Integer deptId,String deptNewName);
}
