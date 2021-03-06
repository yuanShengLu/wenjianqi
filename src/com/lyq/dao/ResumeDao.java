package com.lyq.dao;

import org.apache.ibatis.annotations.Param;

import com.lyq.entity.Resume;

public interface ResumeDao {
	/**
	 * 生成一份空简历用于创建用户的时候
	 */
	public void addNullResume();
	/**
	 * 查询最大ID值用于赋值给USER外键关联空简历表,与创建空简历方法一起使用
	 */
	public Integer queryMaxResumeId();
	/**
	 * 更新简历
	 * @param resume
	 */
	public void updateResume(Resume resume);
	/**
	 * 员工更新自己的基本信息
	 * @param resume
	 */
	public void updateEmpResume(Resume resume);
	/**
	 * 投递简历修改简历中招聘信息ID和状态
	 * @param resumeId
	 * @param recId
	 */
	public void updateRecId(@Param("resumeId")Integer resumeId,@Param("recId")Integer recId,@Param("resumeIsRead")Integer resumeIsRead);
	/**
	 * 根据简历ID查询简历
	 * @param rsumeId
	 * @return
	 */
	public Resume queryResumeByResumeId(Integer rsumeId);
}
