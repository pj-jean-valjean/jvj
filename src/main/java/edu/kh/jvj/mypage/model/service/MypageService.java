package edu.kh.jvj.mypage.model.service;

import java.util.List;

import edu.kh.jvj.mypage.model.vo.Coupon;
import edu.kh.jvj.mypage.model.vo.Pagination;

public interface MypageService {

	/** coupon page pagination
	 * @param cp
	 * @return
	 */
	Pagination couponPagination(int cp);

	List<Coupon> couponList(Pagination pagination);
	


	
	
	
}