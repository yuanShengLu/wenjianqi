package com.lyq.entity;

import java.util.Date;

public class Interview {
	private int interId;
	private int userId;
	private Date interTime;
	private int interIsAccept;
	private int recId;
	private int resumeId;
	private int supId;
	private Recruitment recruitment;
	private Resume resume;
	
	
	public int getResumeId() {
		return resumeId;
	}
	public void setResumeId(int resumeId) {
		this.resumeId = resumeId;
	}
	public int getSupId() {
		return supId;
	}
	public void setSupId(int supId) {
		this.supId = supId;
	}
	public Resume getResume() {
		return resume;
	}
	public void setResume(Resume resume) {
		this.resume = resume;
	}
	public int getRecId() {
		return recId;
	}
	public void setRecId(int recId) {
		this.recId = recId;
	}
	public Recruitment getRecruitment() {
		return recruitment;
	}
	public void setRecruitment(Recruitment recruitment) {
		this.recruitment = recruitment;
	}
	public int getInterId() {
		return interId;
	}
	public void setInterId(int interId) {
		this.interId = interId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getInterTime() {
		return interTime;
	}
	public void setInterTime(Date interTime) {
		this.interTime = interTime;
	}
	public int getInterIsAccept() {
		return interIsAccept;
	}
	public void setInterIsAccept(int interIsAccept) {
		this.interIsAccept = interIsAccept;
	}
	public Interview() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Interview [interId=" + interId + ", userId=" + userId + ", interTime=" + interTime + ", interIsAccept="
				+ interIsAccept + "]";
	}
	
}
