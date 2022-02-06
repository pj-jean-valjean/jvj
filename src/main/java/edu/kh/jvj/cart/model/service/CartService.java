package edu.kh.jvj.cart.model.service;

import java.util.List;

import edu.kh.jvj.cart.model.vo.Cart;
import edu.kh.jvj.member.model.vo.Member;

public interface CartService {

	int addCart(Cart cart);

	int addSub(Cart cart2);

	List<Cart> selectCartList(Member member);

	List<Cart> selectOptionList(Member member);

	int deleteCart(Cart cart);


}
