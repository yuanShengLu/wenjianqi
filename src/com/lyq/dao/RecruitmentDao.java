package com.lyq.dao;

import java.util.List;

import com.lyq.entity.Page;
import com.lyq.entity.Recruitment;

public interface RecruitmentDao {
	/**
	 * ������Ƹ��Ϣ
	 * @param recru
	 */
	public void addRecru(Recruitment recru);
	/**
	 * ��ҳ��ѯ��Ƹ��Ϣ
	 * @param page
	 * @return
	 */
	public List<Recruitment> queryLimitedRec(Page page);
	/**
	 * ��ѯ��Ƹ��Ϣ����
	 * @return
	 */
	public Integer queryRecNum();
	/**
	 * ��ѯδ��Ͷ�ݼ���
	 * @return
	 */
	public List<Recruitment> queryNewResume(Integer supId);
}
