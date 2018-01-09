package com.lyq.dao;

import org.apache.ibatis.annotations.Param;

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
	/**
	 * Ͷ�ݼ����޸ļ�������Ƹ��ϢID
	 * @param resumeId
	 * @param recId
	 */
	public void updateRecId(@Param("resumeId")Integer resumeId,@Param("recId")Integer recId,@Param("resumeIsRead")Integer resumeIsRead);
}
