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
		return dao.insertCouponToMember(madeCoupon);
	}
	
	
}
