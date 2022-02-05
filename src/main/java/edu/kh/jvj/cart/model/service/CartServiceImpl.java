package edu.kh.jvj.cart.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.jvj.cart.model.dao.CartDAO;
import edu.kh.jvj.cart.model.vo.Cart;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartDAO dao;

	@Override
	@Transactional
	public int addCart(Cart cart) {
		
		return dao.addCart(cart);
	}
}
