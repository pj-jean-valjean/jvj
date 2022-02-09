package edu.kh.jvj.subscribe.model.service;

import java.util.Map;

import edu.kh.jvj.subscribe.model.vo.SubVO;

public interface SubService {

	/** 구독 빵 상세 조회
	 * @param map
	 * @return 
	 */
	SubVO selectSubBread(Map<String, Integer> map);

}
