package edu.kh.jvj.admin.model.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import edu.kh.jvj.admin.model.dao.AdminDAO;
import edu.kh.jvj.admin.model.vo.ProductImage;
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
		if(result<=0) {
			return 0;
		}
		//2-1 일반스토어 
		if(product.getWritecate()==1) {
			result = dao.insertStoreProduct(product); 
			result = dao.insertStoreDiscount(product); 
		}
		//2-2 구독스토어
		else if(product.getWritecate()==2) {
			
		}
		//2-3 클래스 페이지
		else {
			String plustime="";
			plustime += (product.getStarthour()<=9? "0"+product.getStarthour():product.getStarthour())+": "
					+(product.getStartminute()==0? "0"+product.getStartminute():product.getStartminute())+ " ~ " 
					 + (product.getEndhour()<=9? "0"+product.getEndhour():product.getEndhour())+": "
					 +(product.getEndminute()==0? "0"+product.getEndminute():product.getEndminute());
			product.setStartEndTime(plustime);
			//수업시간 설정
			product.setClassdate(product.getClassdate());
			//일시 성정
			
			 result = dao.insertClassProduct(product); 
		}
		
		//3. 상품 이미지 등록
		if(result>0) {
			List<ProductImage> imgList = new ArrayList<ProductImage>();
			for(int i =0 ; i< images.size();i++) {
				// i == images의 인덱스 == 업로드된 파일의 레벨
				
				// 각 인덱스 요소에 파일이 업로드 되었는지 검사
				if(!images.get(i).getOriginalFilename().equals("")) {
					// 업로드가 된 경우
					// MultipartFile에서 DB저장 필요한 데이터만을 추출하여
					// ProductImage 객체에 담은 후 imgList 추가
					
					ProductImage img = new ProductImage();
					img.setImgPath(webPath);
					img.setImgName(fileRename(images.get(i).getOriginalFilename()));
					img.setImgLevel(i);
					img.setProductNo(product.getProductNo());
					
					imgList.add(img);
				}
			}
			
			//imgList에 업로드된 이미지가 있다면 DAO 호출
			if(!imgList.isEmpty()){
				result = dao.insertImgList(imgList);
			      
//			      5) 삽입 성공한 행의 개수와 imgList 개수가 같을 때
//			      파일을 서버에 저장
//			      서버즈탭 -> fin server -> Overview
//				server modeules without publishing 체크 -> 프로젝트 경로 일치시키기
//				저장되는 파일 경로를 현재 프로젝트로 지정할 수 있음
				if(result == imgList.size()) {// 성공 ==> 파일저장
					
					//images - MultipartFile List , 실제 파일 자체 + 정보
					//imgList - BoardImage List, DB에 저장할 파일 정보
					for(int i =0 ; i<imgList.size(); i++) {
						// 업로드된 파일이 있는 images의 인덱스 요소를 얻어와 
						// 지정된 경로와 이름으로 파일로 변환하여 저장
						
						try {
							images.get(imgList.get(i).getImgLevel())
							.transferTo(new File(serverPath+imgList.get(i).getImgName() ));
						}catch (Exception e) {
							e.printStackTrace();
							//파일 변환이 실패할 경우
						}
					}
				}
				else {
					/* 예외 */
				}
			}
			
		}
		//4. 이미지 파일화
		
		return result;
	}
	

	// 공지사항 작성
	@Override
	public int insertNotice(String title, String noticecate, String editordata, int loginMember) {
		
		title= XSS(title);
		Map<String, String> noticeMap = new HashMap<String, String>();
		
		noticeMap.put("title", title);
		noticeMap.put("noticecate", noticecate);
		noticeMap.put("editordata", editordata);
		noticeMap.put("loginMember", loginMember+"");
		
		 return dao.insertNotice(noticeMap); 
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
