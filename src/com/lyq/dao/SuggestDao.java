package com.lyq.dao;

import java.util.List;

import com.lyq.entity.Suggest;

public interface SuggestDao {
	/**
	 * ���������¼
	 * @param suggest
	 */
	public void addSuggest(Suggest suggest);
	/**
	 * ���ܶ�ȡδ�������¼
	 * @param supId
	 * @return
	 */
	public List<Suggest> querySuggest(Integer supId);
	/**
	 * �����ܶ�ȡ���������¼����Ϊ�Ѷ�
	 * @param suggest
	 */
	public void updateSuggest(Suggest suggest);
}
