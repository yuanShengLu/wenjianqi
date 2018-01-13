package com.lyq.entity;

public class Suggest {
	private int sugId;
	private String suggestInfo;
	private int empId;
	private int supId;
	private int sugStatus;
	public int getSugId() {
		return sugId;
	}
	public void setSugId(int sugId) {
		this.sugId = sugId;
	}
	public String getSuggestInfo() {
		return suggestInfo;
	}
	public void setSuggestInfo(String suggestInfo) {
		this.suggestInfo = suggestInfo;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public int getSupId() {
		return supId;
	}
	public void setSupId(int supId) {
		this.supId = supId;
	}
	public int getSugStatus() {
		return sugStatus;
	}
	public void setSugStatus(int sugStatus) {
		this.sugStatus = sugStatus;
	}
	public Suggest() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Suggest [sugId=" + sugId + ", suggestInfo=" + suggestInfo + ", empId=" + empId + ", supId=" + supId
				+ ", sugStatus=" + sugStatus + "]";
	}
	
}
