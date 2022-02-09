package edu.kh.jvj.subscribe.model.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.jvj.subscribe.model.vo.SubVO;

@Repository
public class SubDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	/** 빵 상세 페이지
	 * @param map
	 * @return SubVO
	 */
	public SubVO selectSubBread(Map<String, Integer> map) {
		return sqlSession.selectOne("subscribeMapper.selectSubBread", map);
	}
}
