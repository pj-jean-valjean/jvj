package edu.kh.jvj.store.model.service;

import java.util.List;

import edu.kh.jvj.store.model.vo.Pagination;
import edu.kh.jvj.store.model.vo.Search;
import edu.kh.jvj.store.model.vo.Store;

public interface StoreService {

	List<Store> selectStoreList(Pagination pagination, Search search);

	Pagination getPagination(int cp, Search search);

	Store selectStoreDetail(int no);

	List<Store> storeImgSelect(int no);

}
