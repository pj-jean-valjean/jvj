package edu.kh.jvj.cart.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.jvj.cart.model.vo.Cart;

@Repository
public class CartDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;

	public int addCart(Cart cart) {
		// TODO Auto-generated method stub
		return mybatis.insert("cartMapper.addCart",cart);
	}

	public int addSub(Cart cart2) {
		
		return  mybatis.insert("cartMapper.addSub",cart2);
	}

}
