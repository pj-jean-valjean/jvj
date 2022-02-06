package edu.kh.jvj.cart.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.jvj.cart.model.dao.CartDAO;
import edu.kh.jvj.cart.model.vo.Cart;
import edu.kh.jvj.member.model.vo.Member;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartDAO dao;

	@Override
	@Transactional
	public int addCart(Cart cart) {
		
		return dao.addCart(cart);
	}

	@Override
	@Transactional
	public int addSub(Cart cart2) {
		
		return dao.addSub(cart2);
	}

	@Override
	public List<Cart> selectCartList(Member member) {
		// TODO Auto-generated method stub
		return dao.selectCartList(member);
	}

	@Override
	public List<Cart> selectOptionList(Member member) {
		
		return dao.selectOptionList(member);
	}

	@Override
	public int deleteCart(Cart cart) {
		// TODO Auto-generated method stub
		return dao.deleteCart(cart);
	}

	

}
