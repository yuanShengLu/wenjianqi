package com.lyq.entity;

import java.util.List;

public class Page<T> {
	private int pageNo;//��ǰҳ��
	private List<T> list;//��ǰҳ����Ӧ�ļ���
	private int pageSize;//һҳ��ʾ���ٸ���¼
	private int totalItemNumber;//�ܹ����ټ�¼
	private int itemStartFrom;
	
	
	public int getItemStartFrom() {
		return (pageNo-1)*pageSize;
	}
	public void setItemStartFrom(int itemStartFrom) {
		this.itemStartFrom = itemStartFrom;
	}
	public Page(int pageNo) {
		super();
		this.pageNo = pageNo;
	}
	public Page() {
		super();
	}
	public int getPageNo() {
		//���ж� TODO
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	//ȡ�ù�����ҳ
	public int getTotalPageNumber() {
		int totalPageNumber = totalItemNumber/pageSize;
		if(totalItemNumber%pageSize==0){
			return totalPageNumber;
		}
		return totalPageNumber+1;
	}
	public void setTotalItemNumber(int totalItemNumber) {
		this.totalItemNumber = totalItemNumber;
	}
	//�ж��Ƿ������һҳ
	public boolean isHasPrev(){
		if(pageNo==1){
			return false;
		}
		return true;
	}
	//�ж��Ƿ������һҳ
	public boolean isHasNext(){
		if(pageNo==getTotalPageNumber()){
			return false;
		}
		return true;
	}
	//��ȡ��һҳ
	public int getPrevPage(){
		//TODO ���ж�
		return pageNo-1;
	}
	//��ȡ��һҳ
	public int getNextPage(){
		//TODO ���ж�
		return pageNo+1;
	}
}
