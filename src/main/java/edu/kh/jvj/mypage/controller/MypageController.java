package edu.kh.jvj.mypage.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.jvj.common.Util;
import edu.kh.jvj.member.model.vo.Member;
import edu.kh.jvj.mypage.model.service.MypageService;
import edu.kh.jvj.mypage.model.vo.Coupon;
import edu.kh.jvj.mypage.model.vo.CouponStatus;
import edu.kh.jvj.mypage.model.vo.Like;
import edu.kh.jvj.mypage.model.vo.Pagination;
import edu.kh.jvj.mypage.model.vo.Pagination2;

@Controller
@RequestMapping("mypage/*")
@SessionAttributes({"loginMember"})
public class MypageController {
	
	@Autowired
	private MypageService service;
	
	@GetMapping("main")
	public String mypageMain() {
		
		return "mypages/mypageMain";
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
	
	// 마이페이지 쿠폰
	@GetMapping("coupon")
	public String mypageCoupon( Coupon coupon,
			@RequestParam(value="cp", required=false, defaultValue="1") int cp, 
			Model model, @ModelAttribute("loginMember") Member loginMember
			) {
		
		coupon.setMemberNo(loginMember.getMemberNo());
		
		Pagination pagination = service.couponPagination(cp);
		List<Coupon> couponList = service.couponList(pagination, coupon);
			
		
		List<CouponStatus> couponStatus = service.statusCategory();
		
		model.addAttribute("pagination", pagination);
		model.addAttribute("couponList", couponList);
		model.addAttribute("couponStatus", couponStatus);
		
		return "mypages/mypageCoupon";
	}
	
	
	// 마이페이지 좋아요
	@GetMapping("love")
	public String mypageLove(@RequestParam(value="cp", required=false, defaultValue="1") int cp, 
			Model model, @ModelAttribute("loginMember") Member loginMember, 
			Like like) {
		
		like.setMemberNo(loginMember.getMemberNo());
		
		Pagination2 paginationLike = service.getLikePagination(cp);
		
		List<Like> likeList = service.getLikeList(paginationLike, like);
		
		model.addAttribute("paginationLike", paginationLike);
		model.addAttribute("likeList", likeList);
		
		return "mypages/mypageLove";
	}
	
	// 마이페이지 좋아요 취소
	@PostMapping("cancellike")
	public String cancelLike(@ModelAttribute("loginMember") Member loginMember, Like like,RedirectAttributes ra
			) {
	
		like.setMemberNo(loginMember.getMemberNo());
		
		int result = service.cancleLike(like);
		
		if( result > 0){
			Util.swalSetMessage("좋아요가 삭제되었습니다.", null, "success", ra);
			
		}else {
			Util.swalSetMessage("오류 발생, 관리자에게 문의 해주십시오.", null, "error", ra);
		}
		
		return "redirect:/";
	}

	// 내 정보 조회 화면 전환
	@RequestMapping(value = "info", method = RequestMethod.GET)
	public String mypageMove() {
		return "mypages/mypageInfo";
	}
	
	// 마이페이지 내 정보 조회
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String mypageInfo(@ModelAttribute("loginMember") Member loginMember, 
							@RequestParam Map<String, String> param, 
							Member member, RedirectAttributes ra,
							String nowPwd, String modifyPwd1) {
		
		member.setMemberNo(loginMember.getMemberNo());
		member.setMemberNickname(param.get("nickname"));
		member.setMemberAddress(param.get("updateAddress"));
		member.setMemberPhone(param.get("updatePhone"));
		
		
		int result = service.memberUpdate(member);
		
		
		 Map<String, String> map = new HashMap<String, String>(); 
		 map.put("memberNo",loginMember.getMemberNo() + ""); 
		 map.put("nowPwd", nowPwd);
		 map.put("modifyPwd1", modifyPwd1);
		  
		 int pwUpdate = service.updatePw(map);
		 
		
		if (result > 0 && pwUpdate > 0) {
			
			Util.swalSetMessage("회원 정보 수정 성공", "회원정보가 변경되었습니다", "success", ra);
			
			member.setMemberNickname(param.get("nickname"));
			loginMember.setMemberAddress(param.get("updateAddress"));
			loginMember.setMemberPhone(param.get("updatePhone"));
			
			return "redirect:info";
			
		} else {
			
			Util.swalSetMessage("회원 정보 수정 실패", "관리자에게 문의해주세요", "error", ra);
			
			return "redirect:main";
		}
		
		
		
	}
	
	
	
}
