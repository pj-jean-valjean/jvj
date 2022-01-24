package edu.kh.jvj.admin.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;

import edu.kh.jvj.admin.model.service.AdminService;
import edu.kh.jvj.admin.model.vo.ProductWrite;


@Controller
@RequestMapping("admin/board/*")
public class AdminBoardController {
	
	private final AdminService service;
	@Autowired
	public AdminBoardController(AdminService service) {
		this.service = service;
	}
	
	//로그인시 관리자페이지 메인
	@PostMapping("main")
	public String AdmingLoginProcess(
			String adminId, String adminPw,
			RedirectAttributes ra, Model model
			) {
		String path = "";
		if(adminId.equals("admin")&&adminPw.equals("admin1234")) {
			path =  "admin/adminMain";
		}
		else{
			path = "redirect:/admin/login";
			ra.addFlashAttribute("message", "아이디 비밀번호를 확인해주세요!");
		}
		return path;
	}
	
	//썸머노트 이미지처리 ajax
	@PostMapping("summernoteImage")
	//썸머노트 이미지 처리
	public @ResponseBody String insertFormData2(
			@RequestParam(value="file", required=false) MultipartFile file,HttpSession session
			) {
		Gson gson = new Gson();
		Map<String, String> map = new HashMap<String, String>();
		// 2) 웹 접근 경로(webPath) , 서버 저장 경로 (serverPath)
		String WebPath = "/resources/images/summernoteImages/"; //DB에 저장되는 경로
		String serverPath = session.getServletContext().getRealPath(WebPath);
		String originalFileName=file.getOriginalFilename();
		String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
		String savedFileName = UUID.randomUUID() + extension;	//저장될 파일 명
		File targetFile = new File(serverPath + savedFileName);	
		try {
			InputStream fileStream = file.getInputStream();
			FileUtils.copyInputStreamToFile(fileStream, targetFile);	//파일 저장
			// contextroot + resources + 저장할 내부 폴더명
			map.put("url", WebPath+savedFileName);
			map.put("responseCode", "success");
		} catch (IOException e) {
			FileUtils.deleteQuietly(targetFile);	//저장된 파일 삭제
			map.put("responseCode", "error");
			e.printStackTrace();
		}
		return gson.toJson(map);
	}
	
	//관리자 글작성 
	@PostMapping("productWrite")
	public String productWrite(
			@RequestParam(value="images", required=false) List<MultipartFile> images,
			ProductWrite Product, HttpSession session
			) {
		String WebPath = "/resources/images/summernoteImages/"; //DB에 저장되는 경로
		String serverPath = session.getServletContext().getRealPath(WebPath);
		
		int result = service.insertProduct(images, Product, WebPath , serverPath);
		
		
		return "";
	}
	
}
