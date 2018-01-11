package com.lyq.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyq.dao.EmployeeDao;
import com.lyq.entity.Employee;
import com.lyq.service.EmployeeService;
import com.lyq.service.InterviewService;
import com.lyq.util.App;
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private InterviewService interviewService;
	/**
	 * 修改面试表并添加员工
	 */
	public void addEmployee(Employee emp,Integer interId) {
		interviewService.updateIsAcceptFromSup(4, interId);
		employeeDao.addEmployee(emp);
	}
	
	public Employee login(Employee emp) {
		String password = App.md5(emp.getEmpPassword());
		emp.setEmpPassword(password);
		return employeeDao.login(emp);
	}
	public void updateEmpStatus(String status,Integer empId) {
		employeeDao.updateEmpStatus(status, empId);
	}
}
