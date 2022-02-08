package edu.kh.jvj.payment.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.jvj.onedayclass.model.vo.OnedayClass;


@Repository
public class PaymentDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	
	
	/** 원데이 클래스 정보 가져오기
	 * @param productNo
	 * @return list
	 */
	public OnedayClass getClassSelect(String productNo) {
		return sqlSession.selectOne("paymentMapper.getClassSelect", productNo);
	}

}
