package edu.kh.jvj.subscribe.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.kh.jvj.subscribe.model.service.SubService;
import edu.kh.jvj.subscribe.model.vo.SubVO;


@Controller
@SessionAttributes({"loginMember"}) 
@RequestMapping("/subscribe/")
public class SubController {
	
	@Autowired
	private SubService service;
	
	// 구독 메인 
	@GetMapping("subMain")
	public String subMain() {
		return "/subscribe/subMain";
	}

	// 빵 상세페이지
	@GetMapping("subBread")
	public String subBread() {
		return "/subscribe/subBread";
	}
	
	// 빵, 커피 상세페이지
	@GetMapping("subCoffee")
	public String subCoffee() {
		return "/subscribe/subCoffee";
	}
	
	// 
	@RequestMapping(value="subBread", method = RequestMethod.POST)
	public String subBread(SubVO vo, Model model) {
		
		
		return "";
	}
	
	
	

}
