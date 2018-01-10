package com.lyq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyq.dao.InterviewDao;
import com.lyq.entity.Interview;
import com.lyq.service.InterviewService;

@Service("interviewService")
public class InterviewServiceImpl implements InterviewService {
	@Autowired
	private InterviewDao interviewDao;

	public void addInterview(Interview inter) {
		interviewDao.addInterview(inter);
	}
	
	public List<Interview> queryInterviewByUserId(Integer userId){
		return interviewDao.queryInterviewByUserId(userId);
	}
	
	public void updateIsAccept(Integer isAttend,Integer userId) {
		interviewDao.updateIsAccept(isAttend, userId);
	}
	
	public List<Interview> queryInterviewBySupId(Integer supId){
		return interviewDao.queryInterviewBySupId(supId);
	}
}
