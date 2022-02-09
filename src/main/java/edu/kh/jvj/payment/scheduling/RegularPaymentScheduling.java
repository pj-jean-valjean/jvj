package edu.kh.jvj.payment.scheduling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import edu.kh.jvj.payment.model.Service.PaymentService;

@Component
public class RegularPaymentScheduling {
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private PaymentService service;
	
	// @Scheduled(fixedDelay = 1000)
	public void regularPayment() {
		logger.info("[scheduling] 실행!");
	}
}
