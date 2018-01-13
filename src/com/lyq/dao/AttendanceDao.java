package com.lyq.dao;

import java.util.Date;
import java.util.List;

import com.lyq.entity.Attendance;

/**
 * attType[0:�ϰ� 1���°�] att_status[1������ 2���ٵ� 3:���� 4:�Ӱ࿪ʼ 5���Ӱ����]
 * @author Administrator
 *
 */

public interface AttendanceDao {
	/**
	 * �������ڼ�¼
	 * @param att
	 */
	public void addAttendance(Attendance att);
	/**
	 * ��ѯԱ�����һ�δ򿨼�¼
	 * @return
	 */
	public Date queryMaxAttTime(Integer empId,Integer attType);
	/**
	 * ��ѯԱ��������Ϣ
	 * @param empId
	 * @param attYear
	 * @param attMonth
	 * @param attStatus
	 * @return
	 */
	public List<Attendance> queryAttendance(Integer empId,Integer attYear,Integer attMonth,Integer attStatus);
}
