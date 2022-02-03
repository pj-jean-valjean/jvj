package edu.kh.jvj.member.model.service;

import java.util.Map;

import edu.kh.jvj.member.model.vo.Member;

public interface MemberService {

	/** 일반 회원가입
	 * @param member
	 * @return 
	 * @throws Exception
	 */
	int signUp(Member member);

	
	/** 인증번호 생성기
	 * @param inputEmail
	 * @return
	 */
	String authCodeMaker(String inputEmail);


	
	/** 이메일 찾기
	 * @param memberName
	 * @param memberPhone
	 * @return result
	 */
	int searchId(String memberName, String memberPhone);
	

	
	
	
	
	
}
