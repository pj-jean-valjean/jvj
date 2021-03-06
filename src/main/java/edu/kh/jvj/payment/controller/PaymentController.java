package edu.kh.jvj.payment.controller;


/*import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
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
import edu.kh.jvj.cart.model.service.CartService;
import edu.kh.jvj.cart.model.vo.Carrier;
import edu.kh.jvj.cart.model.vo.Cart;
import edu.kh.jvj.cart.model.vo.Option;
import edu.kh.jvj.member.model.vo.Member;
import edu.kh.jvj.mypage.model.vo.Coupon;
import edu.kh.jvj.mypage.model.vo.Store;
import edu.kh.jvj.onedayclass.model.vo.OnedayClass;
import edu.kh.jvj.payment.model.Service.PaymentService;
import edu.kh.jvj.payment.model.vo.KaKaoPayKey;
import edu.kh.jvj.payment.model.vo.KakaoResult;
import edu.kh.jvj.payment.model.vo.OrderSubsOption;
import edu.kh.jvj.payment.model.vo.Payment;
import edu.kh.jvj.payment.model.vo.RegualrPayInfo;
import edu.kh.jvj.payment.model.vo.RegularPaySuccessSave;
import edu.kh.jvj.payment.model.vo.StoreOrderInfo;
import edu.kh.jvj.payment.model.vo.SubsOrder;
import edu.kh.jvj.store.model.service.StoreService;

@Controller
@RequestMapping("/payment/*")
public class PaymentController {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private PaymentService service;
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value = "classPayment", method = RequestMethod.POST)
	public String classPayment(HttpSession session, Model model, String totalPrice, String totalPeople, String productNo) {
		System.out.println("???????????? : "+productNo);
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
	
	//???????????? ?????? ??????
	@PostMapping(value= "savePaymentInfo",produces="application/json;charset=UTF-8")
	@ResponseBody
	public Map<String, String> savePaymentInfo(@ModelAttribute Payment payInfo){
		
		int result = service.insertPaymentInfo(payInfo);
		Map<String, String> informs = new HashMap<String, String>();
		if(result==-1 && payInfo.getProductCd()==3) {
			informs.put("msg" , "?????? ????????? ?????????????????? ????????? ???????????????");
			return informs;
		}
		if(result>0) {
			informs.put("msg" , "????????????");
			return informs;
		}
		else {
			//???????????? 
			informs.put("msg" , "????????????! ????????? ???????????????");
			return informs;
		}
	}
	
	@PostMapping("possibleCheck")
	@ResponseBody
	public int possibleCheck(int productNo) {
		int result = service.possibleCheck(productNo);
		log.info("???????????? ?????? {}", result);
		return result;
	}
	
	//???????????? ??????
	@PostMapping(value= "normalpayRefund",produces="application/json;charset=UTF-8")
	@ResponseBody
	public Map<String, String> normalpayRefund(@ModelAttribute Payment payInfo){
		
		int result = service.insertPaymentInfo(payInfo);
		Map<String, String> informs = new HashMap<String, String>();
		if(result==-1 && payInfo.getProductCd()==3) {
			informs.put("msg" , "?????? ????????? ?????????????????? ????????? ???????????????");
			return informs;
		}
		if(result>0) {
			informs.put("msg" , "????????????");
			return informs;
		}
		else {
			//???????????? 
			informs.put("msg" , "????????????! ????????? ???????????????");
			return informs;
		}
	}
	
	//???????????? ?????? ??? ??????
	@GetMapping("nomalPaymentResult")
	public String nomalPaymentResult(String merchant_uid, Model model) {
		System.out.println(merchant_uid);
		Payment payResult = service.getPayResult(merchant_uid);
		System.out.println(payResult);
		if(payResult!= null) {
			model.addAttribute("payResult", payResult);
			return "payment/nomalPaymentResult";
		}
		else {
			return "error";
		}
	}
	
	
	
	
	//???????????? ?????????
	@GetMapping(value= "/kapay",produces="application/json;charset=UTF-8")
	@ResponseBody
	public String kapayTest(RegualrPayInfo regualrPayInfo, HttpServletRequest req) {
		

		
		//????????? ????????????
		int seq = service.getPerchaseSeq();
		System.out.println("????????? ????????? ???????????????!!!"+seq);
		System.out.println("????????? ????????? ???????????????!!!");
		try {
		URL addr =new URL("https://kapi.kakao.com/v1/payment/ready");
		
		String encodeProductName = URLEncoder.encode("JVJ:"+regualrPayInfo.getProductName()+"-"+regualrPayInfo.getProductOption(), "UTF-8");
		String encodeUserId = URLEncoder.encode(regualrPayInfo.getMemberId(), "UTF-8");

		HttpURLConnection kapayconn= (HttpURLConnection)addr.openConnection();
		//???????????? ??????????????? <-> ??????????????? ??????????????? ???
		kapayconn.setRequestProperty("Authorization", "KakaoAK 87ca80fc70aa46c3b2afb02867943095");
		kapayconn.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		kapayconn.setDoOutput(true);
		//??? ????????? ????????? ????????? ??????????????? ????????? ??????
		
		String paths = req.getContextPath();
		
		String parameter = "cid=TCSUBSCRIP" // ????????? ??????
				+ "&partner_order_id="+seq // ????????? ????????????
				+ "&partner_user_id="+encodeUserId// ????????? ?????? id
				+ "&item_name="+encodeProductName // ?????????
				+ "&quantity="+regualrPayInfo.getAmount() // ?????? ??????
				+ "&total_amount="+regualrPayInfo.getTotalPrice()// ??? ??????
				+ "&vat_amount=0" // ?????????
				+ "&tax_free_amount=0" // ?????? ????????? ??????
				+ "&approval_url="+"http://kh-aclass.xyz:8080/jvj/"+"/payment/payresult?partner_order_id="+seq // ?????? ?????? ???
				+ "&fail_url="+"http://kh-aclass.xyz:8080/jvj/"+"/fail/asdsadsad" // ?????? ?????? ???
				+ "&cancel_url="+"http://kh-aclass.xyz:8080/jvj/"+"/subscribe/subBread";
		
		OutputStream output = kapayconn.getOutputStream();
		DataOutputStream daoutput = new DataOutputStream(output);
		
		daoutput.writeBytes(parameter);
		daoutput.close();
		
		int result = kapayconn.getResponseCode();
		//?????? ?????? ????????????
		InputStream instream;
		//?????? 200=??????
		if(result == 200) {
			instream= kapayconn.getInputStream();
		}else {
			instream= kapayconn.getErrorStream();
		}
		//????????? ????????? ????????? ??????
		InputStreamReader reader = new InputStreamReader(instream);
		//?????? ????????? ??????
		
		BufferedReader bufferR = new BufferedReader(reader);
		String resultJSON = bufferR.readLine();
		
		resultJSON = resultJSON.substring(0, resultJSON.length()-1)+",\"partner_order_id\":"+"\""+seq+"\""+",\"userid\":"+"\""+regualrPayInfo.getMemberId()+"\""+"}";
		System.out.println(resultJSON);
		return resultJSON;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//??????????????? 
	@PostMapping("/payKeySave")
	@ResponseBody
	public String KeySave(RegualrPayInfo rpi) {
		//???????????? ????????????	
		int result= service.saveRegularPayKey(rpi);
		return "??????";
	}
	
	
	@GetMapping("/payresult")
	public String kapayReturn(String pg_token, String partner_order_id, Model model) {
		
		if(service.getPayDoneYn(partner_order_id)>0) {
			//??????????????? : ??????????????? / ???????????? / 
			RegualrPayInfo RpayInfo = service.getRecieverInfo(Integer.parseInt(partner_order_id));
			//???????????? ?????????
			String imgSrc = service.getProductMainImg(RpayInfo.getProductNo());
			model.addAttribute("orderInfo", RpayInfo);
			model.addAttribute("imgSrc", imgSrc);
			
			return "payment/paymentResult";
		}
		
		//DB??? ??????????????? partner_order_id ??? ????????? tid??? ???????????? !
		KaKaoPayKey kaKaoPayKey = service.getKaKaoTid(partner_order_id);
		
		try {
			URL addr =new URL("https://kapi.kakao.com/v1/payment/approve");
			HttpURLConnection kapayconn= (HttpURLConnection)addr.openConnection();
			//???????????? ??????????????? <-> ??????????????? ??????????????? ???
			kapayconn.setRequestProperty("Authorization", "KakaoAK 87ca80fc70aa46c3b2afb02867943095");
			kapayconn.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
			kapayconn.setDoOutput(true);
			//??? ????????? ????????? ????????? ??????????????? ????????? ??????
			String parameter = "cid=TCSUBSCRIP" // ????????? ??????
					+ "&tid="+kaKaoPayKey.getTid() // ????????????
					+ "&partner_order_id="+partner_order_id // ????????? ????????????
					+ "&partner_user_id="+kaKaoPayKey.getUserId() // ????????? ?????? id
					+ "&pg_token="+pg_token; //???????????? ?????? ?????? ??????
			OutputStream output = kapayconn.getOutputStream();
			DataOutputStream daoutput = new DataOutputStream(output);
			daoutput.writeBytes(parameter);
			daoutput.close();
			
			int result = kapayconn.getResponseCode();
			InputStream instream;
			//?????? 200=??????
			if(result == 200) {
				instream= kapayconn.getInputStream();
			}else {
				instream= kapayconn.getErrorStream();
			}
			InputStreamReader reader = new InputStreamReader(instream);
			
			BufferedReader bufferR = new BufferedReader(reader);
			String abc = bufferR.readLine();
			
			if(result==200) {
				RegularPaySuccessSave saveRegularSuccess = new Gson().fromJson(abc, RegularPaySuccessSave.class);
				if(saveRegularSuccess.getPayment_method_type().equals("MONEY")) {
						String option = saveRegularSuccess.getItem_name();
						String[] options = option.split(" / ");
						saveRegularSuccess.setPayTerm(options[1].charAt(0)-48);
						//?????? ???
						
						//???????????? UPDATE ???
						result = service.saveRegularSuccess(saveRegularSuccess);
						
						if(result>0) {
							
							//??????????????? : ??????????????? / ???????????? / 
							RegualrPayInfo RpayInfo = service.getRecieverInfo(Integer.parseInt(partner_order_id));
							//???????????? ?????????
							String imgSrc = service.getProductMainImg(RpayInfo.getProductNo());
							model.addAttribute("orderInfo", RpayInfo);
							model.addAttribute("imgSrc", imgSrc);
							
							return "payment/paymentResult";
						}
				}
			}
			else {
				return "payment/error";
			}
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return"/payment/paymentResult";
	}
	
	
	@PostMapping(value = "saveStoreOrderInfo",produces="application/json;charset=UTF-8")
	@ResponseBody
	public Map<String, String> saveStoreOrderInfo(StoreOrderInfo storeInfo) {
		int result = service.saveStoreInfo(storeInfo);
		Map<String, String> informs = new HashMap<String, String>();
		if(result>0) {
			informs.put("msg" , "????????????");
			return informs;
		}
		
		informs.put("msg" , "????????????! ????????? ???????????????");
		return informs;
	}
	@PostMapping(value = "callCoupon",produces="application/json;charset=UTF-8")
	@ResponseBody
	public List<Coupon> callCoupon(int memberNo) {
		List<Coupon> coupons= service.callCoupon(memberNo);
		
		Map<String, String> informs = new HashMap<String, String>();
		
		return coupons;
	}

	
}
*/
