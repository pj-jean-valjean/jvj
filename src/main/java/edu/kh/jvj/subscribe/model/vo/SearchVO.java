package edu.kh.jvj.subscribe.model.vo;

public class SearchVO {
	// 담아올 값
	// 상품명 금액 
	
	
	private String productName;
	private int price;
	
	
	// + 인풋 값
	private String sv;

	
	public SearchVO() {}

	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getSv() {
		return sv;
	}


	public void setSv(String sv) {
		this.sv = sv;
	}

	@Override
	public String toString() {
		return "SearchVO [productName=" + productName + ", price=" + price + ", sv=" + sv + "]";
	}
	
	
}
