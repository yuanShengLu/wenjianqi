package com.lyq.handler.clientHandler;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lyq.entity.Attendance;
import com.lyq.entity.Employee;
import com.lyq.entity.Resume;
import com.lyq.entity.User;
import com.lyq.service.EmployeeService;
import com.lyq.service.InterviewService;
import com.lyq.service.PositionService;
import com.lyq.service.ResumeService;
import com.lyq.service.UserService;
@RequestMapping("employeeHandler")
@Controller
public class EmployeeHandler {
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private UserService userService;
	@Autowired
	private ResumeService resumeService;
	@Autowired
	private PositionService positionService;
	@Autowired
	private InterviewService interviewService;
	
	@RequestMapping("ajaxAddEmp")
	@ResponseBody
	public String ajaxAddEmp(Employee emp,Integer userId,Integer interId,String deptName,String posiName) {
		emp.setEmpServingTime(new Date());
		User user = userService.queryUserByResumeId(emp.getEmpResumeId());
		Resume resume = resumeService.queryResumeByResumeId(emp.getEmpResumeId());
		emp.setEmpAccount(user.getUserAccount());
		emp.setEmpPassword(user.getUserPassword());
		emp.setEmpName(resume.getRealName());
		emp.setEmpDeptId(positionService.queryPositionByPoName(posiName).getPoDeptId());
		emp.setEmpPositionId(positionService.queryPositionByPoName(posiName).getPoId());
		emp.setEmpStatus(" ‘”√∆⁄");
		employeeService.addEmployee(emp, interId);
		return "";
	}
	
	@RequestMapping("ajaxDisAgree")
	@ResponseBody
	public String ajaxDisAgree(Integer interId) {
		interviewService.updateIsAcceptFromSup(3, interId);
		return "";
	}
	
	@RequestMapping("ajaxAttend")
	@ResponseBody
	public String ajaxAttend(Integer empId) {
		Attendance att = new Attendance();
		att.setEmpId(empId);
		att.setAttType(0);
		Date date = new Date();
		if(date.getHours()<9) {
			
		}
		return "";
	}
	
	@RequestMapping("ajaxLeave")
	@ResponseBody
	public String ajaxLeave(Integer empId) {
		Attendance att = new Attendance();
		att.setEmpId(empId);
		att.setAttType(1);
		return "";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
