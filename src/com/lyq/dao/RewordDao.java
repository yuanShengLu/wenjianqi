package com.lyq.dao;

import java.util.List;

import com.lyq.entity.Reword;
/**
 * rewType 0:�� 1����
 * @author Administrator
 *
 */
public interface RewordDao {
	/**
	 * ��ӽ���
	 * @param reword
	 */
	public void addReword(Reword reword);
	/**
	 * ����Ա��ID��ѯ���ͼ�¼
	 * @param empId
	 * @param rewType
	 * @return
	 */
	public List<Reword> queryReword(Integer empId,Integer rewType,Integer rewYear,Integer rewMonth);
}
