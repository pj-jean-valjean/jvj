package edu.kh.jvj.store.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.kh.jvj.member.model.vo.Member;
import edu.kh.jvj.store.model.service.StoreService;
import edu.kh.jvj.store.model.vo.Pagination;
import edu.kh.jvj.store.model.vo.Search;
import edu.kh.jvj.store.model.vo.Store;



@Controller
@SessionAttributes({"loginMember"}) 
@RequestMapping("/store")
public class StoreController {
	
	@Autowired
	private StoreService service;
	
	@GetMapping("")
	public String storeForward(@RequestParam(value="cp",required=false,defaultValue ="1")
	int cp, Model model,Search search,HttpSession session ){
		
//		
//		if(session.getAttribute("loginMember") != null) {
//			search.setMemberNo(loginMember.getMemberNo());			
//		}
//			
		Pagination pagination = service.getPagination(cp,search);
		List<Store> storeList = service.selectStoreList(pagination,search);
		
		
		model.addAttribute("store",storeList);
		model.addAttribute("pagination",pagination);
		model.addAttribute("search",search);
		return "store/storeEx";
	}
	@PostMapping("likeit")
	public String likeit(@ModelAttribute("loginMember") Member loginMember) {
		
		return null;
	}
	@GetMapping("info/{no}")
	public String detailForward(Model model,@PathVariable("no") int no) {
		
		
		Store store = service.selectStoreDetail(no); 
		List<Store> imgLevelList = service.storeImgSelect(no);
		model.addAttribute("store",store);
		System.out.println(imgLevelList);
		model.addAttribute("imgLevel", imgLevelList);
		return "store/storeDetail";
	}
}
