package edu.kh.jvj.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping
public class AdminMemberController {
	//로그인 페이지
	@GetMapping("admin/login")
	public String AdmingLogin() {
		return "/admin/adminLogin";
	}
	//로그인 일치시 관리자페이지 메인 이동
	@PostMapping("admin/board/main")
	public String AdmingLoginProcess(
			String adminId, String adminPw,
			RedirectAttributes ra, Model model
			) {
		String path = "";
		if(adminId.equals("admin")&&adminPw.equals("admin1234")) {
			path =  "admin/adminMain";
		}
		else{
			path = "redirect:/admin/login";
			ra.addFlashAttribute("message", "아이디 비밀번호를 확인해주세요!");
		}
		return path;
	}
}
