package com.lyq.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyq.dao.AttendanceDao;
import com.lyq.entity.Attendance;
import com.lyq.service.AttendanceService;

@Service("attendanceService")
public class AttendanceServiceImpl implements AttendanceService {
	@Autowired
	private AttendanceDao attendanceDao;
	
	public void addAttendance(Attendance att) {
		attendanceDao.addAttendance(att);
	}

}
