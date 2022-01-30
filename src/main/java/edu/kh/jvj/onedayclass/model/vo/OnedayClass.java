package edu.kh.jvj.onedayclass.model.vo;

import java.util.List;

public class OnedayClass {
	//PROCUT_NO
	private int classNo;
	
	//PRODUCT_NM
	private String title;
	
	//PRODUCT_PRICE
	private int price;
	
	//CREATE_DT
	private String createDt;
	
	//PRODUCT_CD
	private final int productCd = 3;
	
	//--클래스 상세
	//CLASS_DT
	private String classDt;
	//CLASS_MAX_PPL
	private int classMaxPpl;
	//CLASS_STATUS_CD
	private int classStatusCd;
	//PLACE_CODE
	private int placeCd;
	//CLASS_EXP
	private String contents;
	//CLASS_STATUS_NM
	private String classStatusName;
	//PLACE_NM
	private String placeName;
	//PLACE_ADDR
	private String placeAddr;
	
	//LIKECOUNT
	private int likecount;
	
	//RATING_AVG
	private double ratingAgv;
	
	private List<ProductImage> classImgList;
	
	
	
}
