package edu.kh.jvj.member.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import javax.activation.CommandMap;
import javax.activation.MailcapCommandMap;
import javax.inject.Inject;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.jvj.member.model.service.MailService;
import edu.kh.jvj.member.model.service.MemberService;
import edu.kh.jvj.member.model.vo.Member;

@Controller
@RequestMapping("/member/*")
@SessionAttributes({"loginMember"}) 
public class MemberController {

	@Autowired
	private MemberService service;
	
	@Autowired
	private MailService mailService;
	
	@Autowired 
	JavaMailSender mailSender;

	
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

	
	// 회원 가입
	@RequestMapping(value="signUp", method = RequestMethod.POST)
	public String signUp(Member member, RedirectAttributes ra) {
		
		int result = service.signUp(member);
		
		String title;
		String text;
		String icon;
		
		if(result > 0) { // 성공
			title = "회원 가입 성공!";
			text = member.getMemberName() + "님! 회원가입 완료.";
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
	
	// 인증번호 전송
	@ResponseBody
	@RequestMapping("email")
	private int sendEmail(HttpServletRequest request, String memberEmail) {
		HttpSession session = request.getSession();
		mailService.mailSend(session, memberEmail);
		
		return 0;
	}
	
	// 인증번호 확인
	@ResponseBody
	@RequestMapping("certification")
	private boolean emailCertification(HttpServletRequest request, String memberEmail, int inputCode) {
		
		HttpSession session = request.getSession();
		boolean result = mailService.emailCertification(session, memberEmail, inputCode);
		return result;
		
	}
	
	
	

	
	// 이메일 찾기
	@RequestMapping(value = "searchId", method = RequestMethod.POST)
	public String searchId(Member member, String memberName, String memberPhone) {
		
		int result = service.searchId(memberName, memberPhone);
		
		
		return "member/searchIdResult";
	}
}
