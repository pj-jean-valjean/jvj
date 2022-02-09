package edu.kh.jvj.payment.model.Service;

import java.util.List;

import edu.kh.jvj.onedayclass.model.vo.OnedayClass;

public interface PaymentService {

	
	
	/** 클래스 정보 가져오기
	 * @param productNo
	 * @return
	 */
	OnedayClass getClassSelect(String productNo);

}
