package edu.kh.jvj.cart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping("/cart")
public class CartController {
	@GetMapping("")
	public String cartForward() {
		return "member/cart";
	}
	
	@PostMapping("addCart")
	@ResponseBody
	public int addCart(int addq,String adStock) {
		System.out.println(""+addq);
		System.out.println(adStock);
		
		return 0;
	}
}
