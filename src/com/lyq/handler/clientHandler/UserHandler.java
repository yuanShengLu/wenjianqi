package com.lyq.handler.clientHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lyq.entity.Resume;
import com.lyq.entity.User;
import com.lyq.service.ResumeService;
import com.lyq.service.UserService;

@RequestMapping("userHandler")
@Controller
public class UserHandler {
	@Autowired
	private UserService userService;
	@Autowired
	private ResumeService resumeService;
	
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
		return "userIndex";
	}
	
	@RequestMapping("turnRegistPage")
	public String turnRegistPage() {
		return "regist";
	}
	
	@RequestMapping("login")
	public String login(String name,String password,Model model) {
		User user =new User();
		user.setUserAccount(name);
		user.setUserPassword(password);
		user = userService.queryUser(user);
		if(user==null)
			return "noUser";
		model.addAttribute("user", user);
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
	
	
	
	
	
	
	
	
	
	
	
}
