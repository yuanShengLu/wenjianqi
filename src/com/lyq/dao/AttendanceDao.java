package com.lyq.dao;

import com.lyq.entity.Attendance;

/**
 * attType[0:上班 1：下班] att_status[0：缺勤 1：正常 2：迟到]
 * @author Administrator
 *
 */

public interface AttendanceDao {
	/**
	 * 新增考勤记录
	 * @param att
	 */
	public void addAttendance(Attendance att);
}
