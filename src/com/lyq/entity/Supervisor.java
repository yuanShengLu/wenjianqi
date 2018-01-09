package com.lyq.entity;

import java.util.Date;
import java.util.List;

public class Supervisor {
	private int supId;
	private String supName;
	private String supAccount;
	private String supPassword;
	private int supSalary;
	private Date supServingTime;
	private Resume resume;
	private List<Employee> employees;
	private int supDeptId;
	private String supStatus;
	
	
	public String getSupStatus() {
		return supStatus;
	}
	public void setSupStatus(String supStatus) {
		this.supStatus = supStatus;
	}
	public int getSupDeptId() {
		return supDeptId;
	}
	public void setSupDeptId(int supDeptId) {
		this.supDeptId = supDeptId;
	}
	public String getSupName() {
		return supName;
	}
	public void setSupName(String supName) {
		this.supName = supName;
	}
	public Date getSupServingTime() {
		return supServingTime;
	}
	public void setSupServingTime(Date supServingTime) {
		this.supServingTime = supServingTime;
	}
	public int getSupId() {
		return supId;
	}
	public void setSupId(int supId) {
		this.supId = supId;
	}
	public String getSupAccount() {
		return supAccount;
	}
	public void setSupAccount(String supAccount) {
		this.supAccount = supAccount;
	}
	public String getSupPassword() {
		return supPassword;
	}
	public void setSupPassword(String supPassword) {
		this.supPassword = supPassword;
	}
	public int getSupSalary() {
		return supSalary;
	}
	public void setSupSalary(int supSalary) {
		this.supSalary = supSalary;
	}
	public Resume getResume() {
		return resume;
	}
	public void setResume(Resume resume) {
		this.resume = resume;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	public Supervisor() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Supervisor [supId=" + supId + ", supAccount=" + supAccount + ", supPassword=" + supPassword
				+ ", supSalary=" + supSalary + ", supServingTime=" + supServingTime + ", resume=" + resume
				+ ", employees=" + employees + "]";
	}
	
	
}
