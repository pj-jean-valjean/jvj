package edu.kh.jvj.store.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.jvj.store.model.dao.StoreDAO;
import edu.kh.jvj.store.model.vo.Pagination;
import edu.kh.jvj.store.model.vo.Search;
import edu.kh.jvj.store.model.vo.Store;

@Service
public class StoreServiceImpl implements StoreService {

	@Autowired
	private StoreDAO dao;



	@Override
	public Pagination getPagination(int cp,Search search) {
		// 전체 게시글 수 카운트
		int listCount = 0;
	
			 listCount = dao.getListCount(search);
	
		return new Pagination(listCount,cp);
	}



	@Override
	public List<Store> selectStoreList(Pagination pagination,Search search) {

		return dao.selectStoreList(pagination,search);
	}



	@Override
	public Store selectStoreDetail(int no) {
		
		return dao.selectStoreDetail(no);
	}



	@Override
	public List<Store> storeImgSelect(int no) {
		// TODO Auto-generated method stub
		return dao.storeImgSelect(no);
	}
}
