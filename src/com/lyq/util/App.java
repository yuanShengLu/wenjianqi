package com.lyq.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

public class App {
	/**
	 * ��½��ʱ�򣬽��û������������һ�ν��е��ã�����õ������ĺ����ݿ�
	 * ���������ƥ�䣬����Ե�½��
	 * @param src
	 * @return
	 */
	public static String md5(String src){
		StringBuffer buffer = new StringBuffer();
		char[] chars = {'0','1','2','3','4','5','6','7','8','9',
				'a','b','c','d','e','f'};
		byte[] bytes = src.getBytes();
		//algorithm�㷨
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			byte[] target = md.digest(bytes);
			for (byte b : target) {
				buffer.append(chars[(b>>4)&0x0F]);
				buffer.append(chars[b&0x0F]);
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return buffer.toString();
	}
	
	/**
	 * ���ؿ�����Ϣ
	 * @param date
	 * @return  1������ 2���ٵ� 3:���� 4:�Ӱ࿪ʼ 5���Ӱ����
	 */
	public static int work(Date date,int attType) {
		int hour = date.getHours();
		if(attType==0) {
			if(hour<9&&hour>5) {
				return 1;
			}
			if(hour>8&&hour<17) {
				return 2;
			}
			return 4;
		}
		if(attType==1) {
			if(hour<17&&hour>8) {
				return 3;
			}
			if(hour>16&&hour<19) {
				return 1;
			}
			return 5;
		}
		return 0;//�����ڵ�ֵ
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}








