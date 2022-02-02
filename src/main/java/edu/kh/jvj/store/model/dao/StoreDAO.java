package edu.kh.jvj.store.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.jvj.store.model.vo.Pagination;
import edu.kh.jvj.store.model.vo.Search;
import edu.kh.jvj.store.model.vo.Store;

@Repository
public class StoreDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public List<Store> selectStoreList(Pagination pagination, Search search) {
		
		//offset : 몇행을 건너 뛸것인지
		//limit 건너뛴 위치부터 몇행을 조회할지
		int offset = (pagination.getCurrentPage()-1)*pagination.getLimit();
		int limit = pagination.getLimit();
		RowBounds rowBounds = new RowBounds(offset,limit);
		
		if(search.getCt()>0) {
			
			return mybatis.selectList("storeMapper.selectStoreList",search,rowBounds);			
		}else {
			return mybatis.selectList("storeMapper.selectStoreListAll",null,rowBounds);			
			
		}
	}
	
	
	
	public int getListCount(Search search) {
		
		return mybatis.selectOne("storeMapper.getListCount",search);
	}



	public int getListCountAll() {
		// TODO Auto-generated method stub
		return mybatis.selectOne("storeMapper.getListCountAll");
	}

}
