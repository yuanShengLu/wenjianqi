package com.lyq.entity;

public class Salary {
	private int saId;
	private int empId;
	private int	saYear;
	private int saMonth;
	private int lateCount;
	private int beforeCount;
	private int disAttend;
	private int plusMoney;
	private int lessMoney;
	private int count;
	
	public Salary(int empId, int saYear, int saMonth, int lateCount, int beforeCount, int disAttend, int plusMoney,
			int lessMoney, int count) {
		super();
		this.empId = empId;
		this.saYear = saYear;
		this.saMonth = saMonth;
		this.lateCount = lateCount;
		this.beforeCount = beforeCount;
		this.disAttend = disAttend;
		this.plusMoney = plusMoney;
		this.lessMoney = lessMoney;
		this.count = count;
	}
	public int getSaId() {
		return saId;
	}
	public void setSaId(int saId) {
		this.saId = saId;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public int getSaYear() {
		return saYear;
	}
	public void setSaYear(int saYear) {
		this.saYear = saYear;
	}
	public int getSaMonth() {
		return saMonth;
	}
	public void setSaMonth(int saMonth) {
		this.saMonth = saMonth;
	}
	public int getLateCount() {
		return lateCount;
	}
	public void setLateCount(int lateCount) {
		this.lateCount = lateCount;
	}
	public int getBeforeCount() {
		return beforeCount;
	}
	public void setBeforeCount(int beforeCount) {
		this.beforeCount = beforeCount;
	}
	public int getDisAttend() {
		return disAttend;
	}
	public void setDisAttend(int disAttend) {
		this.disAttend = disAttend;
	}
	public int getPlusMoney() {
		return plusMoney;
	}
	public void setPlusMoney(int plusMoney) {
		this.plusMoney = plusMoney;
	}
	public int getLessMoney() {
		return lessMoney;
	}
	public void setLessMoney(int lessMoney) {
		this.lessMoney = lessMoney;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Salary() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Salary [saId=" + saId + ", empId=" + empId + ", saYear=" + saYear + ", saMonth=" + saMonth
				+ ", lateCount=" + lateCount + ", beforeCount=" + beforeCount + ", disAttend=" + disAttend
				+ ", plusMoney=" + plusMoney + ", lessMoney=" + lessMoney + ", count=" + count + "]";
	}
	
}
