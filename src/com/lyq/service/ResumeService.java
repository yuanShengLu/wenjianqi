package com.lyq.service;

import com.lyq.entity.Resume;

public interface ResumeService {
	/**
	 * ����һ�ݿռ��������ؼ�����ID
	 * @return
	 */
	public Integer addNewResume();
	/**
	 * ���¼���
	 * @param resume
	 */
	public void updateResume(Resume resume);
}
