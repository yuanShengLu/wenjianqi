package com.lyq.dao;

import java.util.List;

import com.lyq.entity.Department;

public interface DepartmentDao {
	/**
	 * ���Ӳ���
	 * @param dept
	 */
	public void addDept(Department dept);
	/**
	 * ��ѯ���в���
	 */
	public List<Department> queryAllDept();
	/**
	 * ��ѯ���в��ŵĻ�����Ϣ��������ְλ��Ա����Ϣ
	 * @return
	 */
	public List<Department> queryAllDeptNameAndId();
	/**
	 * �������ֲ�ѯһ�����Ų�����ְλ��Ա����Ϣ
	 * @param dept
	 * @return
	 */
	public Department queryDeptByName(String deptName);
	/**
	 * ����ID��ѯһ�����Ų�����ְλ��Ա����Ϣ
	 * @param dept
	 * @return
	 */
	public Department queryDeptById(Integer deptId);
	/**
	 * ����IDɾ������
	 * @param deptId
	 */
	public void delDept(Integer deptId);
	/**
	 * ���²�������
	 * @param deptId
	 */
	public void updateDept(Integer deptId,String deptNewName);
}
