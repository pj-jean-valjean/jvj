package edu.kh.jvj.subscribe.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.jvj.subscribe.model.dao.SubDAO;

@Service
public class SubServiceImpl implements SubService{

	@Autowired
	private SubDAO dao;
}
