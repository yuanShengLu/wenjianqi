package com.lyq.handler.clientHandler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lyq.entity.Admin;
import com.lyq.entity.Attendance;
import com.lyq.entity.Department;
import com.lyq.entity.Employee;
import com.lyq.entity.Interview;
import com.lyq.entity.Page;
import com.lyq.entity.Position;
import com.lyq.entity.Recruitment;
import com.lyq.entity.Resume;
import com.lyq.entity.Reword;
import com.lyq.entity.Salary;
import com.lyq.entity.Suggest;
import com.lyq.entity.Supervisor;
import com.lyq.entity.Train;
import com.lyq.entity.User;
import com.lyq.service.AdminService;
import com.lyq.service.AttendanceService;
import com.lyq.service.DepartmentService;
import com.lyq.service.EmployeeService;
import com.lyq.service.InterviewService;
import com.lyq.service.PositionService;
import com.lyq.service.RecruitmentService;
import com.lyq.service.ResumeService;
import com.lyq.service.RewordService;
import com.lyq.service.SalaryService;
import com.lyq.service.SuggestService;
import com.lyq.service.SupervisorService;
import com.lyq.service.TrainService;
import com.lyq.service.UserService;

@RequestMapping("userHandler")
@Controller
public class UserHandler {
	@Autowired
	private UserService userService;
	@Autowired
	private ResumeService resumeService;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private AdminService adminService;
	@Autowired
	private SupervisorService supervisorService;
	@Autowired
	private PositionService positionService;
	@Autowired
	private RecruitmentService recruitmentService;
	@Autowired
	private InterviewService interviewService;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private RewordService rewordService;
	@Autowired
	private AttendanceService attendanceSercice;
	@Autowired
	private SalaryService salaryService;
	@Autowired
	private SuggestService suggestService;
	@Autowired
	private TrainService trainService;
	
	@RequestMapping("regist")
	public String regist(String name,String password,Model model) {
		User user =new User();
		user.setUserAccount(name);
		user.setUserPassword(password);
		Integer resumeId = resumeService.addNewResume();
		Resume resume = new Resume();
		resume.setResumeId(resumeId);
		user.setResume(resume);
		userService.addUser(user);
		model.addAttribute("user", user);
		List<Department> dList = departmentService.queryAllDept();
		model.addAttribute("dList",dList);
		return "userIndex";
	}
	
	@RequestMapping("turnRegistPage")
	public String turnRegistPage() {
		return "regist";
	}
	
	@RequestMapping("login")
	public String login(String name,String password,Model model) {
		Admin admin = new Admin();
		admin.setAdminAccount(name);
		admin.setAdminPassword(password);
		User user =new User();
		user.setUserAccount(name);
		user.setUserPassword(password);
		Supervisor supervisor = new Supervisor();
		supervisor.setSupAccount(name);
		supervisor.setSupPassword(password);
		Employee employee = new Employee();
		employee.setEmpAccount(name);
		employee.setEmpPassword(password);
		
		admin = adminService.queryAdmin(admin);
		if(admin!=null) {
			List<Department> dList = departmentService.queryAllDeptNameAndId();
			model.addAttribute("dList", dList);
			model.addAttribute("admin", admin);
			return "adminIndex";
		}
		supervisor = supervisorService.login(supervisor);
		if(supervisor!=null&&!supervisor.getSupStatus().equals("离职")) {
			model.addAttribute("sup", supervisor);
			List<Position> pList = positionService.queryPositionByDept(supervisor.getSupDeptId());
			model.addAttribute("pList", pList);
			Department dept = departmentService.queryDeptById(supervisor.getSupDeptId());
			model.addAttribute("dept", dept);
			List<Recruitment> recList = recruitmentService.queryNewResume(supervisor.getSupId());
			model.addAttribute("rec", recList);
			List<Interview> iList = interviewService.queryInterviewBySupId(supervisor.getSupId());
			model.addAttribute("iList", iList);
			employee = employeeService.login(employee);//管理员同时存在员工表和管理员表
			model.addAttribute("empId",employee.getEmpId());
			List<Suggest> sugList = suggestService.readSuggest(supervisor.getSupId());
			model.addAttribute("sugList", sugList);
			String dateString = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			List<Train> trainList = trainService.queryTrain(dateString, supervisor.getSupDeptId());
			model.addAttribute("trainList", trainList);
			return "supIndex";
		}
		employee = employeeService.login(employee);
		if(employee!=null&&!employee.getEmpStatus().contains("离职")) {
			Date now = new Date();
			if(now.getTime()-employee.getEmpServingTime().getTime()>2592000000l&&!employee.getEmpStatus().equals("在职")&&!employee.getEmpStatus().contains("离职")) {
				employee.setEmpStatus("在职");
				employeeService.updateEmpStatus("在职", employee.getEmpId());
			}
			Department dept = departmentService.queryDeptById(employee.getEmpDeptId());
			model.addAttribute("dept", dept);
			Position posi = positionService.queryPositionById(employee.getEmpPositionId());
			model.addAttribute("posi", posi);
			Resume resume = resumeService.queryResumeByResumeId(employee.getEmpResumeId());
			model.addAttribute("resume", resume);
			model.addAttribute("emp", employee);
			Date date = new Date();
			int year = date.getYear()+1900;
			int month = date.getMonth()+1;
			if(month==1) {
				year = year-1;
				month = 12;
			}else {
				month = month-1;
			}
			List<Reword> rListPlus = rewordService.queryReword(employee.getEmpId(), 1, year, month);//员工奖金
			List<Reword> rListLess = rewordService.queryReword(employee.getEmpId(), 0, year, month);//员工罚金
			List<Attendance> aListAfter = attendanceSercice.queryAttendance(employee.getEmpId(), year, month, 2);//员工迟到次数
			List<Attendance> aListBefore = attendanceSercice.queryAttendance(employee.getEmpId(), year, month, 3);//员工早退次数
			model.addAttribute("rListPlus",rListPlus);
			model.addAttribute("rListLess",rListLess);
			model.addAttribute("aListAfter",aListAfter);
			model.addAttribute("aListBefore",aListBefore);
			Salary salary = salaryService.querySalary(employee.getEmpId(), year, month);
			model.addAttribute("salary", salary);
			String dateString = new SimpleDateFormat("yyyy-MM-dd").format(date);
			List<Train> trainList = trainService.queryTrain(dateString, employee.getEmpDeptId());
			model.addAttribute("trainList", trainList);
			List<Department> dList = departmentService.queryAllDeptNameAndId();
			model.addAttribute("dList", dList);
			return "empIndex";
		}
		user = userService.queryUser(user);
		if(user==null)
			return "noUser";
		model.addAttribute("user", user);
		List<Department> dList = departmentService.queryAllDept();
		model.addAttribute("dList",dList);
		Page<Recruitment> page = new Page<>();
		page.setPageNo(1);
		page.setPageSize(5);//设置一页显示多少数据
		Integer totalItem = recruitmentService.queryRecNum();
		page.setTotalItemNumber(totalItem);
		List<Recruitment> rList = recruitmentService.queryLimitedRec(page);
		page.setList(rList);
		model.addAttribute("page", page);
		List<Interview> iList = interviewService.queryInterviewByUserId(user.getUserId());
		model.addAttribute("iList", iList);
		return "userIndex";
	}
	
	@RequestMapping("ajaxCheckUserAccount")
	@ResponseBody
	public String ajaxCheckUserAccount(String name) {
		User user = userService.queryUserByAccount(name);
		if(user==null)
			return "0";
		return "1";
	}
	
	@RequestMapping("updatePassword")
	public String updatePassword(User user,String newPassword,Model model) {
		User oldUser = userService.queryUser(user);
		if(oldUser!=null) {
			user.setUserPassword(newPassword);
			userService.updatePassword(user);
			user.setUserPassword(newPassword);//这里User会自己变，太神奇了,所以重新设置一下密码
			User newUser = userService.queryUser(user);
			model.addAttribute("user", newUser);
			return "correctInfo";
		}
		User u = userService.queryUserByAccount(user.getUserAccount());
		model.addAttribute("user", u);
		return "wrongInfo";
	}
	
	@RequestMapping("turnIndex")
	public String turnIndex(String userAccount,Model model,Integer pageNo,Boolean isTurnPage) {
		User user = userService.queryUserByAccount(userAccount);
		model.addAttribute("user", user);
		List<Department> dList = departmentService.queryAllDept();
		model.addAttribute("dList",dList);
		Page<Recruitment> page = new Page<>();
		page.setPageSize(5);//设置一页显示多少数据
		Integer totalItem = recruitmentService.queryRecNum();
		page.setTotalItemNumber(totalItem);
		page.setPageNo(1);
		if(pageNo!=null) {
			if(pageNo>0&&pageNo<=page.getTotalPageNumber()) {
				page.setPageNo(pageNo);
			}
		}
		List<Recruitment> rList = recruitmentService.queryLimitedRec(page);
		page.setList(rList);
		model.addAttribute("page", page);
		model.addAttribute("isTurnPage", isTurnPage);
		List<Interview> iList = interviewService.queryInterviewByUserId(user.getUserId());
		model.addAttribute("iList", iList);
		return "userIndex";
	}
	
	@RequestMapping("updateResume")
	public String updateResume(Resume resume,User user) {
		resumeService.updateResume(resume);
		return "correctInfo";
	}
	
	
	
	
	
	
}
