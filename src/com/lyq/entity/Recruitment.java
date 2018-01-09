package com.lyq.entity;

import java.util.Date;
import java.util.List;

public class Recruitment {
	private int recId;
	private String recPosition;
	private String recDept;
	private String recWorkPlace;
	private String recSalary;
	private Date recReleaseTime;
	private String recWorkDescribe;
	private Integer recSupervisorId;
	private List<Resume> resumes;
	
	
	public Integer getRecSupervisorId() {
		return recSupervisorId;
	}
	public void setRecSupervisorId(Integer recSupervisorId) {
		this.recSupervisorId = recSupervisorId;
	}
	public String getRecWorkDescribe() {
		return recWorkDescribe;
	}
	public void setRecWorkDescribe(String recWorkDescribe) {
		this.recWorkDescribe = recWorkDescribe;
	}
	public int getRecId() {
		return recId;
	}
	public void setRecId(int recId) {
		this.recId = recId;
	}
	public String getRecPosition() {
		return recPosition;
	}
	public void setRecPosition(String recPosition) {
		this.recPosition = recPosition;
	}
	public String getRecDept() {
		return recDept;
	}
	public void setRecDept(String recDept) {
		this.recDept = recDept;
	}
	public String getRecWorkPlace() {
		return recWorkPlace;
	}
	public void setRecWorkPlace(String recWorkPlace) {
		this.recWorkPlace = recWorkPlace;
	}
	public String getRecSalary() {
		return recSalary;
	}
	public void setRecSalary(String recSalary) {
		this.recSalary = recSalary;
	}
	public Date getRecReleaseTime() {
		return recReleaseTime;
	}
	public void setRecReleaseTime(Date recReleaseTime) {
		this.recReleaseTime = recReleaseTime;
	}
	public List<Resume> getResumes() {
		return resumes;
	}
	public void setResumes(List<Resume> resumes) {
		this.resumes = resumes;
	}
	public Recruitment() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Recruitment [recId=" + recId + ", recPosition=" + recPosition + ", recDept=" + recDept
				+ ", recWorkPlace=" + recWorkPlace + ", recSalary=" + recSalary + ", recReleaseTime=" + recReleaseTime
				+ ", resumes=" + resumes + "]";
	}
	
}
