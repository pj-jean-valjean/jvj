package edu.kh.jvj.mypage.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.jvj.mypage.model.dao.MypageDAO;
import edu.kh.jvj.mypage.model.vo.Coupon;
import edu.kh.jvj.mypage.model.vo.Pagination;

@Service
public class MypageServiceInpl implements MypageService {

	@Autowired
	private MypageDAO dao;

	
	// 마이페이지 쿠폰
	@Override
	public Pagination couponPagination(int cp) {
		
		// 전체 쿠폰 조회수 
		int listCount = dao.getCouponCount();
		return new Pagination(listCount, cp);
		
	}
	@Override
	public List<Coupon> couponList(Pagination pagination) {
		
		return dao.getCouponList(pagination);
	}
	
	
}
