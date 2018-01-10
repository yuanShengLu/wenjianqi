package com.lyq.entity;

public class Resume {
	private int resumeId;
	private String realName;
	private int age;
	private long contactInfo;
	private String position;
	private String department;
	private String jobExperience;
	private String expectedSalary;
	private String gender;
	private String education;
	private String eMail;
	private String politicalStatus;
	private String hobby;
	private int recId;
	private Integer resumeIsRead;
	
	
	public int getResumeIsRead() {
		return resumeIsRead;
	}
	public void setResumeIsRead(int resumeIsRead) {
		this.resumeIsRead = resumeIsRead;
	}
	public int getRecId() {
		return recId;
	}
	public void setRecId(int recId) {
		this.recId = recId;
	}
	public int getResumeId() {
		return resumeId;
	}
	public void setResumeId(int resumeId) {
		this.resumeId = resumeId;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(long contactInfo) {
		this.contactInfo = contactInfo;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getJobExperience() {
		return jobExperience;
	}
	public void setJobExperience(String jobExperience) {
		this.jobExperience = jobExperience;
	}
	public String getExpectedSalary() {
		return expectedSalary;
	}
	public void setExpectedSalary(String expectedSalary) {
		this.expectedSalary = expectedSalary;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getPoliticalStatus() {
		return politicalStatus;
	}
	public void setPoliticalStatus(String politicalStatus) {
		this.politicalStatus = politicalStatus;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public Resume() {
		super();
	}
	@Override
	public String toString() {
		return "Resume [resumeId=" + resumeId + ", realName=" + realName + ", age=" + age + ", contactInfo="
				+ contactInfo + ", position=" + position + ", department=" + department + ", jobExperience="
				+ jobExperience + ", expectedSalary=" + expectedSalary + ", gender=" + gender + ", education="
				+ education + ", eMail=" + eMail + ", politicalStatus=" + politicalStatus + ", hobby=" + hobby
				+ ", recId=" + recId + "]";
	}
	
	
}
