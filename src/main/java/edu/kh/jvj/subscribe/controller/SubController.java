package edu.kh.jvj.subscribe.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.kh.jvj.subscribe.model.service.SubService;
import edu.kh.jvj.subscribe.model.vo.ProductImage;
import edu.kh.jvj.subscribe.model.vo.SubVO;


@Controller
@SessionAttributes({"loginMember"}) 
@RequestMapping("/subscribe/*")
public class SubController {
	
	private Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private SubService service;
	
	// 구독 메인 
	@GetMapping("subMain")
	public String subMain() {
		return "/subscribe/subMain";
	}

//	// 빵 상세페이지
//	@GetMapping("subBread")
//	public String subBread() {
//		return "/subscribe/subBread";
//	}
//	
	// 빵, 커피 상세페이지
	@GetMapping("subCoffee")
	public String subCoffee() {
		return "/subscribe/subCoffee";
	}
	
	
	
	// 빵 상세 조회
	@GetMapping("subBread")
	public String subBread(SubVO subVO, Model model) {
		long startMs = System.currentTimeMillis(); // 서비스 시작 시의 ms 값
		Map<String , Integer> map = new HashMap<>();
		
		map.put("productNo", 1437);
		
		List<SubVO> subVOList = service.selectSubBread(map);
		List<ProductImage> subVOImgList = service.selectProductImageList(map);
		
		long endMs = System.currentTimeMillis(); // 서비스 종료 시의 ms 값
		long takeTime = (endMs - startMs);
		
		
		if(subVOList != null) {
			model.addAttribute("subVOList", subVOList);
			model.addAttribute("subVOImgList", subVOImgList);
		} else {
			
		}
		
		log.info("빵 상세 조회 로딩 소요시간 : {} ms", takeTime);
		
		return "subscribe/subBread";
	}
	
	
	

}
