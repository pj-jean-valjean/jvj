package edu.kh.jvj.cart.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.jvj.cart.model.vo.Cart;
import edu.kh.jvj.member.model.vo.Member;

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

	public List<Cart> selectCartList(Member member) {
		
		return mybatis.selectList("cartMapper.selectCartList",member);
	}

	public List<Cart> selectOptionList(Member member) {
		// TODO Auto-generated method stub
		return mybatis.selectList("cartMapper.selectOptionList",member);
	}

	public int deleteCart(Cart cart) {
		// TODO Auto-generated method stub
		return mybatis.delete("cartMapper.deleteCart",cart);
	}

	

}
