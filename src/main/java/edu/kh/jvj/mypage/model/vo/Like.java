package edu.kh.jvj.mypage.model.vo;


public class Like {
	
	private int productNo;
	private int memberNo;
	
	private String productName;
	private int productPrice;
	private int productCode;
	
	private int productImageNo;
	private String productImagePath;
	private String productImageName;
	private int productImageLevel;
	
	public Like() {}

	public Like(int productNo, int memberNo, String productName, int productPrice, int productCode, int productImageNo,
			String productImagePath, String productImageName, int productImageLevel) {
		super();
		this.productNo = productNo;
		this.memberNo = memberNo;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productCode = productCode;
		this.productImageNo = productImageNo;
		this.productImagePath = productImagePath;
		this.productImageName = productImageName;
		this.productImageLevel = productImageLevel;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductCode() {
		return productCode;
	}

	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}

	public int getProductImageNo() {
		return productImageNo;
	}

	public void setProductImageNo(int productImageNo) {
		this.productImageNo = productImageNo;
	}

	public String getProductImagePath() {
		return productImagePath;
	}

	public void setProductImagePath(String productImagePath) {
		this.productImagePath = productImagePath;
	}

	public String getProductImageName() {
		return productImageName;
	}

	public void setProductImageName(String productImageName) {
		this.productImageName = productImageName;
	}

	public int getProductImageLevel() {
		return productImageLevel;
	}

	public void setProductImageLevel(int productImageLevel) {
		this.productImageLevel = productImageLevel;
	}

	@Override
	public String toString() {
		return "Like [productNo=" + productNo + ", memberNo=" + memberNo + ", productName=" + productName
				+ ", productPrice=" + productPrice + ", productCode=" + productCode + ", productImageNo="
				+ productImageNo + ", productImagePath=" + productImagePath + ", productImageName=" + productImageName
				+ ", productImageLevel=" + productImageLevel + "]";
	}

	

	
	

		
}
