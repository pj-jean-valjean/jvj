package edu.kh.jvj.notice.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.jvj.admin.model.vo.MadeCoupon;
import edu.kh.jvj.notice.model.dao.NoticeDAO;
import edu.kh.jvj.notice.model.vo.Notice;
import edu.kh.jvj.store.model.vo.Pagination;

@Service
public class NoticeServiceImpl implements NoticeService{

	
	@Autowired
	private NoticeDAO dao;
	
	@Override
	public Pagination countNotice(Map<String , String> map ) {
		int count =  dao.countNotice(map);
		return new Pagination(count,Integer.parseInt(map.get("cp")));
	}
	
	@Override
	public Notice selectOneNotice(int noticeNo) {
		return dao.selectOneNotice(noticeNo);
	}

	@Override
	public List<Notice> selectNoticeList(Pagination page, Map<String, String> dataMap) {
		return dao.selectSearchNoticeList(page,dataMap);
	}

	@Override
	public List<MadeCoupon> selectCoupons(int noticeNo) {
		return dao.selectCoupons(noticeNo);
	}
	
	@Override
	public MadeCoupon getMadeCoupon(int madeCouponNo) {
		return dao.getMadeCoupon(madeCouponNo);
	}
	
	@Override
	public int insertCouponToMember(MadeCoupon madeCoupon) {
		//회원이 사용가능한 해당 쿠폰 받은적 있는지 검사 필요
		
		return dao.insertCouponToMember(madeCoupon);
	}

	@Override
	public int deductionCoupon(int madeCouponNo) {
		return dao.deductionCoupon(madeCouponNo);
	}

	@Override
	public void ChangeCouponStatus(int madeCouponNo) {
		dao.ChangeCouponStatus(madeCouponNo);
	}

	@Override
	public int countGetCoupon(MadeCoupon madeCoupon) {
		return dao.countGetCoupon(madeCoupon);
	}

	@Override
	public void insertCouponHistory(MadeCoupon madeCoupon) {
		dao.insertCouponHistory(madeCoupon);
	}
	
	
}
