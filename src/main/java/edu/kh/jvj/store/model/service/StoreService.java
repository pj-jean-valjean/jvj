package edu.kh.jvj.store.model.service;

import java.util.List;

import edu.kh.jvj.store.model.vo.Pagination;
import edu.kh.jvj.store.model.vo.Store;

public interface StoreService {

	List<Store> selectStoreList(Pagination pagination);

	Pagination getPagination(int cp);

}
