package com.lyq.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyq.dao.RewordDao;
import com.lyq.entity.Reword;
import com.lyq.service.RewordService;

@Service("rewordService")
public class RewordServiceImpl implements RewordService {
	@Autowired
	private RewordDao rewordDao;
	
	public void addReword(Reword reword) {
		reword.setRewYear(new Date().getYear()+1900);
		reword.setRewMonth(new Date().getMonth()+1);
		rewordDao.addReword(reword);
	}
	public List<Reword> queryReword(Integer empId,Integer rewType,Integer rewYear,Integer rewMonth){
		return rewordDao.queryReword(empId, rewType,rewYear,rewMonth);
	}
}
