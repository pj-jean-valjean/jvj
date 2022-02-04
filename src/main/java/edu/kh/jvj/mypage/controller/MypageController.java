package edu.kh.jvj.mypage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.kh.jvj.mypage.model.service.MypageService;
import edu.kh.jvj.mypage.model.vo.Coupon;
import edu.kh.jvj.mypage.model.vo.Pagination;

@Controller
@RequestMapping("mypage/*")
public class MypageController {
	
	@Autowired
	private MypageService service;
	
	@GetMapping("main")
	public String mypageMain() {
		
		return "mypages/mypageMain";
	}
	
	@GetMapping("info")
	public String mypageInfo() {
		return "mypages/mypageInfo";
	}
	
	@GetMapping("love")
	public String mypageLove() {
		return "mypages/mypageLove";
	}
	
	@GetMapping("purchase")
	public String mypageShopping() {
		return "mypages/mypageShopping";
	}
	
	@GetMapping("class")
	public String mypageClass() {
		return "mypages/mypageClass";
	}
	@GetMapping("sub")
	public String mypageSub() {
		return "mypages/mypageSub";
	}
	@GetMapping("review")
	public String mypageReview() {
		return "mypages/mypageReview";
	}
	
	@GetMapping("recorrect")
	public String ReviewWrite() {
		return "mypages/reviewWrite";
	}
	
	@GetMapping("coupon")
	public String mypageCoupon( @RequestParam(value="cp", required=false, defaultValue="1") int cp, Model model ) {
		
		Pagination pagination = null;
		List<Coupon> couponBook = null;
		
		pagination = service.couponPagination(cp);
		
		couponBook = service.couponList(pagination);
		
		model.addAttribute("coupon", couponBook);
		model.addAttribute("pagination",pagination);
		
		return "mypages/mypageCoupon";
	}
	
}
