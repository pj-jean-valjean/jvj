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

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.jvj.common.Util;
import edu.kh.jvj.member.model.service.MailService;
import edu.kh.jvj.member.model.service.MemberService;
import edu.kh.jvj.member.model.vo.Member;
import edu.kh.jvj.member.model.vo.SnsLogin;
import edu.kh.jvj.member.model.vo.SnsValue;

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
   
   @Autowired
	private SnsValue naverSns;
	
	@Autowired
	private SnsValue kakaoSns;

   
   @RequestMapping(value = "login", method = RequestMethod.GET)
   public String login(Model model, HttpSession session) {
	   
	SnsLogin naverLogin = new SnsLogin(naverSns);
	model.addAttribute("naver_url", naverLogin.getNaverAuthURL());
	
	SnsLogin kakaoLogin = new SnsLogin(kakaoSns);
	model.addAttribute("kakao_url", kakaoLogin.getNaverAuthURL());
	
      return "member/login";
   }
   
   @RequestMapping(value = "login", method = RequestMethod.POST)
   public String login(Member member, @RequestParam(value="save", required = false) String save,
                  Model model, HttpServletRequest req, HttpServletResponse resp, RedirectAttributes ra) {
      
      Member loginMember = service.login(member);
      String path = "";
      
      if(loginMember != null) {
         model.addAttribute("loginMember", loginMember);
         Cookie cookie = new Cookie("saveId", loginMember.getMemberEmail());
         
         if(save != null) {
            cookie.setMaxAge(60 * 60 * 24 * 30);
         } else {
            cookie.setMaxAge(0);
         }
         
         cookie.setPath(req.getContextPath());
         
         resp.addCookie(cookie);
         
         path = "redirect:/";
      } else {
         path = "member/login";
            String title = "로그인 실패";
            String text = "아이디 또는 비밀번호를 확인해주세요.";
            String icon = "error";
            model.addAttribute("title", title);
            model.addAttribute("text", text);
            model.addAttribute("icon", icon);
      }
      return path;
   }
   
   @RequestMapping(value="/{service}/callback", method = {RequestMethod.GET, RequestMethod.POST})
	public String snsLoginCallback(@PathVariable String snsService, Model model, @RequestParam String code, HttpSession session) throws Exception{
		// 1. code를 이용해서 access_token 받기
		
		// 2. access_token 이용해서 사용자 profile 정보 가져오기
		
		SnsValue sns = null;
		
		if(StringUtils.equals("naver", snsService)) {
			sns = naverSns;
		} else if(StringUtils.equals("kakao", snsService)) {
			
		}
		
		SnsLogin snsLogin = new SnsLogin(sns);
		Member snsUser = snsLogin.getUserProfile(code);
		
		model.addAttribute("result", snsUser);
		
		// 3. DB에 해당 유저가 존재하는지 체크(googleId, naverId 컬럼 추가)
		Member user = null; // = service.getBySns(snsUser); 
		
		if(user == null) { // 회원이 없는 경우
			
		} else { // 회원이 있는 경우
			// 4. 존재 시 강제 로그인, 미 존재시 가입페이지 !!
			
		}
		
		
		return "loginResult";
	}

   @RequestMapping(value = "logout", method = RequestMethod.GET)
   public String logout(SessionStatus status) {
      status.setComplete();
      
      return "redirect:/";
   }
   
   
   
   @RequestMapping(value = "signUp", method = RequestMethod.GET)
   public String signUp() {
      return "member/signUp";
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
   
   // 이메일 중복 검사(ajax)
   @RequestMapping(value="emailDupCheck", method = RequestMethod.POST)
   @ResponseBody
   public int emailDupCheck(String memberEmail) {      
      int result = service.emailDupCheck(memberEmail);
      return result;
   }

   
   // 이메일 찾기 화면 전환
   @RequestMapping(value = "searchId", method = RequestMethod.GET)
   public String searchId() {
      return "member/searchId";
   }
   
   // 이메일 찾기
   @RequestMapping(value = "searchId", method = RequestMethod.POST)
   public String searchId(String memberName, String[] phone, Model model) {
      
      Map<String, String> map = new HashMap<String, String>();
      String memberPhone = "";
      
      for(int i = 0; i < phone.length; i++) {
    	  if(i == 2) {
    		  memberPhone += phone[i];
    	  } else {
    		  memberPhone += phone[i] + "-";
    	  }
      }
      
      map.put("memberName", memberName);
      map.put("memberPhone", memberPhone);
      
      String memberEmail = service.searchId(map);
      
      String path = null;
      
      // 동일 아이디 조회
      if(memberEmail != null) { // 조회 시 값이 있다면
         model.addAttribute("memberEmail", memberEmail);
         path =  "member/searchIdResult";
      
      } else {
         Util.swalSetMessage("존재하지 않는 회원입니다", null, "error", model);
         path =  "member/searchId";
      }
      return  path;
   }

   // 비밀번호 찾기
   @RequestMapping(value = "searchPw", method = RequestMethod.GET)
   public String searchPw() {
      return "member/searchPw";
   }
   
   
   @RequestMapping(value = "searchPw", method = RequestMethod.POST)
   public String searchPw(String memberEmail,  Model model) {
	  // 쿠키 설정 카운트는 쿠키에 설정해서 카운트다운
	  
	  model.addAttribute("memberEmail", memberEmail);
      return "member/searchPwResult";
   }
   
   
   // 이메일과 변경할 비밀번호
   @RequestMapping(value = "searchPwResult", method = RequestMethod.POST)
   public String searchPwResult(
		   String memberEmail, String newPw1, Model model) {
	   	Map<String, String> map = new HashMap<String, String>();

	   	map.put("memberEmail", memberEmail);
	   	map.put("newPw1", newPw1);
	   	
	   	
		// 비밀번호 업데이트
		int result = service.searchPwResult(map);
		
		if(result > 0) {
			Util.swalSetMessage("비밀번호가 변경되었습니다.", null, "success", model);
		} else {
			Util.swalSetMessage("비밀번호가 변경되지 않았습니다.", null, "error", model);
		}
		
		return "member/login";
	}

   
   
   
   // 카운트 다운
   @ResponseBody
   @RequestMapping("emailCountdown")
   private int emailCountdown(HttpServletRequest request, String memberEmail) {
	  
	   return 0;
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
   
   
   

   
   
}