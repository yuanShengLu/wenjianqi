package com.lyq.entity;

import java.util.Date;

public class Train {
	private int tId;
	private String tInfo;
	private int deptId;
	private Date tStartTime;
	private Date tEndTime;
	public int gettId() {
		return tId;
	}
	public void settId(int tId) {
		this.tId = tId;
	}
	public String gettInfo() {
		return tInfo;
	}
	public void settInfo(String tInfo) {
		this.tInfo = tInfo;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public Date gettStartTime() {
		return tStartTime;
	}
	public void settStartTime(Date tStartTime) {
		this.tStartTime = tStartTime;
	}
	public Date gettEndTime() {
		return tEndTime;
	}
	public void settEndTime(Date tEndTime) {
		this.tEndTime = tEndTime;
	}
	public Train() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Train [tId=" + tId + ", tInfo=" + tInfo + ", deptId=" + deptId + ", tStartTime=" + tStartTime
				+ ", tEndTime=" + tEndTime + "]";
	}
	
	
}
