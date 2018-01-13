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
	 * �޸����Ա����Ա��
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
	 * ���Ź���
	 * �ٵ�����һ�ο۳�20
	 * ����һ�ο۳��������ʵ�1/22
	 * һ���³��������趨Ϊ22��
	 * ��ĩ�Ӱ�����ƽʱ���ڣ��Ӱ๤�ʰ��ջ�������1/22����
	 * �����Ϊ��ʱ���뽱����ڣ�������ĩ�Ӱཱ�𳬹��ٵ����˿����ķ���
	 * �����ռӰ����뿼�ڱ����㹤�ʣ��ⲿ�ֹ��������ܷ��Ž������
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
			int count = 0;//�ܼ�
			int plusMoney = 0;//�����
			int lessMoney = 0;//�����
			int lateCount = 0;//�ٵ�����
			int beforeCount = 0;//���˴���
			int disAttend = 0;//��������
		
			List<Reword> rListPlus = rewordService.queryReword(emp.getEmpId(), 1, year, month);//Ա������
			List<Reword> rListLess = rewordService.queryReword(emp.getEmpId(), 0, year, month);//Ա������
			List<Attendance> aListOK = attendanceSercice.queryAttendance(emp.getEmpId(), year, month, 1);//Ա�������ϰ���°����
			List<Attendance> aListAfter = attendanceSercice.queryAttendance(emp.getEmpId(), year, month, 2);//Ա���ٵ�����
			List<Attendance> aListBefore = attendanceSercice.queryAttendance(emp.getEmpId(), year, month, 3);//Ա�����˴���
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
			//д�빤�ʱ�
			Salary salary = new Salary(emp.getEmpId(), year, month, lateCount, beforeCount, disAttend, plusMoney, lessMoney, beforeCount);
			salaryService.addSalary(salary);
		}
	}

	
	public void updateEmpDeptAndPosi(Integer empId,Integer deptId,Integer poId,Integer supId) {
		employeeDao.updateEmpDeptAndPosi(empId, deptId, poId, supId);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
