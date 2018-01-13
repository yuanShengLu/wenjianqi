package com.lyq.service;

import java.util.List;

import com.lyq.entity.Reword;

public interface RewordService {
	public void addReword(Reword reword);
	public List<Reword> queryReword(Integer empId,Integer rewType,Integer rewYear,Integer rewMonth);
}
