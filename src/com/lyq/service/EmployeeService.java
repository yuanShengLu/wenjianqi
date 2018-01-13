package com.lyq.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lyq.entity.Employee;

public interface EmployeeService {
	public void addEmployee(Employee emp,Integer interId);
	public Employee login(Employee emp);
	public void updateEmpStatus(String status,Integer empId);
	public void releaseSalary(Integer deptId);
	public List<Employee> queryEmpByDeptId(Integer deptId);
	public void updateEmpDeptAndPosi(Integer empId,Integer deptId,Integer poId,Integer supId);
}	
