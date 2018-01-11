package com.lyq.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lyq.entity.Interview;
/**
 * 数据库中Inter_isAccept中   0：用户拒绝参加面试，1：用户同意参加面试，2：未处理的面试，3：主管审核面试未通过，4：主管审核面试通过
 * @author Qi.WenJian
 *
 */
public interface InterviewDao {
	/**
	 * 添加面试
	 * @param inter
	 */
	public void addInterview(Interview inter);
	/**
	 * 查询用户的未处理面试信息
	 * @param userId
	 * @return
	 */
	public List<Interview> queryInterviewByUserId(Integer userId);
	/**
	 * 更新用户拒绝或同意面试
	 */
	public void updateIsAccept(@Param("isAttend")Integer isAttend,@Param("userId")Integer userId);
	/**
	 * 查询主管未办面试事务
	 * @param supId
	 * @return
	 */
	public List<Interview> queryInterviewBySupId(Integer supId);
	/**
	 * 主管录用员工修改面试表中IsAccept
	 * @param isAgree
	 * @param interId
	 */
	public void updateIsAcceptFromSup(@Param("isAccept")Integer isAgree,@Param("interId")Integer interId);
}
