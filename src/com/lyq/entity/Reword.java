package com.lyq.entity;

public class Reword {
	private int rewId;
	private int rewType;
	private double rewMoney;
	private String rewReason;
	private int rewMonth;
	private int rewYear;
	private int empId;
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public int getRewId() {
		return rewId;
	}
	public void setRewId(int rewId) {
		this.rewId = rewId;
	}
	public int getRewType() {
		return rewType;
	}
	public void setRewType(int rewType) {
		this.rewType = rewType;
	}
	public double getRewMoney() {
		return rewMoney;
	}
	public void setRewMoney(double rewMoney) {
		this.rewMoney = rewMoney;
	}
	public String getRewReason() {
		return rewReason;
	}
	public void setRewReason(String rewReason) {
		this.rewReason = rewReason;
	}
	public int getRewMonth() {
		return rewMonth;
	}
	public void setRewMonth(int rewMonth) {
		this.rewMonth = rewMonth;
	}
	public int getRewYear() {
		return rewYear;
	}
	public void setRewYear(int rewYear) {
		this.rewYear = rewYear;
	}
	public Reword() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Reword [rewId=" + rewId + ", rewType=" + rewType + ", rewMoney=" + rewMoney + ", rewReason=" + rewReason
				+ ", rewMonth=" + rewMonth + ", rewYear=" + rewYear + "]";
	}
	
}
