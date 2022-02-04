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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;

import edu.kh.jvj.admin.model.service.AdminService;
import edu.kh.jvj.admin.model.vo.Admin;
import edu.kh.jvj.admin.model.vo.ProductWrite;
import edu.kh.jvj.admin.model.vo.SearchedMember;

@RequestMapping("admin/board/*")
@RestController
@SessionAttributes({"Admin"})
public class AdminBoardController {
	private final AdminService service;
	@Autowired
	public AdminBoardController(AdminService service) {
		this.service = service;
	}
	//썸머노트 이미지처리 ajax
	@PostMapping("summernoteImage")
	//썸머노트 이미지 처리
	public String insertFormData2(
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
	
	//관리자 글작성 ajax
	@PostMapping("productWrite")
	public int productWrite(
			@RequestParam(value="images", required=false) List<MultipartFile> images,
			ProductWrite Product, HttpSession session
			) {
		
		String WebPath = "/resources/images/thumbimgs/"; //DB에 저장되는 경로
		String serverPath = session.getServletContext().getRealPath(WebPath);
		int result = service.insertProduct(images, Product, WebPath , serverPath); 
		
		if(result>0) {
			result = Product.getProductNo();
		}
		return result;
	}
	
	//공지사항 작성 ajax
	@PostMapping("noticeWrite")
	public int noticeWrite(String title,	String noticecate,
			String editordata, @ModelAttribute(value="Admin") Admin loginAdmin,
			Model model
			) {
		int result =0;
		result = service.insertNotice(title, noticecate, editordata, loginAdmin.getMemberNo());
		return result;
	}
	
	//회원정보 조회
	@PostMapping("searchMember")
	public ResponseEntity<List<SearchedMember>> searchMember(
			@RequestBody Map<String,String> dataMap
			){
		
		List<SearchedMember> dd = service.searchMember(dataMap);
		return new ResponseEntity<>(dd , HttpStatus.OK); 
	}
	//추가옵션상품 등록
	@PostMapping("addOptionProduct")
	public int addOptionProduct(String title,	String price , String writecate
			) {
		Map<String , String > map = new HashMap<>();
		map.put("title", title);
		map.put("price", price);
		map.put("writecate", writecate);
		int result =0;
		result = service.insertOptionP(map);
		return result;
	}
	
}
