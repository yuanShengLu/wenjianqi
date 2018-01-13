package com.lyq.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lyq.entity.Employee;

public interface EmployeeDao {
	/**
	 * 添加员工
	 * @param emp
	 */
	public void addEmployee(Employee emp);
	/**
	 * 登陆确认账号密码
	 * @param emp
	 * @return
	 */
	public Employee login(Employee emp);
	/**
	 * 修改员工状态 在职，离职，试用期
	 */
	public void updateEmpStatus(@Param("status")String status,@Param("empId")Integer empId);
	/**
	 * 查询部门所有员工
	 * @param deptId
	 * @return
	 */
	public List<Employee> queryEmpByDeptId(Integer deptId);
	/**
	 * 更换员工职位
	 * @param empId
	 * @param deptId
	 * @param poId
	 */
	public void updateEmpDeptAndPosi(Integer empId,Integer deptId,Integer poId,Integer supId);
}
