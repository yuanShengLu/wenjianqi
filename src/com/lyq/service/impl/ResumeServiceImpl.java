package com.lyq.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyq.dao.ResumeDao;
import com.lyq.entity.Resume;
import com.lyq.service.ResumeService;

@Service("resumeService")
public class ResumeServiceImpl implements ResumeService {
	@Autowired
	private ResumeDao resumeDao;

	public Integer addNewResume() {
		resumeDao.addNullResume();
		return resumeDao.queryMaxResumeId();
	}
	
	public void updateResume(Resume resume) {
		resumeDao.updateResume(resume);
	}
	
}
