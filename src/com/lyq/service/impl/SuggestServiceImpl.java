package com.lyq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyq.dao.SuggestDao;
import com.lyq.entity.Suggest;
import com.lyq.service.SuggestService;
@Service("suggestService")
public class SuggestServiceImpl implements SuggestService {
	@Autowired
	private SuggestDao suggestDao;
	
	public void addSuggest(Suggest suggest) {
		suggestDao.addSuggest(suggest);
	}

	public List<Suggest> querySuggest(Integer supId) {
		return suggestDao.querySuggest(supId);
	}

	public void updateSuggest(Suggest suggest) {
		suggestDao.updateSuggest(suggest);
	}
	
	public List<Suggest> readSuggest(Integer supId){
		List<Suggest> sList = suggestDao.querySuggest(supId);
		for (Suggest suggest : sList) {
			suggestDao.updateSuggest(suggest);
		}
		return sList;
	}
}
