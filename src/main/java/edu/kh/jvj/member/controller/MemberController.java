package edu.kh.jvj.member.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.jvj.member.model.service.MemberService;
import edu.kh.jvj.member.model.vo.Member;

@Controller
@RequestMapping("/member/*")
@SessionAttributes({"loginMember"}) 
public class MemberController {

	@Autowired
	private MemberService service;
	

	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login() {
		return "member/login";
	}

	@RequestMapping(value = "signUp", method = RequestMethod.GET)
	public String signUp() {
		return "member/signUp";
	}

	@RequestMapping(value = "searchId", method = RequestMethod.GET)
	public String searchId() {
		return "member/searchId";
	}

	@RequestMapping(value = "searchIdResult", method = RequestMethod.POST)
	public String searchIdResult() {
		return "member/searchIdResult";
	}

	@RequestMapping(value = "searchPw", method = RequestMethod.GET)
	public String searchPw() {
		return "member/searchPw";
	}

	@RequestMapping(value = "searchPwResult", method = RequestMethod.POST)
	public String searchPwResult() {
		return "member/searchPwResult";
	}

	// email 중복 검사
//	@RequestMapping("emailDupCheck")
//	@ResponseBody
//	public int emailDupCheck(String inputEmail, String selectEmail) {
//		return service.emailDupCheck(inputEmail,selectEmail);
//	}
	
	
	// 회원 가입
	@RequestMapping(value="signUp", method = RequestMethod.POST)
	public String signUp(Member member, RedirectAttributes ra) {
		
		int result = service.signUp(member);
		
		
		String title;
		String text;
		String icon;
		
		if(result > 0) { // 성공
			title = "회원 가입 성공!";
			text = member.getMemberName() + "님! 이메일 인증을 완료하여 회원가입을 해주세요.";
			icon = "success"; // 총 4개 가능  "error"/ "success" /"warning"/ "info"
		} else { // 실패
			title = "회원 가입 실패!";
			text = "관리자에 문의해주세요.";
			icon = "error"; 
		}
		
		ra.addFlashAttribute("title", title);
		ra.addFlashAttribute("text", text);
		ra.addFlashAttribute("icon", icon);
		
		return "redirect:/";
	}
	
	
	// 이메일 인증 완료시 진행
//	@RequestMapping(value="signUp", method=RequestMethod.POST)
//	public String signUp(Member member){
//		try {
//			service.signUp(member);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return "member/signUp";
//	}
//	
//	
//	@RequestMapping(value="signUpConfirm", method=RequestMethod.GET)
//	public String emailConfirm(Member member, Model model) throws Exception {
//		member.setAuthStatus(1);	// authstatus를 1로,, 권한 업데이트
//		service.updateAuthstatus(member);
//		
//		model.addAttribute("auth_check", 1);
//		
//		return "member/signUp";
//	}
	
	
}
