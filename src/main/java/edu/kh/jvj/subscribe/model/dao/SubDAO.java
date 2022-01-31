package edu.kh.jvj.subscribe.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SubDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
}
