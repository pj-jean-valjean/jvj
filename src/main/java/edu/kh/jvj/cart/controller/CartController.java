package edu.kh.jvj.cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.kh.jvj.cart.model.service.CartService;
import edu.kh.jvj.cart.model.vo.Cart;
import edu.kh.jvj.member.model.vo.Member;
@Controller
@SessionAttributes({"loginMember"})
@RequestMapping("/cart")
public class CartController {
	@Autowired
	private CartService service;
	@GetMapping("")
	public String cartForward() {
		return "member/cart";
	}
	
	@PostMapping("addCart")
	@ResponseBody
	public int addCart(int storeNo,int addq,String arrays,String adStock,
		@ModelAttribute("loginMember") Member member, Cart cart) {
		
		System.out.println(storeNo);
		System.out.println(""+addq);
		System.out.println(arrays);
		System.out.println(adStock);
		
		// 상품 세팅
		cart.setMemberNo(member.getMemberNo());
		setCart(storeNo, addq, cart);
		
		int addMain = service.addCart(cart);
		
		
		
		
		return 0;
	}
	// 상품 세팅
	private void setCart(int storeNo,int addq,Cart cart) {
		cart.setProductNo(storeNo);
		cart.setAddq(addq);
	}
}
