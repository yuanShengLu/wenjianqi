package com.lyq.entity;

import java.util.List;

public class Page<T> {
	private int pageNo;//当前页数
	private List<T> list;//当前页所对应的集合
	private int pageSize;//一页显示多少个记录
	private int totalItemNumber;//总共多少记录
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
		//少判断 TODO
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
	//取得共多少页
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
	//判断是否存在上一页
	public boolean isHasPrev(){
		if(pageNo==1){
			return false;
		}
		return true;
	}
	//判断是否存在下一页
	public boolean isHasNext(){
		if(pageNo==getTotalPageNumber()){
			return false;
		}
		return true;
	}
	//获取上一页
	public int getPrevPage(){
		//TODO 少判断
		return pageNo-1;
	}
	//获取下一页
	public int getNextPage(){
		//TODO 少判断
		return pageNo+1;
	}
}
