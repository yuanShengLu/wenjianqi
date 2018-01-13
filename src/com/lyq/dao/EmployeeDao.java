package com.lyq.dao;

import java.util.List;

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
	/**
	 * ��ѯ��������Ա��
	 * @param deptId
	 * @return
	 */
	public List<Employee> queryEmpByDeptId(Integer deptId);
	/**
	 * ����Ա��ְλ
	 * @param empId
	 * @param deptId
	 * @param poId
	 */
	public void updateEmpDeptAndPosi(Integer empId,Integer deptId,Integer poId,Integer supId);
}
