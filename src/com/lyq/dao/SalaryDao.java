package com.lyq.dao;

import com.lyq.entity.Salary;

public interface SalaryDao {
	/**
	 * 添加薪资记录
	 * @param salary
	 */
	public void addSalary(Salary salary);
	/**
	 * 查询指定员工薪资记录
	 * @param empId
	 * @return
	 */
	public Salary querySalary(Integer empId,Integer year,Integer month);
}
