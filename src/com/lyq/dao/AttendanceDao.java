package com.lyq.dao;

import java.util.Date;
import java.util.List;

import com.lyq.entity.Attendance;

/**
 * attType[0:上班 1：下班] att_status[1：正常 2：迟到 3:早退 4:加班开始 5：加班结束]
 * @author Administrator
 *
 */

public interface AttendanceDao {
	/**
	 * 新增考勤记录
	 * @param att
	 */
	public void addAttendance(Attendance att);
	/**
	 * 查询员工最近一次打卡记录
	 * @return
	 */
	public Date queryMaxAttTime(Integer empId,Integer attType);
	/**
	 * 查询员工出勤信息
	 * @param empId
	 * @param attYear
	 * @param attMonth
	 * @param attStatus
	 * @return
	 */
	public List<Attendance> queryAttendance(Integer empId,Integer attYear,Integer attMonth,Integer attStatus);
}
