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
//
//	/** 이메일 인증 완료시 상태코드
//	 * @param member
//	 */
//	void updateAuthstatus(Member member);
	
	// 이메일 중복검사
	//int emailDupCheck(String inputEmail, String selectEmail);

	
	
	
	
	
	
}
