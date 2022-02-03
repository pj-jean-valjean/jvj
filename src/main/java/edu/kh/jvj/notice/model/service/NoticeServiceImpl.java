package edu.kh.jvj.notice.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.jvj.notice.model.dao.NoticeDAO;
import edu.kh.jvj.notice.model.vo.Notice;
import edu.kh.jvj.store.model.vo.Pagination;

@Service
public class NoticeServiceImpl implements NoticeService{

	
	@Autowired
	private NoticeDAO dao;
	
	@Override
	public Pagination countNotice(int cp) {
		int count =  dao.countNotice();
		return new Pagination(count,cp);
	}
	
	@Override
	public List<Notice> selectNoticeList(Pagination page,int cate) {
		return dao.selectStoreList(page, cate);
	}

	@Override
	public Notice selectOneNotice(int noticeNo) {
		return dao.selectOneNotice(noticeNo);
	}
	
	
}
