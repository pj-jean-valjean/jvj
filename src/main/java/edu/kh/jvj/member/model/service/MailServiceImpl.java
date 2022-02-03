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
	
	@Override
	public void mailSend(HttpSession session, String memberEmail) {
		
		try{
			MailHandler mailHandler = new MailHandler(javaMailSenderImpl);
			Random random = new Random(System.currentTimeMillis());
			long start = System.currentTimeMillis();
			
			int result = 100000 + random.nextInt(900000);
			
			System.out.println("memberEmail :"+ memberEmail);
			
			mailHandler.setTo(memberEmail);
			mailHandler.setFrom("bongguking08@gmail.com");
			mailHandler.setSubject("jvj 인증번호입니다");
			String htmlContent = "<p>인증번호 : "+result+"<p>";
			mailHandler.setText(htmlContent, true);
			
			mailHandler.send();
			
			long end = System.currentTimeMillis();
			
			session.setAttribute(""+memberEmail, result);
			System.out.println( "실행시간 : "+ ( end - start)/1000.0 );
			
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
		
	}

}
