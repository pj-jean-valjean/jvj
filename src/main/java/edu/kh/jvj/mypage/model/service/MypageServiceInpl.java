package edu.kh.jvj.mypage.model.service;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


import edu.kh.jvj.member.model.vo.Member;
import edu.kh.jvj.member.model.vo.SnsToken;
import edu.kh.jvj.mypage.model.dao.MypageDAO;
import edu.kh.jvj.mypage.model.vo.Coupon;
import edu.kh.jvj.mypage.model.vo.CouponStatus;
import edu.kh.jvj.mypage.model.vo.Like;
import edu.kh.jvj.mypage.model.vo.Pagination;
import edu.kh.jvj.mypage.model.vo.Order;

@Service
public class MypageServiceInpl implements MypageService {

	@Autowired
	private MypageDAO dao;

	@Autowired
	private BCryptPasswordEncoder encoder;


	// 마이페이지 쿠폰
	@Override
	public Pagination couponPagination(int cp , Coupon coupon) {
		

	


		// 전체 쿠폰 조회수 
		int listCount = dao.getCouponCount(coupon);
		return new Pagination(listCount, cp);
	}

	// 쿠폰 목록 조회
	@Override
	public List<Coupon> couponList(Pagination pagination, Coupon coupon) {
		return dao.getCouponList(pagination, coupon);
	}

	// 쿠폰 카테고리
	@Override
	public List<CouponStatus> statusCategory() {
		return dao.statusCategory();
	}

	// 좋아요 페이지네이션
	@Override

	public Pagination getLikePagination(int cp, Like like) {
		
		int count = dao.getLikeCount(like);
		return new Pagination(count, cp);

	}

	// 좋아요 목록 조회
	@Override
	public List<Like> getLikeList(Pagination paginationLike, Like like) {
		return dao.getLikeList(paginationLike, like);
	}

	// 좋아요 취소
	@Override
	public int cancleLike(Like like) {
		return dao.cancleLike(like);
	}

	// 회원 정보 수정
	@Override
	public int memberUpdate(Member member) {
		return dao.memberUpdate(member);
	}

	// 비밀번호 수정
    @Override
    public int updatePw(Map<String, String> map) {
        

        String decodePw = dao.selectDecodePw(map.get("memberNo"));
        

        int pwUpdate = 0;
        

        if(encoder.matches(map.get("memberPw"), decodePw)) {
            

            String encPw = encoder.encode(map.get("modifyPw"));
            

            map.put("modifyPw", encPw);
            

            pwUpdate = dao.modifyPassword(map);
        }
        

        return pwUpdate;
    }

    // sns 회원 탈퇴
    @Override
    public int secession(Member loginMember, SnsToken token) throws Exception{

        if( loginMember.getService().equals("naver")) {

        } else if( loginMember.getService().equals("kakao")) {

        }


        return dao.secession(0);
    }

    

	// 일반 결제 리스트
	@Override

	public List<Order> purList(Order order) {
		return dao.purList(order);
	}

	// 클래스 결제 리스트
	@Override
	public List<Order> classList(Order order) {
		return dao.classPurList(order);
	}

	// 정기 구독 결제 리스트
	@Override
	public List<Order> subscription(Order order) {
		return dao.subscriptionList(order);
	}
	// 메인페이지 리스트 조회
	@Override
	public List<Order> mypageMain(Order order) {
		return dao.mypageMain(order);
	}

	// 일반 결제 페이지네이션
	@Override
	public Pagination purPagination(int cp, Order order) {
		
		int purCount = dao.purchaseListCount(order);
		
		return new Pagination(purCount, cp);
	}
	
	// 원데이클래스 결제 페이지네이션
	@Override
	public Pagination classPagination(int cp, Order order) {
		
		int classCount = dao.classListCount(order);
		
		return new Pagination(classCount, cp);

    
	public int updatePw(Map<String, String> map) {

		String decodePw = dao.selectDecodePw(map.get("memberNo"));

		int pwUpdate = 0;

		if(encoder.matches(map.get("memberPw"), decodePw)) {

			String encPw = encoder.encode(map.get("modifyPw"));

			map.put("modifyPw", encPw);

			pwUpdate = dao.modifyPassword(map);
		}

		return pwUpdate;

	}

	// 정기 구독 결제 페이지네이션
	@Override
	public Pagination subPagination(int cp, Order order) {
		
		int subCount = dao.subListCount(order);
		
		return new Pagination(subCount, cp);
	}


	// sns 회원 탈퇴
	@Override
	public int secession(Member loginMember, SnsToken token) throws Exception{

		if( loginMember.getService().equals("naver")) {

		} else if( loginMember.getService().equals("kakao")) {


		}



		return dao.secession(0);
	}


	// 메인 페이지
	@Override
	public List<Order> selectPurList(Order order) {
		return dao.selectPurList(order);
	}


    @Override
    public int getKakaoToken(String snsToken) throws Exception{
        String reqURL = "https://kapi.kakao.com/v1/user/unlink"; 
            URL url = new URL(reqURL); 
            HttpURLConnection conn = (HttpURLConnection) url.openConnection(); 
            conn.setRequestMethod("POST"); 
            conn.setRequestProperty("Authorization", "Bearer " + snsToken); 
            int responseCode = conn.getResponseCode(); 
            System.out.println("responseCode : " + responseCode); 
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream())); 
            String result = ""; 
            String line = ""; 
            while ((line = br.readLine()) != null) { 
                result += line; 
            } 
        
        int kaResult = 0;
        if(!result.equals("")) {
            kaResult = 1;
        } 
        
        return kaResult;

    }


	
	
	
	

	@Override
	public int getKakaoToken(String snsToken) throws Exception{
		String reqURL = "https://kapi.kakao.com/v1/user/unlink"; 
			URL url = new URL(reqURL); 
			HttpURLConnection conn = (HttpURLConnection) url.openConnection(); 
			conn.setRequestMethod("POST"); 
			conn.setRequestProperty("Authorization", "Bearer " + snsToken); 
			int responseCode = conn.getResponseCode(); 
			System.out.println("responseCode : " + responseCode); 
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream())); 
			String result = ""; 
			String line = ""; 
			while ((line = br.readLine()) != null) { 
				result += line; 
			} 
		
		int kaResult = 0;
		if(!result.equals("")) {
			kaResult = 1;
		} 
		
		return kaResult;

	}






}