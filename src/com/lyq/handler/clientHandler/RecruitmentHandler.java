package com.lyq.handler.clientHandler;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lyq.entity.Department;
import com.lyq.entity.Position;
import com.lyq.entity.Recruitment;
import com.lyq.entity.Supervisor;
import com.lyq.service.DepartmentService;
import com.lyq.service.PositionService;
import com.lyq.service.RecruitmentService;
import com.lyq.service.ResumeService;
import com.lyq.service.SupervisorService;
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
	
	
	
	
	
	
	
	
	@RequestMapping("turnIndex")
	public String turnIndex(Integer supId,Model model) {
		 Supervisor sup = supervisorService.querySupBySupId(supId);
		 model.addAttribute("sup", sup);
		 List<Position> pList = positionService.queryPositionByDept(sup.getSupDeptId());
		model.addAttribute("pList", pList);
		List<Recruitment> recList = recruitmentService.queryNewResume(sup.getSupId());
		model.addAttribute("rec", recList);
		return "supIndex";
	}
	
}
