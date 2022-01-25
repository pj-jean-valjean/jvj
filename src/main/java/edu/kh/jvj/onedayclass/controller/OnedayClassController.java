package edu.kh.jvj.onedayclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("onedayclass/*")
public class OnedayClassController {
	@GetMapping("list")
	public String showOnedayClassList() {
		return "/onedayclass/onedayClassList";
	}
}
