package edu.kh.jvj.notice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {
	@GetMapping("list")
	public String noticeListShow() {
		return "/notice/noticeList";
	}
}
