package edu.kh.jvj.member.model.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.jvj.member.model.dao.MemberDAO;

import edu.kh.jvj.member.model.vo.Member;


@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDAO dao;
	
//	@Autowired
//	private JavaMailSender mailSender;	
//	
	@Autowired 
	private BCryptPasswordEncoder encoder;


	// 회원가입 
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int signUp(Member member) {
		String encPw = encoder.encode(member.getMemberPw());
		member.setMemberPw(encPw);
		
		return dao.signUp(member);
	}
	
//	// 이메일 중복검사
//	@Override
//	public int emailDupCheck(String inputEmail, String selectEmail) {
//		return dao.emailDupCheck(inputEmail, selectEmail);
//	}
//	

	
	
	
	
	
	
	
	
//	@Override
//	@Transactional
//	public void signUp(Member member) throws Exception {
//		dao.signUp(member);
//	
//		// 임의의 authkey 생성
//		String authkey = new TempKey().getKey(50, false);
//
//		member.setAuthKey(authkey);
//		dao.updateAuthkey(member);
//
//		// mail 작성 관련 
//		MailUtils sendMail = new MailUtils(mailSender);
//
//		sendMail.setSubject("[Hoon's Board v2.0] 회원가입 이메일 인증");
//		sendMail.setText(new StringBuffer().append("<h1>[이메일 인증]</h1>")
//				.append("<p>아래 링크를 클릭하시면 이메일 인증이 완료됩니다.</p>")
//				.append("<a href='http://localhost:8080/user/joinConfirm?uid=")
//				.append("&email=")
//				.append(member.getMemberEmail())
//				.append("&authkey=")
//				.append(authkey)
//				.append("' target='_blenk'>이메일 인증 확인</a>")
//				.toString());
//		sendMail.setFrom("관리자 ", "관리자명");
//		sendMail.setTo(member.getMemberEmail());
//		sendMail.send();
//	}
//
//	// 이메일 인증 완료시 상태코드
//	@Override
//	public void updateAuthstatus(Member member) {
//		dao.updateAuthstatus(member);
//	}



}
