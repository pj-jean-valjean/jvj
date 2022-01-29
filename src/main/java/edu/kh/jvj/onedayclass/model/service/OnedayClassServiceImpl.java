package edu.kh.jvj.onedayclass.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.jvj.onedayclass.model.dao.OnedayClassDAO;
import edu.kh.jvj.onedayclass.model.vo.OnedayClass;

@Service
public class OnedayClassServiceImpl implements OnedayClassService{

	private final OnedayClassDAO dao;
	@Autowired
	public OnedayClassServiceImpl(OnedayClassDAO dao) {
		this.dao  = dao;
	}
	
	@Override
	public List<OnedayClass> selectClassList() {
		
		List<OnedayClass> list = dao.selsectClassList();
		
		
		
		return null;
	}
	
}
