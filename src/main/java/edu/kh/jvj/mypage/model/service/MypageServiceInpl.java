package edu.kh.jvj.mypage.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.kh.jvj.member.model.vo.Member;
import edu.kh.jvj.mypage.model.dao.MypageDAO;
import edu.kh.jvj.mypage.model.vo.Coupon;
import edu.kh.jvj.mypage.model.vo.CouponStatus;
import edu.kh.jvj.mypage.model.vo.Like;
import edu.kh.jvj.mypage.model.vo.Pagination;
import edu.kh.jvj.mypage.model.vo.Pagination2;

@Service
public class MypageServiceInpl implements MypageService {

	@Autowired
	private MypageDAO dao;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	
	// 마이페이지 쿠폰
	@Override
	public Pagination couponPagination(int cp) {
		
		// 전체 쿠폰 조회수 
		int listCount = dao.getCouponCount();
		return new Pagination(listCount, cp);
	}
	
	// 쿠폰 목록 조회
	@Override
	public List<Coupon> couponList(Pagination pagination, Coupon coupon) {
		return dao.getCouponList(pagination, coupon);
	}

	// 쿠폰 카테고리
	@Override
	public List<CouponStatus> statusCategory() {
		return dao.statusCategory();
	}

	// 좋아요 페이지네이션
	@Override
	public Pagination2 getLikePagination(int cp) {
		
		int count = dao.getLikeCount();
		return new Pagination2(count, cp);
	}

	// 좋아요 목록 조회
	@Override
	public List<Like> getLikeList(Pagination2 paginationLike, Like like) {
		return dao.getLikeList(paginationLike, like);
	}

	// 좋아요 취소
	@Override
	public int cancleLike(Like like) {
		return dao.cancleLike(like);
	}

	// 회원 정보 수정
	@Override
	public int memberUpdate(Member member) {
		return dao.memberUpdate(member);
	}
	
	// 회원 정보 수정(비밀번호)
	@Override
	public int updatePw(Map<String, String> map) {
		
		String decodePw = dao.selectDecodePw(map.get("memberNo"));
		
		int pwUpdate = 0;
		
		if(encoder.matches(map.get("nowPwd"), decodePw)) {
			
			String encPw = encoder.encode(map.get("modifyPwd1"));
			
			map.put("modifyPwd1", encPw);
			
			pwUpdate = dao.modifyPassword(map);
		}
		
		return pwUpdate;
	}

	
	
	

	
	
}