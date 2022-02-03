package edu.kh.jvj.onedayclass.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.kh.jvj.onedayclass.model.service.OnedayClassService;
import edu.kh.jvj.onedayclass.model.vo.OnedayClass;

@Controller
@RequestMapping("onedayclass/*")
public class OnedayClassController {
	
	 private Logger log = LoggerFactory.getLogger(getClass());  
	
	private final OnedayClassService service;
	@Autowired
	public OnedayClassController(OnedayClassService service) {
		this.service = service;
	}
	
	@GetMapping("list")
	public String showOnedayClassList(Model model) {
		return "/onedayclass/onedayClassList";
	}
	
	@GetMapping("view/{productNo}")
	public String showOnedayClassDetail(
			@PathVariable int productNo, Model model
			) {
		OnedayClass Oneclass = service.selectOneClass(productNo);
		if(Oneclass!=null) {
			Oneclass.setProductNo(productNo);
			model.addAttribute("Oneclass", Oneclass);
		}
		else {
			model.addAttribute("message","해당 클래스가 접근 불가 상태입니다.");
		}
		
		return "/onedayclass/onedayClassDetail";
	}
	//produces="application/json;charset=UTF-8"
	@PostMapping(value="list")
	@ResponseBody
	public ResponseEntity<List<OnedayClass>>  scrollListAdd(
			@RequestBody Map<String, String> pagination  , Model model) {

		long startMs = System.currentTimeMillis(); // 서비스 시작 시의 ms 값
		  
		List<OnedayClass> oneLineList = service.scrollListAdd(pagination);	
		
		long endMs = System.currentTimeMillis(); // 서비스 종료 시의 ms 값
		
		long takeTime = (endMs - startMs);
		
		if(oneLineList.isEmpty()) {
			log.info("검색기준 : {}" , pagination.get("getType"));
			log.info("결과 : {}" , "결과 클래스가 없습니다");
			model.addAttribute("message", "진행 중 클래스가 없습니다");
		}
		else {
			log.info("검색기준 : {}" , pagination.get("getType"));
			log.info("반환 ondDayClass 개수: {}" , oneLineList.size());
		}
			log.info("원데이클래스 로딩 소요시간 : {} ms" , takeTime);
			
		return new ResponseEntity<>(oneLineList, HttpStatus.OK);
	}
	 
	/*
	 * @PostMapping("getPlace")
	 * 
	 * @ResponseBody public String getPlace(String mapAddress) {
	 * System.out.println("mapAddress=" + mapAddress); try {
	 * 
	 * String urldata = "http://dapi.kakao.com/v2/local/search/address.json?query=";
	 * //인코딩한 String을 넘겨야 원하는 데이터를 받을 수 있다. String address =
	 * URLEncoder.encode(mapAddress, "UTF-8");
	 * 
	 * URL addr =new URL(urldata+address);
	 * 
	 * HttpURLConnection getaddress= (HttpURLConnection)addr.openConnection();
	 * 
	 * getaddress.setRequestProperty("X-Requested-With", "curl");
	 * getaddress.setRequestProperty("Authorization",
	 * "KakaoAK e96f24a02e71efe8bd0070389f452c0f");
	 * getaddress.setRequestProperty("Content-type",
	 * "application/json;charset=utf-8"); getaddress.setDoOutput(true);
	 * getaddress.setUseCaches(false); getaddress.setDefaultUseCaches(false);
	 * 
	 * int result = getaddress.getResponseCode(); //통신 결과 반환받음 InputStream instream;
	 * //결과 200=성공 if(result == 200) { instream= getaddress.getInputStream(); }else
	 * { instream= getaddress.getErrorStream(); } //받아온 결과를 읽어야 한다 InputStreamReader
	 * reader = new InputStreamReader(instream); //읽는 스트림 선언 BufferedReader bufferR
	 * = new BufferedReader(reader); String resultJSON = bufferR.readLine();
	 * System.out.println(resultJSON); return resultJSON; } catch(Exception e) {
	 * e.printStackTrace(); } return null; }
	 */
}
