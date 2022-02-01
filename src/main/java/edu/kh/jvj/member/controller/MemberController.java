package edu.kh.jvj.member.controller;

import java.sql.Date;
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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.kh.jvj.member.model.service.MemberService;

@Controller
@RequestMapping("/member/*")
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

	
	
	
	
	
	// 메일링
	@RequestMapping(value = "sendEmail")
	private void emailAuthentication(String inputEmail, HttpServletRequest req, HttpServletResponse resp,
			MemberService service) {

		// 메일 인코딩
		final String bodyEncoding = "UTF-8"; // 콘텐츠 인코딩

		String subject = "."; // 이메일 제목
		String fromEmail = ""; // 발송자 이메일
		String fromUsername = "JVJ"; // 발송자 이름
		String toEmail = inputEmail; // 콤마(,)로 여러개 나열

		final String username = "bongguking08@gmail.com";
		final String password = "bbang24601!";

		

		
		try {

			// DB에 코드 저장
			String authCode = service.authCodeMaker(inputEmail);

			if (!authCode.equals("")) {

				// 메일에 출력할 텍스트
				StringBuffer sb = new StringBuffer();
				sb.append("<h3>이메일 인증입니다.</h3>");

				String html = sb.toString();

				// 메일 옵션 설정
				Properties props = new Properties();
					props.put("mail.transport.protocol", "smtp");
					props.put("mail.smtp.host", "smtp.gmail.com");
					props.put("mail.smtp.port", "587");
					props.put("mail.smtp.auth", "true");
	
					props.put("mail.smtp.quitwait", "false");
					props.put("mail.smtp.socketFactory.port", "587");
					props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
					props.put("mail.smtp.socketFactory.fallback", "true");
					props.put("mail.smtp.starttls.enable", "true");

				// 메일 서버 인증 계정 설정
				Authenticator auth = new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				};
				
				// 인증 번호 생성기
				StringBuffer temp = new StringBuffer();
				Random rnd = new Random();
				for (int i = 0; i < 10; i++) {
					int rIndex = rnd.nextInt(3);
					switch (rIndex) {
					case 0:
						// a-z
						temp.append((char) ((int) (rnd.nextInt(26)) + 97));
						break;
					case 1:
						// A-Z
						temp.append((char) ((int) (rnd.nextInt(26)) + 65));
						break;
					case 2:
						// 0-9
						temp.append((rnd.nextInt(10)));
						break;
					}
				}
				String AuthenticationKey = temp.toString();

				Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});
				
				
				
				
				
				// 메일 세션 생성
				// Session session = Session.getInstance(props, auth);
				Session mailSession = Session.getDefaultInstance(props);

				// 메일 송/수신 옵션 설정
				Message mailMessage = new MimeMessage(mailSession);
					mailMessage.setFrom(new InternetAddress(fromEmail, fromUsername));
					mailMessage.setRecipients(RecipientType.TO, InternetAddress.parse(toEmail, false));
					mailMessage.setSubject(subject);
					mailMessage.setSentDate(new Date(0));

				// 메일 콘텐츠 설정
				Multipart mParts = new MimeMultipart();
				MimeBodyPart mTextPart = new MimeBodyPart();
				MimeBodyPart mFilePart = null;

				// 메일 콘텐츠 - 내용
				mTextPart.setText(html, bodyEncoding, "html");
				mParts.addBodyPart(mTextPart);

				// 메일 콘텐츠 설정
				mailMessage.setContent(mParts);

				// MIME 타입 설정
				MailcapCommandMap MailcapCmdMap = (MailcapCommandMap) CommandMap.getDefaultCommandMap();
				MailcapCmdMap.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html");
				MailcapCmdMap.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml");
				MailcapCmdMap.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain");
				MailcapCmdMap.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed");
				MailcapCmdMap
						.addMailcap("message/rfc822;; x-java-content-handler=com.sun.mail.handlers.message_rfc822");
				CommandMap.setDefaultCommandMap(MailcapCmdMap);

				// 메일 발송
				Transport t = mailSession.getTransport("smtp");
				t.connect(username, password);
				t.sendMessage(mailMessage, mailMessage.getAllRecipients());
				t.close();

				// Transport.send( message );

				resp.getWriter().print(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
