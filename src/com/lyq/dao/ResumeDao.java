package com.lyq.dao;

import com.lyq.entity.Resume;

public interface ResumeDao {
	/**
	 * ����һ�ݿռ������ڴ����û���ʱ��
	 */
	public void addNullResume();
	/**
	 * ��ѯ���IDֵ���ڸ�ֵ��USER��������ռ�����,�봴���ռ�������һ��ʹ��
	 */
	public Integer queryMaxResumeId();
	/**
	 * ���¼���
	 * @param resume
	 */
	public void updateResume(Resume resume);
}
