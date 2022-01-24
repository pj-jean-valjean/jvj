package edu.kh.jvj.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class AdminMemberController {
	@GetMapping("admin/login")
	public String AdmingLogin() {
		return "/admin/adminLogin";
	}
}
