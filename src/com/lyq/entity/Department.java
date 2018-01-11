package com.lyq.entity;

import java.util.Date;
import java.util.List;

public class Department {
	private int deptId;
	private String deptName;
	private Date deptCreateTime;
	private List<Position> pList;
	private Supervisor supervisor;
	private List<Employee> employees;
	
	
	public Date getDeptCreateTime() {
		return deptCreateTime;
	}
	public void setDeptCreateTime(Date deptCreateTime) {
		this.deptCreateTime = deptCreateTime;
	}
	public Supervisor getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(Supervisor supervisor) {
		this.supervisor = supervisor;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public List<Position> getpList() {
		return pList;
	}
	public void setpList(List<Position> pList) {
		this.pList = pList;
	}
	public Department() {
		super();
	}
	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + ", pList=" + pList + ", supervisor="
				+ supervisor + ", employees=" + employees + "]";
	}
	
	
}
