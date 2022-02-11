package edu.kh.jvj.payment.controller;


import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.kh.jvj.onedayclass.model.vo.OnedayClass;
import edu.kh.jvj.payment.model.Service.PaymentService;

@Controller
@RequestMapping("/payment/*")
public class PaymentController {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private PaymentService service;
	
	@RequestMapping(value = "storePayment", method = RequestMethod.POST)
	public String storePayment(HttpSession session, Model model, String carrierList) {
		
		System.out.println("결제화면" + carrierList);
		
//		List<Store> storeList = service.getStoreList(carrierList);
		
//		model.addAttribute("storeList", storeList);
		return "payment/payment";
	}
	
	@RequestMapping(value = "classPayment", method = RequestMethod.POST)
	public String classPayment(HttpSession session, Model model, String totalPrice, String totalPeople, String productNo) {
		
		OnedayClass oneClass = service.getClassSelect(productNo);
		model.addAttribute("oneClass", oneClass);
		model.addAttribute("totalPrice", totalPrice);
		model.addAttribute("totalPeople", totalPeople);
		return "payment/payment";
	}
	
	@RequestMapping(value = "subscribePayment", method = RequestMethod.POST)
	public String subscribePayment(HttpSession session, Model model, String totalPrice, String totalPeople, String productNo) {
		
		OnedayClass oneClass = service.getClassSelect(productNo);
		
		model.addAttribute("oneClass", oneClass);
		model.addAttribute("totalPrice", totalPrice);
		model.addAttribute("totalPeople", totalPeople);
		return "payment/payment";
	}
	
	@RequestMapping(value = "paymentResult", method = RequestMethod.GET)
	public String paymentResult() {
		return "payment/paymentResult";
	}
}
