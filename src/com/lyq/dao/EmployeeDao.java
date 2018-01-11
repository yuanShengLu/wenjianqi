package com.lyq.dao;

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
}
