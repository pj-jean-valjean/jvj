package edu.kh.jvj.cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
@SessionAttributes({ "loginMember" })
@RequestMapping("/cart")
public class CartController {
	@Autowired
	private CartService service;

	@GetMapping("")
	public String cartForward(@ModelAttribute("loginMember") Member member,Cart cart,Model model) {
		
		List<Cart> cartList= service.selectCartList(member);
		System.out.println(cartList);
		List<Cart> optionList = service.selectOptionList(member);
		model.addAttribute("cartList",cartList);
		
		return "member/cart";
	}

	@PostMapping("addCart")
	@ResponseBody
	public int addCart(int storeNo, int addq, String arrays, String adStock, String adPrice,
			@ModelAttribute("loginMember") Member member, Cart cart) {
		int memberNo = member.getMemberNo(); // 회원번호
		String arrayQ[] = arrays.split(","); // 추가상품 갯수
//		String arrStock[] = adStock.split(","); // 재고
//		String arrPrice[] = adPrice.split(",");// 추가상품 가격

		// 상품 세팅
		cart.setProductNo(storeNo); // 상품번호
		cart.setAddq(addq); // 상품 수량
		cart.setMemberNo(memberNo);
		// 상품 추가
		int addMainResultNo = service.addCart(cart);

		if (addMainResultNo > 0) { // 상품 추가됐을때 추가옵션 추가
			for (int i = 0; i < arrayQ.length; i++) {
				if (Integer.parseInt(arrayQ[i]) == 0) { // 수량 0일시 건너뛰기
					continue;
				}
				Cart cart2 = new Cart();
				cart2.setOptq(Integer.parseInt(arrayQ[i])); // 옵션 수량
				cart2.setCartNo(cart.getCartNo()); // 카트번호
				cart2.setOpt(cart2.getOptSetNum()[i]); // 옵션번호
				cart2.setMemberNo(memberNo); // 회원번호

				int addSub = service.addSub(cart2);
				if (addSub > 0) {
					System.out.println((i + 1) + "번째 옵션 성공");

				} else {
					System.out.println((i + 1) + "번째 옵션 실패");

				}
			}

		}

		return addMainResultNo;
	}

}
