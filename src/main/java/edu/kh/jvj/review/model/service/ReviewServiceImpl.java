package edu.kh.jvj.review.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.jvj.review.model.dao.ReviewDAO;
import edu.kh.jvj.review.model.vo.Review;

@Service
public class ReviewServiceImpl implements ReviewService{
	
	@Autowired
	private ReviewDAO dao;

	@Override
	public List<Review> selectOrder(int memberNo) {
		
		return dao.selectOrder(memberNo);
	}
}
