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
	
	// 구독 빵 종류 STORE_BREAD_TASTE_NO
	private int subBreadNo;
	// 1.식빵 2.바게트
	
	// 구독 맛 종류 SUB_TASTE_NO
	private int subTasteNo;
	private String subTasteName;
	
	
	// 커피 옵션 번호 COFFEE_OPTION_NO
	private int coffeeOptionNo;
	private int coffeeOptionName;
	
	// 결제 종류 SUB_PAY_NO
	private int subPayNo;
	private String subPayName;
	
	// 배송일
	private int subDeliveryNo;
	private int subDeliveryName;
	
	
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

	public int getSubBreadNo() {
		return subBreadNo;
	}

	public void setSubBreadNo(int subBreadNo) {
		this.subBreadNo = subBreadNo;
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

	public int getCoffeeOptionName() {
		return coffeeOptionName;
	}

	public void setCoffeeOptionName(int coffeeOptionName) {
		this.coffeeOptionName = coffeeOptionName;
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

	public int getSubDeliveryNo() {
		return subDeliveryNo;
	}

	public void setSubDeliveryNo(int subDeliveryNo) {
		this.subDeliveryNo = subDeliveryNo;
	}

	public int getSubDeliveryName() {
		return subDeliveryName;
	}

	public void setSubDeliveryName(int subDeliveryName) {
		this.subDeliveryName = subDeliveryName;
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
				+ ", productCd=" + productCd + ", subBreadNo=" + subBreadNo + ", subTasteNo=" + subTasteNo
				+ ", subTasteName=" + subTasteName + ", coffeeOptionNo=" + coffeeOptionNo + ", coffeeOptionName="
				+ coffeeOptionName + ", subPayNo=" + subPayNo + ", subPayName=" + subPayName + ", subDeliveryNo="
				+ subDeliveryNo + ", subDeliveryName=" + subDeliveryName + ", likecount=" + likecount + ", likedone="
				+ likedone + ", imgPathName=" + imgPathName + ", ratingAgv=" + ratingAgv + "]";
	}


	
	
	
	
	
}
