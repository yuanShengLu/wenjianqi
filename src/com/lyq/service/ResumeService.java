package com.lyq.service;

import com.lyq.entity.Resume;

public interface ResumeService {
	/**
	 * 产生一份空简历并返回简历的ID
	 * @return
	 */
	public Integer addNewResume();
	/**
	 * 更新简历
	 * @param resume
	 */
	public void updateResume(Resume resume);
}
