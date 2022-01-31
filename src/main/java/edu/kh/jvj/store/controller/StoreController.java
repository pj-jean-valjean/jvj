package edu.kh.jvj.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.kh.jvj.store.model.service.StoreService;
import edu.kh.jvj.store.model.vo.Pagination;
import edu.kh.jvj.store.model.vo.Store;



@Controller
@RequestMapping("/store")
public class StoreController {
	
	@Autowired
	private StoreService service;
	@GetMapping("")
	public String storeForward(@RequestParam(value="cp",required=false,defaultValue ="1")
	int cp, Model model){
		
		Pagination pagination = service.getPagination(cp);
		List<Store> storeList = service.selectStoreList(pagination);
		return "store/storeEx";
	}
	@GetMapping("info")
	public String detailForward() {
		return "store/storeDetail";
	}
}
