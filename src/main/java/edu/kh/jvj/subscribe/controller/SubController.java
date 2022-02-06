package edu.kh.jvj.subscribe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.kh.jvj.subscribe.model.service.SubService;


@Controller
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
	
	
	
	

}
