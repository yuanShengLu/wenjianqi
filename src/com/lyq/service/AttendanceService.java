package com.lyq.service;

import java.util.Date;
import java.util.List;

import com.lyq.entity.Attendance;

public interface AttendanceService {
	public void addAttendance(Attendance att);
	public Date queryMaxAttTime(Integer empId,Integer attType);
	public List<Attendance> queryAttendance(Integer empId,Integer attYear,Integer attMonth,Integer attStatus);
}
