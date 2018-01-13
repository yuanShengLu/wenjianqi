package com.lyq.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyq.dao.EmployeeDao;
import com.lyq.entity.Attendance;
import com.lyq.entity.Employee;
import com.lyq.entity.Reword;
import com.lyq.entity.Salary;
import com.lyq.service.AttendanceService;
import com.lyq.service.EmployeeService;
import com.lyq.service.InterviewService;
import com.lyq.service.RewordService;
import com.lyq.service.SalaryService;
import com.lyq.util.App;
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private InterviewService interviewService;
	@Autowired
	private AttendanceService attendanceSercice;
	@Autowired
	private RewordService rewordService;
	@Autowired
	private SalaryService salaryService;
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
	public List<Employee> queryEmpByDeptId(Integer deptId){
		return employeeDao.queryEmpByDeptId(deptId);
	}
	/**
	 * 发放工资
	 * 迟到早退一次扣除20
	 * 旷工一次扣除基本工资的1/22
	 * 一个月出勤天数设定为22天
	 * 周末加班算入平时考勤，加班工资按照基本工资1/22发放
	 * 罚金和为负时算入奖金和内（由于周末加班奖金超过迟到早退旷工的罚金）
	 * 工作日加班算入考勤表但不算工资，这部分工资由主管发放奖金给出
	 */
	public void releaseSalary(Integer deptId) {
		Date date = new Date();
		int year = date.getYear()+1900;
		int month = date.getMonth()+1;
		if(month==1) {
			year = year-1;
			month = 12;
		}else {
			month = month-1;
		}
		List<Employee> eList = employeeDao.queryEmpByDeptId(deptId);
		for (Employee emp : eList) {
			Double baseSalary = emp.getEmpSalary();
			int count = 0;//总计
			int plusMoney = 0;//奖金和
			int lessMoney = 0;//罚金和
			int lateCount = 0;//迟到次数
			int beforeCount = 0;//早退次数
			int disAttend = 0;//旷工次数
		
			List<Reword> rListPlus = rewordService.queryReword(emp.getEmpId(), 1, year, month);//员工奖金
			List<Reword> rListLess = rewordService.queryReword(emp.getEmpId(), 0, year, month);//员工罚金
			List<Attendance> aListOK = attendanceSercice.queryAttendance(emp.getEmpId(), year, month, 1);//员工正常上班和下班次数
			List<Attendance> aListAfter = attendanceSercice.queryAttendance(emp.getEmpId(), year, month, 2);//员工迟到次数
			List<Attendance> aListBefore = attendanceSercice.queryAttendance(emp.getEmpId(), year, month, 3);//员工早退次数
			for (Reword re : rListPlus) {
				plusMoney+=re.getRewMoney();
			}
			for (Reword re : rListLess) {
				lessMoney+=re.getRewMoney();
			}
			lateCount = aListAfter.size();
			beforeCount = aListBefore.size();
			disAttend = 44-aListOK.size()-lateCount-beforeCount;
			if(disAttend%2==0) {
				disAttend/=2;
			}else {
				disAttend = disAttend/2+1;
			}
			lessMoney += lateCount*20+beforeCount*20+disAttend*(baseSalary/22);
			if(lessMoney<0) {
				plusMoney +=(-lessMoney);
				lessMoney = 0;
			}
			count = plusMoney-lessMoney;
			//写入工资表
			Salary salary = new Salary(emp.getEmpId(), year, month, lateCount, beforeCount, disAttend, plusMoney, lessMoney, beforeCount);
			salaryService.addSalary(salary);
		}
	}

	
	public void updateEmpDeptAndPosi(Integer empId,Integer deptId,Integer poId,Integer supId) {
		employeeDao.updateEmpDeptAndPosi(empId, deptId, poId, supId);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
