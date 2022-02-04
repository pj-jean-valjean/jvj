package edu.kh.jvj.admin.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.jvj.admin.model.vo.Admin;
import edu.kh.jvj.admin.model.vo.ProductImage;
import edu.kh.jvj.admin.model.vo.ProductWrite;
import edu.kh.jvj.admin.model.vo.SearchedMember;

@Repository
public class AdminDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	/** 상품 공통
	 * @param product
	 * @return
	 */
	public int insertProductCommon(ProductWrite product) {
		return sqlSession.insert("adminMapper.insertProductCommon",product);
	}

	/** 클래스 상세 
	 * @param product
	 * @return
	 */
	public int insertClassProduct(ProductWrite product) {
		return sqlSession.insert("adminMapper.insertClassProduct",product);
	}

	/** 상품 이미지
	 * @param imgList
	 * @return
	 */
	public int insertImgList(List<ProductImage> imgList) {
		return sqlSession.insert("adminMapper.insertProductImg",imgList);
	}

	/** 공지사항
	 * @param noticeMap
	 * @return
	 */
	public int insertNotice(Map<String, String> noticeMap) {
		return sqlSession.insert("adminMapper.insertNotice",noticeMap);
	}

	/** 스토어 삽입
	 * @param product
	 * @return
	 */
	public int insertStoreProduct(ProductWrite product) {
		return sqlSession.insert("adminMapper.insertStoreProduct",product);
	}
	
	/** 할인정보 삽입
	 * @param product
	 * @return
	 */
	public int insertStoreDiscount(ProductWrite product) {
		return sqlSession.insert("adminMapper.insertStoreDiscount",product);
	}

	/** 로그인정보 일치 여부
	 * @param admin
	 * @return
	 */
	public Admin findMatchAdmin(Admin admin) {
		return sqlSession.selectOne("adminMapper.findMatchAdmin",admin);
	}

	/** 회원정보 조회
	 * @param dataMap
	 * @return
	 */
	public List<SearchedMember> searchMember(Map<String, String> dataMap) {
		
		int limit =15;
		int offset = (Integer.parseInt(dataMap.get("page")) -1 )* limit;
		RowBounds rowBounds = new RowBounds(offset, limit); 
		
		return sqlSession.selectList("adminMapper.searchMember",dataMap,rowBounds);
	}

	public int insertOptionP(Map<String, String> map) {
		return sqlSession.insert("adminMapper.insertOptionP",map);
	}
	
	

	
}
