package edu.kh.jvj.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/admin/member/*")
public class AdminMemberController {
	
	@GetMapping("login")
	public String AdmingLogin() {
		return "/admin/adminLogin";
	}
	
	@PostMapping("login")
	public String AdmingLoginProcess() {
		
		return "/admin/main";
	}
}
