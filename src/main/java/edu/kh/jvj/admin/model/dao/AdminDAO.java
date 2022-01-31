package edu.kh.jvj.admin.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.jvj.admin.model.vo.ProductWrite;

@Repository
public class AdminDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public int insertProductCommon(ProductWrite product) {
		return sqlSession.insert("adminMapper.insertProductCommon",product);
	}

	public int insertClassProduct(ProductWrite product) {
		return sqlSession.insert("adminMapper.insertClassProduct",product);
	}
	

	
}
