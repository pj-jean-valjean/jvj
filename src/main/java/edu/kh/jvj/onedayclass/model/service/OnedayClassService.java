package edu.kh.jvj.onedayclass.model.service;

import java.util.List;
import java.util.Map;

import edu.kh.jvj.onedayclass.model.vo.OnedayClass;

public interface OnedayClassService {


	/** 스크롤시 1페이지 추가
	 * @param pagination
	 * @return List<OnedayClass>
	 */
	List<OnedayClass> scrollListAdd(Map<String, String> pagination);

	/** 클래스 상세페이지
	 * @param productNo
	 * @return OnedayClass
	 */
	OnedayClass selectOneClass(int productNo);
	
}
