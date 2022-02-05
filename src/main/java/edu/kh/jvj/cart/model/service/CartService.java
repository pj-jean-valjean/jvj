package edu.kh.jvj.cart.model.service;

import edu.kh.jvj.cart.model.vo.Cart;

public interface CartService {

	int addCart(Cart cart);

	int addSub(Cart cart2);

}
