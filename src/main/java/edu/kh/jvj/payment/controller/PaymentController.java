package edu.kh.jvj.payment.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.kh.jvj.member.model.vo.Member;

@Controller
@RequestMapping("/payment/*")
public class PaymentController {
	
	@RequestMapping(value = "payment", method = RequestMethod.POST)
	public String payment(HttpSession session, String price) {
		
		System.out.println(price);
		return "payment/payment";
	}
	
	@RequestMapping(value = "paymentResult", method = RequestMethod.GET)
	public String paymentResult() {
		return "payment/paymentResult";
	}
}
