package com.lyq.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lyq.entity.Interview;

public interface InterviewService {
	public void addInterview(Interview inter);
	public List<Interview> queryInterviewByUserId(Integer userId);
	public void updateIsAccept(Integer isAttend,Integer userId);
	public List<Interview> queryInterviewBySupId(Integer supId);
}
