package edu.kh.jvj.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/store")
public class StoreController {
	@GetMapping("")
	public String storeForward() {
		return "store/storeEx";
	}
}
