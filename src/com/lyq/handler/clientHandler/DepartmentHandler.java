package com.lyq.handler.clientHandler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.lyq.entity.Admin;
import com.lyq.entity.Department;
import com.lyq.entity.Employee;
import com.lyq.entity.Position;
import com.lyq.service.AdminService;
import com.lyq.service.DepartmentService;
import com.lyq.service.PositionService;
@RequestMapping("departmentHandler")
@Controller
public class DepartmentHandler {
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private PositionService positionService;
	@Autowired
	private AdminService adminSevice;
	
	@RequestMapping(value="ajaxQueryPosition",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String queryPosition(String dept) {
		List<Department> dList = departmentService.queryAllDept();
		List<Position> pList = null;
		for (Department department : dList) {
			if(department.getDeptName().equals(dept)) {
				pList = department.getpList();
			}
		}
		return JSON.toJSONString(pList);
	}
	
	@RequestMapping("addDept")
	public String addDept(String addDept,String addPosition_1,String addPosition_2,String addPosition_3,String addPosition_4,String addPosition_5,String addPosition_6,String addPosition_7) {
		Department dept = new Department();
		dept.setDeptName(addDept);
		departmentService.addDept(dept);
		Department deptReturn = departmentService.queryDeptByName(dept.getDeptName());
		Integer deptId = deptReturn.getDeptId();
		if(addPosition_1!=null&&addPosition_1!="") {
			Position position = new Position();
			position.setPoName(addPosition_1);
			position.setPoDeptId(deptId);
			positionService.addPosition(position);
		}
		if(addPosition_2!=null&&addPosition_2!="") {
			Position position = new Position();
			position.setPoName(addPosition_2);
			position.setPoDeptId(deptId);
			positionService.addPosition(position);
		}
		if(addPosition_3!=null&&addPosition_3!="") {
			Position position = new Position();
			position.setPoName(addPosition_3);
			position.setPoDeptId(deptId);
			positionService.addPosition(position);
		}
		if(addPosition_4!=null&&addPosition_4!="") {
			Position position = new Position();
			position.setPoName(addPosition_4);
			position.setPoDeptId(deptId);
			positionService.addPosition(position);
		}
		if(addPosition_5!=null&&addPosition_5!="") {
			Position position = new Position();
			position.setPoName(addPosition_5);
			position.setPoDeptId(deptId);
			positionService.addPosition(position);
		}
		if(addPosition_6!=null&&addPosition_6!="") {
			Position position = new Position();
			position.setPoName(addPosition_6);
			position.setPoDeptId(deptId);
			positionService.addPosition(position);
		}
		if(addPosition_7!=null&&addPosition_7!="") {
			Position position = new Position();
			position.setPoName(addPosition_7);
			position.setPoDeptId(deptId);
			positionService.addPosition(position);
		}
		return "forward:turnAdminIndex";
	}
	
	@RequestMapping("addPosi")
	public String addPosi(Integer dept,String positionName_1,String positionName_2,String positionName_3,String positionName_4,String positionName_5,String positionName_6) {
		if(positionName_1!=""&&positionName_1!=null) {
			Position position = new Position();
			position.setPoName(positionName_1);
			position.setPoDeptId(dept);
			positionService.addPosition(position);
		}
		if(positionName_2!=""&&positionName_2!=null) {
			Position position = new Position();
			position.setPoName(positionName_2);
			position.setPoDeptId(dept);
			positionService.addPosition(position);
		}
		if(positionName_3!=""&&positionName_3!=null) {
			Position position = new Position();
			position.setPoName(positionName_3);
			position.setPoDeptId(dept);
			positionService.addPosition(position);
		}
		if(positionName_4!=""&&positionName_4!=null) {
			Position position = new Position();
			position.setPoName(positionName_4);
			position.setPoDeptId(dept);
			positionService.addPosition(position);
		}
		if(positionName_5!=""&&positionName_5!=null) {
			Position position = new Position();
			position.setPoName(positionName_5);
			position.setPoDeptId(dept);
			positionService.addPosition(position);
		}
		if(positionName_6!=""&&positionName_6!=null) {
			Position position = new Position();
			position.setPoName(positionName_6);
			position.setPoDeptId(dept);
			positionService.addPosition(position);
		}
		return "forward:turnAdminIndex";
	}
	
	@RequestMapping(value="ajaxQueryPositionByDeptId",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String ajaxQueryPosition(Integer dInfo) {
		List<Position> pList = positionService.queryPositionByDept(dInfo);
		return JSON.toJSONString(pList);
	}
	
	@RequestMapping(value="ajaxQueryEmp",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String ajaxQueryEmp(String pInfo) {
		Position position = positionService.queryEmployeesByPositionName(pInfo);
		List<Employee> eList = position.getEmployees();
		return JSON.toJSONString(eList);
	}
	
	@RequestMapping("turnAdminIndex")
	public String turnAdminIndex(String adminAccount,Model model) {
		List<Department> dList = departmentService.queryAllDeptNameAndId();
		model.addAttribute("dList", dList);
		Admin admin = adminSevice.queryAdminByAccount(adminAccount);
		model.addAttribute("admin", admin);
		return "adminIndex";
	}
	
	
	
	
	
}
