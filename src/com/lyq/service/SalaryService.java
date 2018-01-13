package com.lyq.service;

import com.lyq.entity.Salary;

public interface SalaryService {
	public void addSalary(Salary salary);
	public Salary querySalary(Integer empId,Integer year,Integer month);
}
