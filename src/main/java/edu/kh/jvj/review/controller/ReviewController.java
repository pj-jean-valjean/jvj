package edu.kh.jvj.review.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("board/review/*")
public class ReviewController {
	
	@GetMapping("write")
	public String WriteReview() {
		
		return "review/reviewWrite";
	}
}
