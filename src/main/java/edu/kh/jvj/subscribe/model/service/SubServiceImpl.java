package edu.kh.jvj.subscribe.model.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.jvj.subscribe.model.dao.SubDAO;
import edu.kh.jvj.subscribe.model.vo.SubVO;

@Service
public class SubServiceImpl implements SubService{

	@Autowired
	private SubDAO dao;

	// 빵 상세조회
	@Override
	public SubVO selectSubBread(Map<String, Integer> map) {
		
		return dao.selectSubBread(map);
	}
}
