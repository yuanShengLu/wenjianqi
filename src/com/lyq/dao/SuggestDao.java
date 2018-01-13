package com.lyq.dao;

import java.util.List;

import com.lyq.entity.Suggest;

public interface SuggestDao {
	/**
	 * 增加意见记录
	 * @param suggest
	 */
	public void addSuggest(Suggest suggest);
	/**
	 * 主管读取未读意见记录
	 * @param supId
	 * @return
	 */
	public List<Suggest> querySuggest(Integer supId);
	/**
	 * 将主管读取过的意见记录设置为已读
	 * @param suggest
	 */
	public void updateSuggest(Suggest suggest);
}
