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
import edu.kh.jvj.admin.model.vo.SimpleProduct;
import edu.kh.jvj.admin.model.vo.SubsInfo;
import edu.kh.jvj.admin.model.vo.SubsOptions;
import edu.kh.jvj.store.model.vo.Pagination;
import edu.kh.jvj.store.model.vo.Store;

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
	public List<SearchedMember> searchMember(Map<String, String> dataMap, Pagination page) {
		
		int limit =page.getLimit();
		int offset = (page.getCurrentPage() -1 )* limit;
		RowBounds rowBounds = new RowBounds(offset, limit); 
		
		return sqlSession.selectList("adminMapper.searchMember",dataMap,rowBounds);
	}

	/** 추가옵션상품
	 * @param map
	 * @return
	 */
	public int insertOptionP(Map<String, String> map) {
		return sqlSession.insert("adminMapper.insertOptionP",map);
	}

	/** 검색해당 멤버 전체 수 조회
	 * @param dataMap
	 * @return
	 */
	public int countMember(Map<String, String> dataMap) {
		return sqlSession.selectOne("adminMapper.countMember",dataMap);
	}

	/** 공지사항 update
	 * @param noticeMap
	 * @return
	 */
	public int updateNotice(Map<String, String> noticeMap) {
		return sqlSession.update("adminMapper.updateNotice",noticeMap);
	}

	/**검색해당 상품 전체 수 조회
	 * @param dataMap
	 * @return
	 */
	public int countProduct(Map<String, String> dataMap) {
		return sqlSession.selectOne("adminMapper.countProduct",dataMap);
	}

	public List<SimpleProduct> productselect(Map<String, String> dataMap, Pagination page) {
		int limit =page.getLimit();
		int offset = (page.getCurrentPage() -1 )* limit;
		RowBounds rowBounds = new RowBounds(offset, limit); 
		
		return sqlSession.selectList("adminMapper.productselect",dataMap,rowBounds);
	}

	public Store getStoreInfo(int productNo) {
		return sqlSession.selectOne("adminMapper.getStoreInfo",productNo);
	}

	public int updateProductCommon(ProductWrite product) {
		return sqlSession.update("adminMapper.updateProductCommon",product);
	}

	public int updateStoreProduct(ProductWrite product) {
		return sqlSession.update("adminMapper.updateStoreProduct",product);
	}

	public int updateStoreDiscount(ProductWrite product) {
		return sqlSession.update("adminMapper.updateStoreDiscount",product);
	}

	public int deleteImgs(Map<String, String> map) {
		return sqlSession.delete("adminMapper.deleteImgs",map);
	}

	public int updateClassProduct(ProductWrite product) {
		return sqlSession.update("adminMapper.updateClassProduct",product);
	}

	public int checkIsDiscount(ProductWrite product) {
		return sqlSession.selectOne("adminMapper.checkIsDiscount",product);
	}

	public int deleteStoreDiscount(ProductWrite product) {
		return sqlSession.delete("adminMapper.deleteStoreDiscount",product);
	}

	public SubsInfo getSubsInfo(Map<String, Integer> dataMap) {
		return sqlSession.selectOne("adminMapper.getSubsInfo",dataMap);
	}

	public List<SubsOptions> selectSubsOption(int productNo) {
		return sqlSession.selectList("adminMapper.selectSubsOption",productNo);
	}

	public int addSubsOption(SubsOptions subsOption) {
		return sqlSession.insert("adminMapper.addSubsOption", subsOption);
	}

	public int deleteSubsOption(int suboptionNo) {
		return sqlSession.delete("adminMapper.deleteSubsOption", suboptionNo);
	}

	public int changeSubsOption(SubsOptions subsOptions) {
		return sqlSession.delete("adminMapper.changeSubsOption", subsOptions);
	}

	public List<String> selectImgList() {
		return sqlSession.selectList("adminMapper.selectImgList");
	}
	
}
