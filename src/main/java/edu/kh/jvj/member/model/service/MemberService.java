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


	
	

	/** 로그인
	 * @param member
	 * @return loginMember
	 */
	Member login(Member member);


	
	/** 동일 이메일 조회
	 * @param map
	 * @return result
	 */
	int checkEmail(Map<String, String> map);

	/** 이메일 찾기
	 * @param map
	 * @return result
	 */
	int searchEmail(Map<String, String> map);


	

	
	
	
	
	
}
