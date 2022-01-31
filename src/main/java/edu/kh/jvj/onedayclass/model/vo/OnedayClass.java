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
	
	//PRODUCT_IMG_PATH
	private String imgPath;
	//PRODUCT_IMG_NAME
	private String imgName;
	
	//RATING_AVG
	private double ratingAgv;
	
	private List<ProductImage> classImgList;

	public int getClassNo() {
		return classNo;
	}

	public void setClassNo(int classNo) {
		this.classNo = classNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCreateDt() {
		return createDt;
	}

	public void setCreateDt(String createDt) {
		this.createDt = createDt;
	}

	public String getClassDt() {
		return classDt;
	}

	public void setClassDt(String classDt) {
		this.classDt = classDt;
	}

	public int getClassMaxPpl() {
		return classMaxPpl;
	}

	public void setClassMaxPpl(int classMaxPpl) {
		this.classMaxPpl = classMaxPpl;
	}

	public int getClassStatusCd() {
		return classStatusCd;
	}

	public void setClassStatusCd(int classStatusCd) {
		this.classStatusCd = classStatusCd;
	}

	public int getPlaceCd() {
		return placeCd;
	}

	public void setPlaceCd(int placeCd) {
		this.placeCd = placeCd;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getClassStatusName() {
		return classStatusName;
	}

	public void setClassStatusName(String classStatusName) {
		this.classStatusName = classStatusName;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public String getPlaceAddr() {
		return placeAddr;
	}

	public void setPlaceAddr(String placeAddr) {
		this.placeAddr = placeAddr;
	}

	public int getLikecount() {
		return likecount;
	}

	public void setLikecount(int likecount) {
		this.likecount = likecount;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public double getRatingAgv() {
		return ratingAgv;
	}

	public void setRatingAgv(double ratingAgv) {
		this.ratingAgv = ratingAgv;
	}

	public List<ProductImage> getClassImgList() {
		return classImgList;
	}

	public void setClassImgList(List<ProductImage> classImgList) {
		this.classImgList = classImgList;
	}

	public int getProductCd() {
		return productCd;
	}

	@Override
	public String toString() {
		return "OnedayClass [classNo=" + classNo + ", title=" + title + ", price=" + price + ", createDt=" + createDt
				+ ", productCd=" + productCd + ", classDt=" + classDt + ", classMaxPpl=" + classMaxPpl
				+ ", classStatusCd=" + classStatusCd + ", placeCd=" + placeCd + ", contents=" + contents
				+ ", classStatusName=" + classStatusName + ", placeName=" + placeName + ", placeAddr=" + placeAddr
				+ ", likecount=" + likecount + ", imgPath=" + imgPath + ", imgName=" + imgName + ", ratingAgv="
				+ ratingAgv + ", classImgList=" + classImgList + "]";
	}
	
}
