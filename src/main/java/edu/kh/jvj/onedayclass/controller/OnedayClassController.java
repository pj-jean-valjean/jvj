package edu.kh.jvj.onedayclass.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

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
	
	@PostMapping(value="list",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String scrollListAdd(
			@RequestBody Map<String, String> pagination  ) {
			System.out.println(pagination.get("pagination")+" / "+pagination.get("getType") + " / "+pagination.get("selectdate"));
			
		List<OnedayClass> oneLineList = service.scrollListAdd(pagination);	
		if(oneLineList.isEmpty()) {
			System.out.println("list null");
		}
		for(OnedayClass oc : oneLineList) {
			System.out.println(oc);
		}
		
		return new Gson().toJson(oneLineList);
	}
}
