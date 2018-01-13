package com.lyq.service.impl;

import java.util.Date;
import java.util.List;

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
	
	public Date queryMaxAttTime(Integer empId,Integer attType) {
		return attendanceDao.queryMaxAttTime(empId, attType);
	}
	
	public List<Attendance> queryAttendance(Integer empId,Integer attYear,Integer attMonth,Integer attStatus){
		return attendanceDao.queryAttendance(empId, attYear, attMonth, attStatus);
	}
}
