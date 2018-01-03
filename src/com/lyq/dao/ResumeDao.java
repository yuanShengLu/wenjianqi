package com.lyq.dao;

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
}
