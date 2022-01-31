package edu.kh.jvj.onedayclass.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.kh.jvj.onedayclass.model.service.OnedayClassService;
import edu.kh.jvj.onedayclass.model.vo.OnedayClass;

@Controller
@RequestMapping("onedayclass/*")
public class OnedayClassController {
	
	private final OnedayClassService service;
	@Autowired
	public OnedayClassController(OnedayClassService service) {
		this.service = service;
	}
	
	@GetMapping("list")
	public String showOnedayClassList(
			Model model
			) {
		//1. 헤더 클릭 시 원데이클래스 리스트 6개 반환
		List<OnedayClass> firstList = service.selectClassList();
		if(firstList ==null) {
			model.addAttribute("message", "진행 중 클래스가 없습니다");
		}
		else {
			model.addAttribute("classList", firstList);
		}
		//
		return "/onedayclass/onedayClassList";
	}
	
	@GetMapping("view")
	public String showOnedayClassDetail() {
		return "/onedayclass/onedayClassDetail";
	}
	
	@PostMapping("list")
	@ResponseBody
	public String scrollListAdd() {
		
		
		
		
		return "";
	}
}
