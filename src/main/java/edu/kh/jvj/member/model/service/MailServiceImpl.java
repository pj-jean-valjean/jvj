package edu.kh.jvj.member.model.service;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import edu.kh.jvj.member.model.vo.MailHandler;

@Service
public class MailServiceImpl implements MailService {
	
	@Autowired
	private JavaMailSenderImpl javaMailSenderImpl;
	
	// 인증번호 전송
	@Override
	public void mailSend(HttpSession session, String memberEmail) {
		
		try{
			MailHandler mailHandler = new MailHandler(javaMailSenderImpl);
			Random random = new Random(System.currentTimeMillis());
			long start = System.currentTimeMillis();
			
			int result = 100000 + random.nextInt(900000);
			
			
			mailHandler.setTo(memberEmail);
			mailHandler.setFrom("bongguking08@gmail.com");
			mailHandler.setSubject("JVJ 회원가입 인증번호입니다.");
			String htmlContent = "<p>인증번호 : " + result +"<p> <br>" 
								+"제빵사 봉국옹 ";
			mailHandler.setText(htmlContent, true);
			
			mailHandler.send();
			
			long end = System.currentTimeMillis();
			
			session.setAttribute(""+memberEmail, result);
			System.out.println( "실행시간 : "+ ( end - start)/1000.0 );
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
	
	//인증번호 확인
	@Override
	public boolean emailCertification(HttpSession session, String memberEmail, int inputCode) {
		try {
			int generationCode = (int) session.getAttribute(memberEmail);
			
			if( generationCode == inputCode) 	return true;
			else								return false;
			
		} catch (Exception e) {
			throw e;
		}
		
	
	}

}
