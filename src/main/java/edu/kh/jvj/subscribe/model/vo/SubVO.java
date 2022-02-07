package edu.kh.jvj.subscribe.model.vo;

public class SubVO {
	
	//PROCUT_NO
	private int productNo;
	
	//PRODUCT_NM
	private String title;
		
	//PRODUCT_PRICE
	private int price;
	
	//CREATE_DT
	private String createDt;
	
	//PRODUCT_CD
	private final int productCd = 2;
	
	// 구독 상세
	// 결제 종류 SUB_PAY_NO
	private int subPayNo;
	// 결제 종류 SUB_PAY_NM
	private String subPayName;
	
//	// 구독 빵 종류 SUB_TASTE_NO
//	private int subBreadNo;
//	// 구독 빵 맛이름 SUB_TASTE_NM
//	private String subBreadName;
	
	// 구독 맛 종류 SUB_TASTE_NO
	private int subTasteNo;
	// 구독 맛 맛이름 SUB_TASTE_NM
	private String subTasteName;
	
	// 커피 옵션 번호 COFFEE_OPTION_NO
	private int coffeeOptionNo;
	// 커피 용량 COFFEE_OPTION
	private int coffeeOption;
		
	
	//LIKECOUNT
	private int likecount;
	//LIKEDONE
	private int likedone;
	//PRODUCT_IMG_PATH
	private String imgPathName;
	
	//RATING_AVG
	private double ratingAgv;

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
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

	public int getSubPayNo() {
		return subPayNo;
	}

	public void setSubPayNo(int subPayNo) {
		this.subPayNo = subPayNo;
	}

	public String getSubPayName() {
		return subPayName;
	}

	public void setSubPayName(String subPayName) {
		this.subPayName = subPayName;
	}

	public int getSubTasteNo() {
		return subTasteNo;
	}

	public void setSubTasteNo(int subTasteNo) {
		this.subTasteNo = subTasteNo;
	}

	public String getSubTasteName() {
		return subTasteName;
	}

	public void setSubTasteName(String subTasteName) {
		this.subTasteName = subTasteName;
	}

	public int getCoffeeOptionNo() {
		return coffeeOptionNo;
	}

	public void setCoffeeOptionNo(int coffeeOptionNo) {
		this.coffeeOptionNo = coffeeOptionNo;
	}

	public int getCoffeeOption() {
		return coffeeOption;
	}

	public void setCoffeeOption(int coffeeOption) {
		this.coffeeOption = coffeeOption;
	}

	public int getLikecount() {
		return likecount;
	}

	public void setLikecount(int likecount) {
		this.likecount = likecount;
	}

	public int getLikedone() {
		return likedone;
	}

	public void setLikedone(int likedone) {
		this.likedone = likedone;
	}

	public String getImgPathName() {
		return imgPathName;
	}

	public void setImgPathName(String imgPathName) {
		this.imgPathName = imgPathName;
	}

	public double getRatingAgv() {
		return ratingAgv;
	}

	public void setRatingAgv(double ratingAgv) {
		this.ratingAgv = ratingAgv;
	}

	public int getProductCd() {
		return productCd;
	}

	@Override
	public String toString() {
		return "SubVO [productNo=" + productNo + ", title=" + title + ", price=" + price + ", createDt=" + createDt
				+ ", productCd=" + productCd + ", subPayNo=" + subPayNo + ", subPayName=" + subPayName + ", subTasteNo="
				+ subTasteNo + ", subTasteName=" + subTasteName + ", coffeeOptionNo=" + coffeeOptionNo
				+ ", coffeeOption=" + coffeeOption + ", likecount=" + likecount + ", likedone=" + likedone
				+ ", imgPathName=" + imgPathName + ", ratingAgv=" + ratingAgv + "]";
	}
	
	
	
	
}
