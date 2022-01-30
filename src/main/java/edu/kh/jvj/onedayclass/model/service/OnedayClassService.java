package edu.kh.jvj.onedayclass.model.service;

import java.util.List;

import edu.kh.jvj.onedayclass.model.vo.OnedayClass;

public interface OnedayClassService {

	/** 클래스 리스트 첫페이지 6개 반환
	 * @return list
	 */
	List<OnedayClass> selectClassList();

}
