package com.lyq.handler.clientHandler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lyq.entity.Employee;
@RequestMapping("employeeHandler")
@Controller
public class EmployeeHandler {
	
	@RequestMapping("ajaxAddEmp")
	@ResponseBody
	public String ajaxAddEmp(Employee emp,Integer userId,Integer interId,String deptName,String posiName) {
		System.out.println(emp);
		System.out.println(userId+"--"+interId+"--"+deptName+"--"+posiName);
		
		return "";
	}
}
