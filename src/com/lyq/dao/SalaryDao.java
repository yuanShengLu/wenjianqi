package com.lyq.dao;

import com.lyq.entity.Salary;

public interface SalaryDao {
	/**
	 * ���н�ʼ�¼
	 * @param salary
	 */
	public void addSalary(Salary salary);
	/**
	 * ��ѯָ��Ա��н�ʼ�¼
	 * @param empId
	 * @return
	 */
	public Salary querySalary(Integer empId,Integer year,Integer month);
}
