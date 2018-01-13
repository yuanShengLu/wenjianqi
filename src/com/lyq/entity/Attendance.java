package com.lyq.entity;

import java.util.Date;

public class Attendance {
	private int attId;
	private int empId;
	private Date attTime;
	private int attType;
	private int attStatus;
	private int attYear;
	private int attMonth;
	
	public int getAttYear() {
		return attYear;
	}
	public void setAttYear(int attYear) {
		this.attYear = attYear;
	}
	public int getAttMonth() {
		return attMonth;
	}
	public void setAttMonth(int attMonth) {
		this.attMonth = attMonth;
	}
	public int getAttId() {
		return attId;
	}
	public void setAttId(int attId) {
		this.attId = attId;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public Date getAttTime() {
		return attTime;
	}
	public void setAttTime(Date attTime) {
		this.attTime = attTime;
	}
	public int getAttType() {
		return attType;
	}
	public void setAttType(int attType) {
		this.attType = attType;
	}
	public int getAttStatus() {
		return attStatus;
	}
	public void setAttStatus(int attStatus) {
		this.attStatus = attStatus;
	}
	public Attendance() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Attendance [attId=" + attId + ", empId=" + empId + ", attTime=" + attTime + ", attType=" + attType
				+ ", attStatus=" + attStatus + "]";
	}
	
}
