package edu.kh.jvj.member.model.dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.jvj.member.model.vo.Member;

@Repository
public class MemberDAO {
	
	@Autowired	
	private SqlSessionTemplate sqlSession; 
	
	
	
	/** 일반 회원가입
	 * @param member
	 * @return result
	 */
	public int signUp(Member member) {

		return sqlSession.insert("memberMapper.signUp", member);
	}
	
	
	/** 이메일 찾기
	 * @param memberName
	 * @param memberPhone
	 * @return result
	 */
	public int searchId(String memberName, String memberPhone) {
		return 0;
	}


	/** 로그인
	 * @param memberEmail
	 * @return loginMember
	 */
	public Member login(String memberEmail) {
		return sqlSession.selectOne("memberMapper.login", memberEmail);
	}

//	/** 이메일 중복 검사
//	 * @param inputEmail
//	 * @param selectEmail
//	 * @return result
//	 */
//	public int emailDupCheck(String inputEmail, String selectEmail) {
//		return sqlSession.selectList("memberMapper.emailDupCheck", inputEmail,selectEmail);
//	}
//	
	
	
	
}
