package edu.kh.jvj.payment.controller;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import edu.kh.jvj.admin.model.service.AdminService;
import edu.kh.jvj.admin.model.vo.SubsInfo;
import edu.kh.jvj.member.model.vo.Member;
import edu.kh.jvj.onedayclass.model.vo.OnedayClass;
import edu.kh.jvj.payment.model.Service.PaymentService;
import edu.kh.jvj.payment.model.vo.KaKaoPayKey;
import edu.kh.jvj.payment.model.vo.KakaoResult;
import edu.kh.jvj.payment.model.vo.OrderSubsOption;
import edu.kh.jvj.payment.model.vo.Payment;
import edu.kh.jvj.payment.model.vo.RegualrPayInfo;
import edu.kh.jvj.payment.model.vo.RegularPaySuccessSave;
import edu.kh.jvj.payment.model.vo.SubsOrder;

@Controller
@RequestMapping("/payment/*")
public class PaymentController {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private PaymentService service;
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value = "storePayment", method = RequestMethod.POST)
	public String storePayment(HttpSession session, Model model, String carrierList) {
		
		System.out.println("결제화면" + carrierList);
		
//		List<Store> storeList = service.getStoreList(carrierList);
		
//		model.addAttribute("storeList", storeList);
		return "payment/payment";
	}
	
	@RequestMapping(value = "classPayment", method = RequestMethod.POST)
	public String classPayment(HttpSession session, Model model, String totalPrice, String totalPeople, String productNo) {
		System.out.println("상품번호 : "+productNo);
		OnedayClass oneClass = service.getClassSelect(productNo);
		//System.out.println(oneClass);
		
		  model.addAttribute("oneClass", oneClass); model.addAttribute("totalPrice",
		  totalPrice);
		 
		model.addAttribute("totalPeople", totalPeople);
		model.addAttribute("productcate", "3");
		model.addAttribute("productNo", productNo);
		return "payment/payment";
	}
	
	@RequestMapping(value = "subscribePayment", method = RequestMethod.POST)
	public String subscribePayment(HttpSession session, Model model, int hiddenTotalPrice, int hiddentotalAmount,
			int chooseBreadCode, int chooseTasteCode, int choosePeriodCode, int chooseDeliveryDayCode, 
			int productNo) {
		
		Map<String, Integer> subsget = new HashMap<>();
		subsget.put("productNo", productNo);
		SubsInfo subsOrder = adminService.getSubsInfo(subsget);
		SubsOrder oneSubsOrder = new SubsOrder();
		oneSubsOrder.setClassImgList(subsOrder.getClassImgList());
		oneSubsOrder.setTitle(subsOrder.getTitle());
		oneSubsOrder.setTotalAmount(hiddentotalAmount);
		oneSubsOrder.setTotalPrice(hiddenTotalPrice);
		
		String getOptionSearch = chooseBreadCode + " , " +chooseTasteCode + " , "+choosePeriodCode + " , "+chooseDeliveryDayCode ;
		List<OrderSubsOption> optionList = service.getOptionsList(getOptionSearch);
		oneSubsOrder.setOptionList(optionList);
		
		model.addAttribute("productcate", "2");
		model.addAttribute("productNo", ""+productNo);
		model.addAttribute("oneSubsOrder", oneSubsOrder);
		
		return "payment/payment";
	}
	
	@RequestMapping(value = "paymentResult", method = RequestMethod.GET)
	public String paymentResult() {
		return "payment/paymentResult";
	}
	
	//일반결제 정보 저장
	@PostMapping("savePaymentInfo")
	public String savePaymentInfo(@ModelAttribute Payment payInfo){
		
		int result = service.insertPaymentInfo(payInfo);
		
		return "payment/paymentResult";
	}
	
	//정기결제 카카오
	@GetMapping(value= "/kapay",produces="application/json;charset=UTF-8")
	@ResponseBody
	public String kapayTest(RegualrPayInfo regualrPayInfo) {
		
		//시퀀스 가져오기
		int seq = service.getPerchaseSeq();
		System.out.println(regualrPayInfo);
		
		try {
		URL addr =new URL("https://kapi.kakao.com/v1/payment/ready");
		
		String encodeProductName = URLEncoder.encode("JVJ:"+regualrPayInfo.getProductName()+"-"+regualrPayInfo.getProductOption(), "UTF-8");
		String encodeUserId = URLEncoder.encode(regualrPayInfo.getMemberId(), "UTF-8");

		HttpURLConnection kapayconn= (HttpURLConnection)addr.openConnection();
		//요청하는 클라이언트 <-> 카카오페이 연결해주는 줄
		kapayconn.setRequestProperty("Authorization", "KakaoAK 87ca80fc70aa46c3b2afb02867943095");
		kapayconn.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		kapayconn.setDoOutput(true);
		//이 연결을 통해서 서버에 전해줄것이 있는지 여부
		String parameter = "cid=TCSUBSCRIP" // 가맹점 코드
				+ "&partner_order_id="+seq // 가맹점 주문번호
				+ "&partner_user_id="+encodeUserId// 가맹점 회원 id
				+ "&item_name="+encodeProductName // 상품명
				+ "&quantity="+regualrPayInfo.getAmount() // 상품 수량
				+ "&total_amount="+regualrPayInfo.getTotalPrice()// 총 금액
				+ "&vat_amount=0" // 부가세
				+ "&tax_free_amount=0" // 상품 비과세 금액
				+ "&approval_url=http://localhost:8080/jvj/payment/payresult?partner_order_id="+seq // 결제 성공 시
				+ "&fail_url=http://localhost:8080/fail" // 결제 실패 시
				+ "&cancel_url=http://localhost:8080/jvj/subscribe/subBread";
		
		OutputStream output = kapayconn.getOutputStream();
		DataOutputStream daoutput = new DataOutputStream(output);
		
		daoutput.writeBytes(parameter);
		daoutput.close();
		
		int result = kapayconn.getResponseCode();
		//통신 결과 반환받음
		InputStream instream;
		//결과 200=성공
		if(result == 200) {
			instream= kapayconn.getInputStream();
		}else {
			instream= kapayconn.getErrorStream();
		}
		//받아온 결과를 읽어야 한다
		InputStreamReader reader = new InputStreamReader(instream);
		//읽는 스트림 선언
		
		BufferedReader bufferR = new BufferedReader(reader);
		String resultJSON = bufferR.readLine();
		
		resultJSON = resultJSON.substring(0, resultJSON.length()-1)+",\"partner_order_id\":"+"\""+seq+"\""+",\"userid\":"+"\""+regualrPayInfo.getMemberId()+"\""+"}";
		return resultJSON;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//저장시키기 
	@PostMapping("/payKeySave")
	@ResponseBody
	public String KeySave(RegualrPayInfo rpi) {
		//주문정보 일시저장	
		int result= service.saveRegularPayKey(rpi);
		return "성공";
	}
	
	
	@GetMapping("/payresult")
	public String kapayReturn(String pg_token, String partner_order_id) {
		//DB에 저장해놓은 partner_order_id 를 조회해 tid를 가져온다 !
		KaKaoPayKey kaKaoPayKey = service.getKaKaoTid(partner_order_id);
		try {
			URL addr =new URL("https://kapi.kakao.com/v1/payment/approve");
			HttpURLConnection kapayconn= (HttpURLConnection)addr.openConnection();
			//요청하는 클라이언트 <-> 카카오페이 연결해주는 줄
			kapayconn.setRequestProperty("Authorization", "KakaoAK 87ca80fc70aa46c3b2afb02867943095");
			kapayconn.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
			kapayconn.setDoOutput(true);
			//이 연결을 통해서 서버에 전해줄것이 있는지 여부
			String parameter = "cid=TCSUBSCRIP" // 가맹점 코드
					+ "&tid="+kaKaoPayKey.getTid() // 거래번호
					+ "&partner_order_id="+partner_order_id // 가맹점 주문번호
					+ "&partner_user_id="+kaKaoPayKey.getUserId() // 가맹점 회원 id
					+ "&pg_token="+pg_token; //결제승인 요청 인증 토큰
			OutputStream output = kapayconn.getOutputStream();
			DataOutputStream daoutput = new DataOutputStream(output);
			daoutput.writeBytes(parameter);
			daoutput.close();
			
			int result = kapayconn.getResponseCode();
			InputStream instream;
			//결과 200=성공
			if(result == 200) {
				instream= kapayconn.getInputStream();
			}else {
				instream= kapayconn.getErrorStream();
			}
			InputStreamReader reader = new InputStreamReader(instream);
			
			BufferedReader bufferR = new BufferedReader(reader);
			String abc = bufferR.readLine();
			
			//다시 보낸다
			//{"aid":"A1620684ff524c5d5ccb","tid":"T1620684ee1f1275646d","cid":"TCSUBSCRIP","sid":"S1620684ff1f1275646e",
			//"partner_order_id":"45","partner_user_id":"qkrtkddn77@naver.com",
			//"payment_method_type":"MONEY","item_name":"JVJ:빵 세트-금요일 / 2주 / 초코 / 바게트 ",
			//"quantity":3,"amount":{"total":30,"tax_free":0,"vat":0,"point":0,"discount":0},
			//"created_at":"2022-02-12T00:46:55","approved_at":"2022-02-12T00:47:11"}
			
			if(result==200) {
				RegularPaySuccessSave saveRegularSuccess = new Gson().fromJson(abc, RegularPaySuccessSave.class);
				if(saveRegularSuccess.getPayment_method_type().equals("MONEY")) {
						String option = saveRegularSuccess.getItem_name();
						String[] options = option.split(" / ");
						saveRegularSuccess.setPayTerm(options[1].charAt(0)-48);
						//결제 텀
						
						//결제정보 UPDATE 함
						result = service.saveRegularSuccess(saveRegularSuccess);
				}
			}
			return abc;
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return"/kpay/payResult";
	}
	
	
	
}
