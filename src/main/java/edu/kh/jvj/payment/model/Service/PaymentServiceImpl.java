package edu.kh.jvj.payment.model.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.jvj.onedayclass.model.vo.OnedayClass;
import edu.kh.jvj.payment.model.dao.PaymentDAO;
import edu.kh.jvj.payment.model.vo.Payment;

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
				
		}
		return result;
	}

}
