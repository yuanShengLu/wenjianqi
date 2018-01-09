package com.lyq.dao;

import java.util.List;

import com.lyq.entity.Page;
import com.lyq.entity.Recruitment;

public interface RecruitmentDao {
	/**
	 * 新增招聘信息
	 * @param recru
	 */
	public void addRecru(Recruitment recru);
	/**
	 * 分页查询招聘信息
	 * @param page
	 * @return
	 */
	public List<Recruitment> queryLimitedRec(Page page);
	/**
	 * 查询招聘信息总数
	 * @return
	 */
	public Integer queryRecNum();
	/**
	 * 查询未阅投递简历
	 * @return
	 */
	public List<Recruitment> queryNewResume(Integer supId);
}
