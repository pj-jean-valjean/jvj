package edu.kh.jvj.mypage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("mypage/*")
public class MypageController {
	
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
	@GetMapping("coupon")
	public String mypageCoupon() {
		return "mypages/mypageCoupon";
	}
	
}
