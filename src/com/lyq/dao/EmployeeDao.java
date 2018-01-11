package com.lyq.dao;

import org.apache.ibatis.annotations.Param;

import com.lyq.entity.Employee;

public interface EmployeeDao {
	/**
	 * ���Ա��
	 * @param emp
	 */
	public void addEmployee(Employee emp);
	/**
	 * ��½ȷ���˺�����
	 * @param emp
	 * @return
	 */
	public Employee login(Employee emp);
	/**
	 * �޸�Ա��״̬ ��ְ����ְ��������
	 */
	public void updateEmpStatus(@Param("status")String status,@Param("empId")Integer empId);
}
