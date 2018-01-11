package com.lyq.service;

import org.apache.ibatis.annotations.Param;

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
	public void updateRecId(Integer resumeId,Integer recId,Integer resumeIsRead);
	public Resume queryResumeByResumeId(Integer rsumeId);
}
