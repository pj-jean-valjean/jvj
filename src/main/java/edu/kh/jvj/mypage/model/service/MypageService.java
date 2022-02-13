package edu.kh.jvj.mypage.model.service;

import java.util.List;
import java.util.Map;

import edu.kh.jvj.member.model.vo.Member;
import edu.kh.jvj.mypage.model.vo.Coupon;
import edu.kh.jvj.mypage.model.vo.CouponStatus;
import edu.kh.jvj.mypage.model.vo.Like;
import edu.kh.jvj.mypage.model.vo.Pagination;
import edu.kh.jvj.mypage.model.vo.Pagination2;
import edu.kh.jvj.mypage.model.vo.Order;

public interface MypageService {

	/** 쿠폰 페이지네이션
	 * @param cp
	 * @param search 
	 * @param serch 
	 * @return
	 */
	Pagination couponPagination(int cp);

	/** 쿠폰 목록조회
	 * @param pagination
	 * @param coupon
	 * @return
	 */
	List<Coupon> couponList(Pagination pagination, Coupon coupon);

	/** 쿠폰 카테고리
	 * @return
	 */
	List<CouponStatus> statusCategory();

	/** 좋아요 페이지네이션
	 * @param cp
	 * @return
	 */
	Pagination2 getLikePagination(int cp);

	/** 좋아요 목록 조회
	 * @param pagination2
	 * @param like
	 * @return
	 */
	List<Like> getLikeList(Pagination2 paginationLike, Like like);

	/** 좋아요 취소
	 * @param map
	 * @return
	 */
	int cancleLike(Like like);

	/** 회원 정보 수정
	 * @param member
	 * @return
	 */
	int memberUpdate(Member member);

	/** 비밀번호 수정
	 * @param map
	 * @return
	 */
	int updatePw(Map<String, String> map);

	/** 회원 탈퇴
	 * @param memberNo
	 * @return
	 */
	int secession(int memberNo);

	List<Order> selectPurList(Order order);
	
	




	


	
	
	
}