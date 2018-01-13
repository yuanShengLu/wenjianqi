package com.lyq.service;

import java.util.List;

import com.lyq.entity.Suggest;

public interface SuggestService {
	public void addSuggest(Suggest suggest);
	
	public List<Suggest> querySuggest(Integer supId);
	
	public void updateSuggest(Suggest suggest);
	
	/**
	 * 主管读取未读意见
	 * @param supId
	 * @return
	 */
	public List<Suggest> readSuggest(Integer supId);
}
