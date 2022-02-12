package edu.kh.jvj.mypage.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.jvj.member.model.vo.Member;
import edu.kh.jvj.mypage.model.vo.Coupon;
import edu.kh.jvj.mypage.model.vo.CouponStatus;
import edu.kh.jvj.mypage.model.vo.Like;
import edu.kh.jvj.mypage.model.vo.Pagination;
import edu.kh.jvj.mypage.model.vo.Pagination2;

@Repository
public class MypageDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	
	/** 쿠폰 페이지 전체 쿠폰 수
	 * @param search 
	 * @param member 
	 * @param coupon 
	 * @return
	 */
	public int getCouponCount() {
		return sqlSession.selectOne("mypageMapper.getCouponCount");
	}


	/** 페이지에 보여지는 쿠폰 수 지정
	 * @param pagination
	 * @param search 
	 * @return
	 */
	public List<Coupon> getCouponList(Pagination pagination, Coupon coupon) {
		
		int offset = (pagination.getCurrentPage() - 1)* pagination.getLimit();
		int limit = pagination.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return sqlSession.selectList("mypageMapper.selectCouponList", coupon , rowBounds);
	}


	/** 쿠폰 카테고리
	 * @return
	 */
	public List<CouponStatus> statusCategory() {
		return sqlSession.selectList("mypageMapper.statusCategory");
	}


	/** 좋아요 전체 목록 조회
	 * @return
	 */
	public int getLikeCount() {
		return sqlSession.selectOne("mypageMapper.getLikeCount");
	}


	/** 좋아요 상세 목록 조회
	 * @param pagination2
	 * @param like
	 * @return
	 */
	public List<Like> getLikeList(Pagination2 paginationLike, Like like) {
		int offset = (paginationLike.getCurrentPage() - 1)* paginationLike.getLimit();
		int limit = paginationLike.getLimit();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return sqlSession.selectList("mypageMapper.getLikeList", like , rowBounds);
	}


	/** 좋아요 취소
	 * @param map
	 * @return
	 */
	public int cancleLike(Like like) {
		return sqlSession.delete("mypageMapper.cancleLike",like);
	}


	/** 회원 정보 수정
	 * @param member
	 * @return
	 */
	public int memberUpdate(Member member) {
		return sqlSession.update("mypageMapper.memberUpdate", member);
	}



	/** 암호화된 비밀번호 조회
	 * @param map
	 * @return
	 */
	public String selectDecodePw(String memberNo) {
		return sqlSession.selectOne("mypageMapper.selectDecodePw", memberNo);
		
	}


	/** 현재 비밀번호와 일치시 다시 암호화 후 DB에 저장
	 * @param map
	 * @return
	 */
	public int modifyPassword(Map<String, String> map) {
		return sqlSession.update("mypageMapper.modifyPassword", map);
	}


	/** 일반회원 탈퇴
	 * @param memberNo
	 * @return result
	 */
	public int secession(int memberNo) {
		return sqlSession.update("mypageMapper.secession", memberNo);
	}






	

	






	

	
	
}
