package edu.kh.jvj.mypage.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.jvj.mypage.model.vo.Coupon;
import edu.kh.jvj.mypage.model.vo.Pagination;

@Repository
public class MypageDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	
	/** 쿠폰 페이지 전체 쿠폰 수
	 * @return
	 */
	public int getCouponCount() {
		return sqlSession.selectOne("mypageMapper.getCouponCount");
	}


	/** 페이지에 보여지는 쿠폰 수 지정
	 * @param pagination
	 * @return
	 */
	public List<Coupon> getCouponList(Pagination pagination) {
		
		int offset = (pagination.getCurrentPage() - 1)* pagination.getLimit();
		int limit = pagination.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return sqlSession.selectList("mypageMapper.selectCouponList", null , rowBounds);
	}

	
	
}
