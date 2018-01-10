package com.lyq.handler.clientHandler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lyq.entity.Department;
import com.lyq.entity.Interview;
import com.lyq.entity.Position;
import com.lyq.entity.Recruitment;
import com.lyq.entity.Supervisor;
import com.lyq.entity.User;
import com.lyq.service.DepartmentService;
import com.lyq.service.InterviewService;
import com.lyq.service.PositionService;
import com.lyq.service.RecruitmentService;
import com.lyq.service.ResumeService;
import com.lyq.service.SupervisorService;
import com.lyq.service.UserService;
@RequestMapping("recruitmentHandler")
@Controller
public class RecruitmentHandler {
	@Autowired
	private SupervisorService supervisorService;
	@Autowired
	private PositionService positionService;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private RecruitmentService recruitmentService;
	@Autowired
	private ResumeService resumeService;
	@Autowired
	private InterviewService interviewService;
	@Autowired
	private UserService userService;
	
	@RequestMapping("createRecru")
	public String createRecru(Recruitment recru,Integer supDeptId,Integer supId) {
		Department dept = departmentService.queryDeptById(supDeptId);
		recru.setRecDept(dept.getDeptName());
		recru.setRecReleaseTime(new Date());
		recru.setRecSupervisorId(supId);
		recruitmentService.addRecru(recru);
		return "forward:turnIndex";
	}
	
	@RequestMapping("addRec")
	public String addRec(Integer recId,Integer resumeId) {
		resumeService.updateRecId(resumeId, recId,0);
		return "forward:/userHandler/turnIndex";
	}
	
	@RequestMapping("ajaxConfirmRec")
	@ResponseBody
	public String ajaxConfirmRec(Integer resumeId,Integer recId,Date interviewDate,Integer supId) {
		Date date = new Date();
		if(date.compareTo(interviewDate)<0) {
			resumeService.updateRecId(resumeId, recId, 1);
			Interview inter = new Interview();
			User user = userService.queryUserByResumeId(resumeId);
			inter.setUserId(user.getUserId());
			inter.setInterIsAccept(0);
			inter.setInterTime(interviewDate);
			inter.setRecId(recId);
			inter.setInterIsAccept(2);//2ÎªÎ´´¦Àí
			inter.setResumeId(resumeId);
			inter.setSupId(supId);
			interviewService.addInterview(inter);
			return "1";
		}
		return "0";
	}
	
	@RequestMapping("ajaxDenyRec")
	@ResponseBody
	public String ajaxDenyRec(Integer resumeId,Integer recId) {
		resumeService.updateRecId(resumeId, recId, 1);
		return "";
	}
	
	@RequestMapping("ajaxIsAttend")
	@ResponseBody
	public String ajaxIsAttend(Integer isAttend,Integer userId) {
		interviewService.updateIsAccept(isAttend, userId);
		return "";
	}
	
	
	@RequestMapping("turnIndex")
	public String turnIndex(Integer supId,Model model) {
		 Supervisor sup = supervisorService.querySupBySupId(supId);
		 model.addAttribute("sup", sup);
		 List<Position> pList = positionService.queryPositionByDept(sup.getSupDeptId());
		model.addAttribute("pList", pList);
		List<Recruitment> recList = recruitmentService.queryNewResume(sup.getSupId());
		model.addAttribute("rec", recList);
		List<Interview> iList = interviewService.queryInterviewBySupId(sup.getSupId());
		model.addAttribute("iList", iList);
		return "supIndex";
	}
	
	@InitBinder
	public void initBinder(ServletRequestDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
	
}
