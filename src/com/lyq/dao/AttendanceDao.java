package com.lyq.dao;

import com.lyq.entity.Attendance;

/**
 * attType[0:�ϰ� 1���°�] att_status[0��ȱ�� 1������ 2���ٵ�]
 * @author Administrator
 *
 */

public interface AttendanceDao {
	/**
	 * �������ڼ�¼
	 * @param att
	 */
	public void addAttendance(Attendance att);
}
