package edu.kh.jvj.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

//	/** 이메일 중복 검사
//	 * @param inputEmail
//	 * @param selectEmail
//	 * @return result
//	 */
//	public int emailDupCheck(String inputEmail, String selectEmail) {
//		return sqlSession.selectList("memberMapper.emailDupCheck", inputEmail,selectEmail);
//	}
//	
	
	
	
	//	/** 임의의 authkey
//	 * @param member
//	 * @return 
//	 */
//	public int updateAuthkey(Member member) {
//		return sqlSession.update("member-mapper.updateAuthkey", member);
//	}
//
//	/** 이메일 인증 상태코드 변경
//	 * @param member
//	 */
//	public int updateAuthstatus(Member member) {
//		return sqlSession.update("member-mapper.updateAuthstatus", member);
//	}

}
