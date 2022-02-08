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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;

import edu.kh.jvj.admin.model.service.AdminService;
import edu.kh.jvj.admin.model.vo.Admin;
import edu.kh.jvj.admin.model.vo.ProductWrite;
import edu.kh.jvj.admin.model.vo.SearchedMember;
import edu.kh.jvj.admin.model.vo.SimpleProduct;
import edu.kh.jvj.admin.model.vo.SubsInfo;
import edu.kh.jvj.admin.model.vo.SubsOptions;
import edu.kh.jvj.notice.model.service.NoticeService;
import edu.kh.jvj.notice.model.vo.Notice;
import edu.kh.jvj.onedayclass.model.service.OnedayClassService;
import edu.kh.jvj.onedayclass.model.vo.OnedayClass;
import edu.kh.jvj.store.model.vo.Pagination;
import edu.kh.jvj.store.model.vo.Store;

@RequestMapping("admin/board/*")
@RestController
public class AdminBoardController {
	private final AdminService service;
	private final NoticeService noticeService;
	private final OnedayClassService classService;
	@Autowired
	public AdminBoardController(AdminService service, NoticeService noticeService,OnedayClassService classService) {
		this.service = service;
		this.noticeService = noticeService;
		this.classService = classService;
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
	 
	//관리자 상품관리 상품수정목록 조회 ajax
	@PostMapping("productselect")
	public Map<String,String> productselect(
			@RequestBody Map<String,String> dataMap
			) {
		//전체 페이지네이션
		Pagination page = service.countProduct(dataMap); 
		page.setLimit(15);
		page.setPageSize(10);
		List<SimpleProduct> searchedList = service.productselect(dataMap,page);
		Gson gson = new Gson(); String pageJson = gson.toJson(page); 
		String productList= gson.toJson(searchedList); 
		dataMap.put("pagination", pageJson);
		dataMap.put("productList", productList);
		
		return dataMap; 
	}
	//관리자 상품 수정 전 기존 Detail 정보 조회
	@PostMapping(value="ajaxProductDetail",produces="application/json;charset=UTF-8")
	public String productDetailInfo(
			@RequestBody Map<String, Integer> dataMap) {
		String returnJson="";
		Gson gson = new Gson();
		if(dataMap.get("productcate")==1) {
			Store store = service.getStoreInfo(dataMap.get("productNo"));
			returnJson = gson.toJson(store);
		}
		else if(dataMap.get("productcate")==3) {
			 OnedayClass Oneclass = classService.selectOneClass(dataMap); 
			 returnJson = gson.toJson(Oneclass); 
		}
		else if(dataMap.get("productcate")==2){
			SubsInfo subsInfo = service.getSubsInfo(dataMap);
			returnJson = gson.toJson(subsInfo); 
		}
		
		return returnJson;
	}
	//관리자 상품 수정
	@PostMapping("updateProduct")
	public int ProductUpdate(
			@RequestParam(value="images", required=false) List<MultipartFile> images,
			ProductWrite Product, HttpSession session) {
		String WebPath = "/resources/images/thumbimgs/"; //DB에 저장되는 경로
		String serverPath = session.getServletContext().getRealPath(WebPath);
		service.updateProduct(images, Product, WebPath , serverPath); 
		
		return Product.getProductNo();
	}
	
	//관리자 상품등록 ajax
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
			String editordata, @ModelAttribute(value="loginAdmin") Admin loginAdmin
			) {
		int result =0;
		result = service.insertNotice(title, noticecate, editordata, loginAdmin.getMemberNo());
		return result;
	}
	
	//회원정보 조회
	@PostMapping("searchMember")
	public Map<String, String> searchMember(
			@RequestBody Map<String,String> dataMap
			){
		
		Pagination page = service.countMember(dataMap); 
		page.setLimit(15);
		page.setPageSize(10);
		List<SearchedMember> searchedMember = service.searchMember(dataMap,page);
		Gson gson = new Gson(); String pageJson = gson.toJson(page); 
		String resultMember= gson.toJson(searchedMember); 
		dataMap.put("pagination", pageJson);
		dataMap.put("memberList", resultMember);
		
		return dataMap;
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
	
	//공지사항 조회
	@PostMapping("noticeselect")
	public Map<String, String> noticeSelect(
			@RequestBody Map<String,String> dataMap
			){
		
		System.out.println(dataMap);
		Pagination page = noticeService.countNotice(dataMap);
		page.setLimit(15);
		page.setPageSize(10);
		List<Notice> list = noticeService.selectNoticeList(page, dataMap);
		Gson gson = new Gson();
		String pageJson = gson.toJson(page);
		String listJson = gson.toJson(list);
		dataMap.put("pagination", pageJson);
		dataMap.put("noticeList", listJson);
		return dataMap;
	}
	
	//공지사항 수정 시 상세데이터 조회
	@PostMapping("ajaxNoticeDetail")
	public Notice noticeDetailCall(int noticeNo) {
		Notice notice = noticeService.selectOneNotice(noticeNo);
		return notice;
	}
	//공지사항 수정 
	@PostMapping("noticeUpdate")
	public int noticeUpdate(String title,	String noticecate,
			String editordata, String noticeNo) {
		int result =0;
		result = service.updateNotice(title, noticecate, editordata, noticeNo);
		return result;
	}
	
	//회원 대상 문자메세지
	@PostMapping("sendMessage")
	public int sendMessageBySens() {
		
		String result = service.sendmessage();
		System.out.println(result);
		return 0;
	}
	
	//구독옵션 조회하기
	@PostMapping("selectSubsOption")
	public List<SubsOptions> selectSubsOption(int productNo) {
		List<SubsOptions> list = service.selectSubsOption(productNo);
		
		return list;
	}
	//구독옵션 추가하기
	@PostMapping("addSubsOption")
	public int addSubsOption(
			SubsOptions subsOption) {
		int result = service.addSubsOption(subsOption);
		
		return result;
	}
	//구독옵션 삭제하기
	@PostMapping("deleteSubsOption")
	public int deleteSubsOption(
			int suboptionNo) {
		int result = service.deleteSubsOption(suboptionNo);
		return result;
	}
	//구독옵션명 변경하기
	@PostMapping("changeSubsOption")
	public int changeSubsOption(
			SubsOptions SubsOptions) {
		int result = service.changeSubsOption(SubsOptions);
		return result;
	}
	
}
