package com.lyq.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lyq.entity.Interview;
/**
 * ���ݿ���Inter_isAccept��   0���û��ܾ��μ����ԣ�1���û�ͬ��μ����ԣ�2��δ��������ԣ�3�������������δͨ����4�������������ͨ��
 * @author Qi.WenJian
 *
 */
public interface InterviewDao {
	/**
	 * �������
	 * @param inter
	 */
	public void addInterview(Interview inter);
	/**
	 * ��ѯ�û���δ����������Ϣ
	 * @param userId
	 * @return
	 */
	public List<Interview> queryInterviewByUserId(Integer userId);
	/**
	 * �����û��ܾ���ͬ������
	 */
	public void updateIsAccept(@Param("isAttend")Integer isAttend,@Param("userId")Integer userId);
	/**
	 * ��ѯ����δ����������
	 * @param supId
	 * @return
	 */
	public List<Interview> queryInterviewBySupId(Integer supId);
	/**
	 * ����¼��Ա���޸����Ա���IsAccept
	 * @param isAgree
	 * @param interId
	 */
	public void updateIsAcceptFromSup(@Param("isAccept")Integer isAgree,@Param("interId")Integer interId);
}
