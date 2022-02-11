package edu.kh.jvj.review.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.kh.jvj.member.model.vo.Member;
import edu.kh.jvj.review.model.service.ReviewService;
import edu.kh.jvj.review.model.vo.Review;

@Controller
@RequestMapping("board/review/*")
@SessionAttributes({"loginMember"})
public class ReviewController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private ReviewService service;
	@GetMapping("write")
	public String WriteReview(@ModelAttribute("loginMember") Member member) {
		
		// 1.회원번호로 결제테이블을 불러온다.
		List<Review> orderList =  service.selectOrder(member.getMemberNo());		
		
		
		return "review/reviewWrite";
	}
	
	@PostMapping("writeReview")
	public String writeReview(Review review,
			@ModelAttribute("loginMember") Member member) {
		
		logger.info(review+"");

		
		return "redirect:/review/reviewWrite";
	}
}
