package edu.kh.jvj.notice.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.jvj.notice.model.vo.Notice;
import edu.kh.jvj.store.model.vo.Pagination;

@Repository
public class NoticeDAO {

	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public int countNotice() {
		return sqlSession.selectOne("adminMapper.countNotice");
	}
	public List<Notice> selectStoreList(Pagination page, int cate) {
		
		
		//offset : 몇행을 건너 뛸것인지
		//limit 건너뛴 위치부터 몇행을 조회할지
		int limit = page.getLimit();
		int offset = (page.getCurrentPage()-1)*limit;
		RowBounds rowBounds = new RowBounds(offset,limit);
		
		return sqlSession.selectList("adminMapper.noticeList",cate,rowBounds);
	}
	public Notice selectOneNotice(int noticeNo) {
		return sqlSession.selectOne("adminMapper.oneNotice",noticeNo);
	}
	
}
