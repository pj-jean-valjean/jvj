package edu.kh.jvj.onedayclass.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.jvj.onedayclass.model.vo.OnedayClass;

@Repository
public class OnedayClassDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	/**ClassList 1페이지 리턴
	 * @return List
	 */
	public List<OnedayClass> selsectClassList() {	
		/* return sqlSession.selectList("dsad"); */
		return null;
	}
	
	
	
}
