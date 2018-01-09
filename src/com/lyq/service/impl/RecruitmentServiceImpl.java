package com.lyq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyq.dao.RecruitmentDao;
import com.lyq.entity.Page;
import com.lyq.entity.Recruitment;
import com.lyq.service.RecruitmentService;
@Service("recruitmentService")
public class RecruitmentServiceImpl implements RecruitmentService {
	@Autowired
	private RecruitmentDao recruitmentDao;
	
	public void addRecru(Recruitment recru) {
		recruitmentDao.addRecru(recru);
	}
	
	public List<Recruitment> queryLimitedRec(Page page){
		return recruitmentDao.queryLimitedRec(page);
	}

	public Integer queryRecNum() {
		return recruitmentDao.queryRecNum();
	}
	public List<Recruitment> queryNewResume(Integer supId) {
		return recruitmentDao.queryNewResume(supId);
	}
}
