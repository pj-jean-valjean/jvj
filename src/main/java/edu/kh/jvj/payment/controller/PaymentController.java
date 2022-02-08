package edu.kh.jvj.payment.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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
	
	@Autowired
	private PaymentService service;
	
	@RequestMapping(value = "payment", method = RequestMethod.POST)
	public String payment(HttpSession session, Model model, String carrierList) {
		
		System.out.println("결제화면" + carrierList);
		
//		List<Store> storeList = service.getStoreList(carrierList);
		
//		model.addAttribute("storeList", storeList);
		return "payment/payment";
	}
	
	@RequestMapping(value = "payment", method = RequestMethod.GET)
	public String classPayment(HttpSession session, Model model, String totalPrice, String totalPeople, String productNo) {
		
		System.out.println("결제화면" + productNo);
		
		OnedayClass oneClass = service.getClassSelect(productNo);
		
		System.out.println(totalPrice);
		System.out.println(totalPeople);
		
		
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
