package edu.kh.jvj.notice.model.service;

import java.util.List;

import edu.kh.jvj.notice.model.vo.Notice;
import edu.kh.jvj.store.model.vo.Pagination;

public interface NoticeService {

	/** 공지사항 총 개수 : 페이지네이션 계산
	 * @return COUNT(*)
	 */
	Pagination countNotice(int cp);
	
	/** 공지사항 리스트
	 * @param page
	 * @param cate
	 * @return
	 */
	List<Notice> selectNoticeList(Pagination page,int cate);

	/** 공지사항 상세
	 * @param noticeNo
	 * @return
	 */
	Notice selectOneNotice(int noticeNo);
}
