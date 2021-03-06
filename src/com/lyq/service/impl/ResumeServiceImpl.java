package com.lyq.service.impl;

import org.apache.ibatis.annotations.Param;
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
	public void updateRecId(Integer resumeId,Integer recId,Integer resumeIsRead) {
		resumeDao.updateRecId(resumeId, recId,resumeIsRead);
	}
	public Resume queryResumeByResumeId(Integer rsumeId) {
		return resumeDao.queryResumeByResumeId(rsumeId);
	}
	public void updateEmpResume(Resume resume) {
		resumeDao.updateEmpResume(resume);
	}
}
