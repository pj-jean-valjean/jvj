package edu.kh.jvj.payment.model.Service;

import java.util.List;

import edu.kh.jvj.onedayclass.model.vo.OnedayClass;
import edu.kh.jvj.payment.model.vo.Payment;

public interface PaymentService {

	
	
	/** 클래스 정보 가져오기
	 * @param productNo
	 * @return
	 */
	OnedayClass getClassSelect(String productNo);
	
	/**결제 정보 저장
	 * @param payInfo
	 * @return
	 */
	int insertPaymentInfo(Payment payInfo);

}
