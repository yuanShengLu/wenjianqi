package com.lyq.entity;

import java.util.Date;

public class Employee {
	private int empId;
	private String empName;
	private String empAccount;
	private String empPassword;
	private Resume resume;
	private int empDeptId;
	private int empResumeId;
	private int empSupId;
	private Supervisor supervisor;
	private double empSalary;
	private int empPositionId;
	private Date empServingTime;
	private String empStatus;
	
	
	public int getEmpResumeId() {
		return empResumeId;
	}
	public void setEmpResumeId(int empResumeId) {
		this.empResumeId = empResumeId;
	}
	public int getEmpSupId() {
		return empSupId;
	}
	public void setEmpSupId(int empSupId) {
		this.empSupId = empSupId;
	}
	public String getEmpStatus() {
		return empStatus;
	}
	public void setEmpStatus(String empStatus) {
		this.empStatus = empStatus;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Supervisor getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(Supervisor supervisor) {
		this.supervisor = supervisor;
	}
	public int getEmpPositionId() {
		return empPositionId;
	}
	public void setEmpPositionId(int empPositionId) {
		this.empPositionId = empPositionId;
	}
	public Date getEmpServingTime() {
		return empServingTime;
	}
	public void setEmpServingTime(Date empServingTime) {
		this.empServingTime = empServingTime;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpAccount() {
		return empAccount;
	}
	public void setEmpAccount(String empAccount) {
		this.empAccount = empAccount;
	}
	public String getEmpPassword() {
		return empPassword;
	}
	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}
	public Resume getResume() {
		return resume;
	}
	public void setResume(Resume resume) {
		this.resume = resume;
	}
	public int getEmpDeptId() {
		return empDeptId;
	}
	public void setEmpDeptId(int empDeptId) {
		this.empDeptId = empDeptId;
	}
	
	public double getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empAccount=" + empAccount + ", empPassword="
				+ empPassword + ", resume=" + resume + ", empDeptId=" + empDeptId + ", empResumeId=" + empResumeId
				+ ", empSupId=" + empSupId + ", supervisor=" + supervisor + ", empSalary=" + empSalary
				+ ", empPositionId=" + empPositionId + ", empServingTime=" + empServingTime + ", empStatus=" + empStatus
				+ "]";
	}
	
	
	
}
