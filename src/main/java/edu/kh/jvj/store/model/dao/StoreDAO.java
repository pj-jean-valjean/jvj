package edu.kh.jvj.store.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.jvj.store.model.vo.Pagination;
import edu.kh.jvj.store.model.vo.Store;

@Repository
public class StoreDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public List<Store> selectStoreList(Pagination pagination) {
		
		//offset : 몇행을 건너 뛸것인지
		//limit 건너뛴 위치부터 몇행을 조회할지
		int offset = (pagination.getCurrentPage()-1)*pagination.getLimit();
		int limit = pagination.getLimit();
		RowBounds rowBounds = new RowBounds(offset,limit);
		
		
		return mybatis.selectList("storeMapper.selectStoreList",null,rowBounds);
	}
	
	
	
	public int getListCount() {
		
		return mybatis.selectOne("storeMapper.getListCount");
	}

}
