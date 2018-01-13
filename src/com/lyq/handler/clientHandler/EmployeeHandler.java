package com.lyq.handler.clientHandler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lyq.entity.Attendance;
import com.lyq.entity.Employee;
import com.lyq.entity.Resume;
import com.lyq.entity.Reword;
import com.lyq.entity.Suggest;
import com.lyq.entity.Train;
import com.lyq.entity.User;
import com.lyq.service.AttendanceService;
import com.lyq.service.EmployeeService;
import com.lyq.service.InterviewService;
import com.lyq.service.PositionService;
import com.lyq.service.ResumeService;
import com.lyq.service.RewordService;
import com.lyq.service.SuggestService;
import com.lyq.service.TrainService;
import com.lyq.service.UserService;
import com.lyq.util.App;
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
	@Autowired
	private AttendanceService attendanceService;
	@Autowired
	private RewordService rewordService;
	@Autowired
	private SuggestService suggestService;
	@Autowired
	private TrainService trainService;
	
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
		Date date = new Date();
		Date lastAttDate = attendanceService.queryMaxAttTime(empId, 0);
		Attendance att = new Attendance();
		att.setAttMonth(date.getMonth()+1);
		att.setAttYear(date.getYear()+1900);
		att.setEmpId(empId);
		att.setAttType(0);
		att.setAttTime(date);
		if(lastAttDate==null) {
			att.setAttStatus(App.work(date, 0));
			attendanceService.addAttendance(att);
			return App.work(date, 0)+"";
		}
		if(date.getMonth()==lastAttDate.getMonth()&&date.getDay()==lastAttDate.getDay()&&date.getHours()<17) {
			return "0";
		}else {
			att.setAttStatus(App.work(date, 0));
			attendanceService.addAttendance(att);
			return App.work(date, 0)+"";
		}
	}
	
	@RequestMapping("ajaxLeave")
	@ResponseBody
	public String ajaxLeave(Integer empId) {
		Date date = new Date();
		Date lastAttDate = attendanceService.queryMaxAttTime(empId, 1);
		Attendance att = new Attendance();
		att.setAttMonth(date.getMonth()+1);
		att.setAttYear(date.getYear()+1900);
		att.setEmpId(empId);
		att.setAttType(1);
		att.setAttTime(date);
		if(lastAttDate==null) {
			att.setAttStatus(App.work(date, 1));
			attendanceService.addAttendance(att);
			return App.work(date, 1)+"";
		}
		if(date.getMonth()==lastAttDate.getMonth()&&date.getDay()==lastAttDate.getDay()&&date.getHours()<19) {
			return "0";
		}else {
			att.setAttStatus(App.work(date, 1));
			attendanceService.addAttendance(att);
			return App.work(date, 1)+"";
		}
	}
	
	
	@RequestMapping("ajaxAddReward")
	@ResponseBody
	public String ajaxAddReward(Integer empId,Double rewMoney,String rewReason,Integer rewType) {
		Reword reword = new Reword();
		reword.setEmpId(empId);
		reword.setRewMoney(rewMoney);
		reword.setRewReason(rewReason);
		reword.setRewType(rewType);
		rewordService.addReword(reword);
		return "";
	}
	
	@RequestMapping("ajaxReleaseSalary")
	@ResponseBody
	public String ajaxReleaseSalary(Integer deptId) {
		Date date = new Date();
		if(date.getDate()>2) {
			return "0";
		}
		employeeService.releaseSalary(deptId);
		return "1";
	}
	
	@RequestMapping("ajaxUpdateResume")
	@ResponseBody
	public String ajaxUpdateResume(Resume resume) {
		resumeService.updateEmpResume(resume);
		return "";
	}
	
	@RequestMapping("ajaxSendSuggest")
	@ResponseBody
	public String ajaxSendSuggest(Suggest suggest) {
		suggestService.addSuggest(suggest);
		return "";
	}
	
	@RequestMapping("ajaxAddTrain")
	@ResponseBody
	public String ajaxAddTrain(Train train) {
		trainService.addTrain(train);
		return "";
	}
	
	@RequestMapping("ajaxUpdateTrain")
	@ResponseBody
	public String ajaxUpdateTrain(Train train) {
		trainService.updateTrain(train);
		return "";
	}
	
	@RequestMapping("ajaxDelTrain")
	@ResponseBody
	public String ajaxDelTrain(Integer tId) {
		trainService.delTrain(tId);
		return "";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@InitBinder
	public void initBinder(ServletRequestDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
	
	
}
