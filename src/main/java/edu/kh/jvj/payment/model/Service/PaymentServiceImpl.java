package edu.kh.jvj.payment.model.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.jvj.onedayclass.model.vo.OnedayClass;
import edu.kh.jvj.payment.model.dao.PaymentDAO;

@Service
public class PaymentServiceImpl implements PaymentService{

	@Autowired
	private PaymentDAO dao;
	
	@Override
	public OnedayClass getClassSelect(String productNo) {
		return dao.getClassSelect(productNo);
	}

}
