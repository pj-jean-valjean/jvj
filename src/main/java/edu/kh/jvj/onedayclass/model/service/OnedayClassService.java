package edu.kh.jvj.onedayclass.model.service;

import java.util.List;
import java.util.Map;

import edu.kh.jvj.onedayclass.model.vo.OnedayClass;

public interface OnedayClassService {

	/** 클래스 리스트 첫페이지 8개 반환
	 * @return list
	 */
	List<OnedayClass> selectClassList();

	/** 스크롤시 1페이지 추가
	 * @param pagination
	 * @return
	 */
	List<OnedayClass> scrollListAdd(Map<String, String> pagination);
	
}
