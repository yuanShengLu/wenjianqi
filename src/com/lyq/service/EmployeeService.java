package com.lyq.service;

import org.apache.ibatis.annotations.Param;

import com.lyq.entity.Employee;

public interface EmployeeService {
	public void addEmployee(Employee emp,Integer interId);
	public Employee login(Employee emp);
	public void updateEmpStatus(String status,Integer empId);
}	
