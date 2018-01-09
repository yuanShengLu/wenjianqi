package com.lyq.entity;

import java.util.List;

public class Position {
	private int poId;
	private String poName;
	private int poDeptId;
	private List<Employee> employees;
	
	
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	public int getPoDeptId() {
		return poDeptId;
	}
	public void setPoDeptId(int poDeptId) {
		this.poDeptId = poDeptId;
	}
	public int getPoId() {
		return poId;
	}
	public void setPoId(int poId) {
		this.poId = poId;
	}
	public String getPoName() {
		return poName;
	}
	public void setPoName(String poName) {
		this.poName = poName;
	}
	public Position() {
		super();
	}
	@Override
	public String toString() {
		return "Position [poId=" + poId + ", poName=" + poName + "]";
	}
	
}
