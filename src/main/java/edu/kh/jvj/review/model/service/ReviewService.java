package edu.kh.jvj.review.model.service;

import java.util.List;

import edu.kh.jvj.review.model.vo.Review;

public interface ReviewService {

	List<Review> selectOrder(int memberNo);

}
