package com.lyq.service;

import java.util.List;

import com.lyq.entity.Page;
import com.lyq.entity.Recruitment;

public interface RecruitmentService {
	public void addRecru(Recruitment recru);
	public List<Recruitment> queryLimitedRec(Page page);
	public Integer queryRecNum();
	public List<Recruitment> queryNewResume(Integer supId);
}
