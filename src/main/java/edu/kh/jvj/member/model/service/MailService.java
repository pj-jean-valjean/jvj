package edu.kh.jvj.member.model.service;

import javax.servlet.http.HttpSession;

public interface MailService {
	
	
	void mailSend(HttpSession session, String memberEmail);
	
}
