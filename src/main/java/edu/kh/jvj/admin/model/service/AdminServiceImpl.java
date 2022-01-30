package edu.kh.jvj.admin.model.service;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import edu.kh.jvj.admin.model.dao.AdminDAO;
import edu.kh.jvj.admin.model.vo.ProductWrite;

@Service
public class AdminServiceImpl implements AdminService{
	
	private final AdminDAO dao;
	@Autowired
	public AdminServiceImpl(AdminDAO dao) {
		this.dao = dao;
	}
	
	@Override
	@Transactional
	public int insertProduct(List<MultipartFile> images, ProductWrite product, String webPath,String serverPath) {
		int result = 0;
		//1 개행문자 처리
		product.setTitle(XSS(product.getTitle()));
		//2. 상품 메인+상세 등록
		//메인등록 (상품번호 시퀀스 , 이름 , 가격 , 생성일(default) , 상품카테고리)
		result= dao.insertProductCommon(product);
		
		//2-1 일반스토어 
		if(product.getWritecate()==1) {
			
		}
		//2-2 구독스토어
		else if(product.getWritecate()==2) {
			
		}
		//2-3 클래스 페이지
		else {
			String plustime="";
			plustime += (product.getStarthour()==9? "0"+product.getStarthour():product.getStarthour())+": "
					  + product.getStartminute()+ " ~ " 
					 + (product.getEndhour()==9? "0"+product.getEndhour():product.getEndhour())+": "
					  + product.getEndminute();
			product.setStartEndTime(plustime);
			//수업시간 설정
			product.setClassdate(product.getClassdate());
			//일시 성정
			
			 result = dao.insertClassProduct(product); 
		}
		
		//3. 상품 이미지 등록
		
		//4. 이미지 파일화
		
		return result;
	}
	
	@Override
	public int insertNotice(String title, String noticecate, String editordata) {
		
		title = XSS(title);
		
		return 0;
	}
	
	
	
	// 크로스 사이트 스크립트 방지 처리 메소드
	   public static String XSS(String param) {
	      String result = param;
	      if (param != null) {
	         result = result.replaceAll("&", "&amp;");
	         result = result.replaceAll("<", "&lt;");
	         result = result.replaceAll(">", "&gt;");
	         result = result.replaceAll("\"", "&quot;");
	      }

	      return result;
	   }

	   // 파일명 변경 메소드
	   public static String fileRename(String originFileName) {
	      SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	      String date = sdf.format(new java.util.Date(System.currentTimeMillis()));

	      int ranNum = (int) (Math.random() * 100000); // 5자리 랜덤 숫자 생성

	      String str = "_" + String.format("%05d", ranNum);

	      String ext = originFileName.substring(originFileName.lastIndexOf("."));

	      return date + str + ext;
	   }
	   
	   // 개행 문자 변경 메소드
	   public static String changeNewLine(String content) {
	      return content.replaceAll("(\r\n|\r|\n|\n\r)", "<br>");
	      
	      
	   }

}
