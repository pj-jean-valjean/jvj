package edu.kh.jvj.payment.model.Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.jvj.onedayclass.model.vo.OnedayClass;
import edu.kh.jvj.payment.model.dao.PaymentDAO;
import edu.kh.jvj.payment.model.vo.KaKaoPayKey;
import edu.kh.jvj.payment.model.vo.OrderSubsOption;
import edu.kh.jvj.payment.model.vo.Payment;
import edu.kh.jvj.payment.model.vo.RegualrPayInfo;
import edu.kh.jvj.payment.model.vo.RegularPaySuccessSave;
import edu.kh.jvj.payment.model.vo.SubsOrder;

@Service
public class PaymentServiceImpl implements PaymentService{

	@Autowired
	private PaymentDAO dao;
	
	@Override
	public OnedayClass getClassSelect(String productNo) {
		return dao.getClassSelect(productNo);
	}
	
	//결제 정보 저장
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int insertPaymentInfo(Payment payInfo) {
		
		int result = 0;
		
		//구독상품 주문정보
		if(payInfo.getProductCd() == 3) {
			result = dao.insertPaymentInfo(payInfo);
			
			//상세 정보 저장
			result = dao.insertOrderListInfo(payInfo);
				
			//상품의 욥션 정보 저장
			result = dao.insertOrderOptionInfo(payInfo);
				
			//API 결제 키 저장
			result = dao.insertAPIorderKey(payInfo);
				
		}
		return result;
	}

	@Override
	public List<OrderSubsOption> getOptionsList(String getOptionSearch) {
		return dao.getOptionsList(getOptionSearch);
	}

	@Override
	public int getPerchaseSeq() {
		return dao.getPerchaseSeq();
	}

	@Override
	public KaKaoPayKey getKaKaoTid(String partner_order_id) {
		return dao.getKaKaoTid(partner_order_id);
	}
	
	//주문정보 일시저장
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int saveRegularPayKey(RegualrPayInfo rpi) {
		return  dao.saveRegularPayKey(rpi);
	}
	//주문성공
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int saveRegularSuccess(RegularPaySuccessSave saveRegularSuccess) {
		
		//sid저장하고
		int result = dao.saveRegularSuccess(saveRegularSuccess);
		//구매내역 넣고
		
			//1. 상품번호 , 합계금액, 회원번호 가져오기
		Payment searchpay = dao.selectPayInfo(saveRegularSuccess.getPartner_order_id());
		//상세 정보 저장
		searchpay.setPurchaseNo(saveRegularSuccess.getPartner_order_id());
		searchpay.setAmount(Integer.parseInt(saveRegularSuccess.getQuantity()));
		result = dao.insertOrderListInfo(searchpay);
		//옵션명 저장
		//상품의 욥션 정보 저장
		searchpay.setProductOption(saveRegularSuccess.getItem_name());
		result = dao.insertOrderOptionInfo(searchpay);
		
		return result;
	}

	@Override
	public List<RegualrPayInfo> getRegularPayList() {
		return dao.getRegularPayList();
	}
	



}
