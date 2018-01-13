package com.lyq.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyq.dao.SalaryDao;
import com.lyq.entity.Salary;
import com.lyq.service.SalaryService;
@Service("salaryService")
public class SalaryServiceImpl implements SalaryService {
	@Autowired
	private SalaryDao salaryDao;

	public void addSalary(Salary salary) {
		salaryDao.addSalary(salary);
	}
	public Salary querySalary(Integer empId,Integer year,Integer month) {
		return salaryDao.querySalary(empId, year, month);
	}
}
