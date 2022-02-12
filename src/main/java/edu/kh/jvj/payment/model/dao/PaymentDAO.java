package edu.kh.jvj.payment.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.jvj.onedayclass.model.vo.OnedayClass;
import edu.kh.jvj.payment.model.vo.KaKaoPayKey;
import edu.kh.jvj.payment.model.vo.OrderSubsOption;
import edu.kh.jvj.payment.model.vo.Payment;
import edu.kh.jvj.payment.model.vo.RegualrPayInfo;
import edu.kh.jvj.payment.model.vo.RegularPaySuccessSave;
import edu.kh.jvj.payment.model.vo.SubsOrder;


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



	public int insertPaymentInfo(Payment payInfo) {
		return sqlSession.insert("paymentMapper.insertPaymentInfo", payInfo);
	}



	public int insertOrderListInfo(Payment payInfo) {
		return sqlSession.insert("paymentMapper.insertOrderListInfo", payInfo);
	}



	public int insertOrderOptionInfo(Payment payInfo) {
		return sqlSession.insert("paymentMapper.insertOrderOptionInfo", payInfo);
	}



	public int insertAPIorderKey(Payment payInfo) {
		return sqlSession.insert("paymentMapper.insertAPIorderKey", payInfo);
	}



	public List<OrderSubsOption> getOptionsList(String getOptionSearch) {
		return sqlSession.selectList("paymentMapper.getOptionsList", getOptionSearch);
	}



	public int getPerchaseSeq() {
		return sqlSession.selectOne("paymentMapper.getPerchaseSeq");
	}



	public int saveRegularPayKey(RegualrPayInfo rpi) {
		sqlSession.insert("paymentMapper.saveTempOrder",rpi);
		
		return sqlSession.insert("paymentMapper.saveRegularPayKey",rpi);
	}



	public KaKaoPayKey getKaKaoTid(String partner_order_id) {
		return sqlSession.selectOne("paymentMapper.getKaKaoTid",partner_order_id);
	}



	public int saveRegularSuccess(RegularPaySuccessSave saveRegularSuccess) {
		return sqlSession.update("paymentMapper.saveRegularSuccess",saveRegularSuccess);
	}



	public Payment selectPayInfo(int partner_order_id) {
		return sqlSession.selectOne("paymentMapper.selectPayInfo",partner_order_id);
	}



	public List<RegualrPayInfo> getRegularPayList() {
		return sqlSession.selectList("paymentMapper.getRegularPayList");
	}



	public int updatePayStatement(int partner_order_id) {
		return sqlSession.update("paymentMapper.updatePayStatement",partner_order_id);
	}


}
