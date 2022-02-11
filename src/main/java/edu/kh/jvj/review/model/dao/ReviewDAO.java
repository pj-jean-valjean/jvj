package edu.kh.jvj.review.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.kh.jvj.review.model.vo.Review;

@Component
public class ReviewDAO {
	
	@Autowired
	private SqlSession mybatis;

	public List<Review> selectOrder(int memberNo) {
		
		return mybatis.selectList("reviewMapper",memberNo);
	}
	
}
