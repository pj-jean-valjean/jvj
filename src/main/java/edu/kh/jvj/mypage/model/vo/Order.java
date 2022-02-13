package edu.kh.jvj.mypage.model.vo;

import java.sql.Date;

public class Order {

	private int orderNo; // 구매내역 번호
	private int purchaseNo; // 구매 번호
	private int productNo; // 상품 번호
	private int productAmount; // 상품 구매상품 개수
	private int discount; // 할인율
	private int totalPrice; // 총 결제 금액
	private int memberNo; // 회원 번호
	private Date enrollDate;
	private String memberName;
	private Date edt;
	
	public Order() {}

	public Order(int orderNo, int purchaseNo, int productNo, int productAmount, int discount, int totalPrice,
			int memberNo, Date enrollDate, String memberName, Date edt) {
		super();
		this.orderNo = orderNo;
		this.purchaseNo = purchaseNo;
		this.productNo = productNo;
		this.productAmount = productAmount;
		this.discount = discount;
		this.totalPrice = totalPrice;
		this.memberNo = memberNo;
		this.enrollDate = enrollDate;
		this.memberName = memberName;
		this.edt = edt;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public int getPurchaseNo() {
		return purchaseNo;
	}

	public void setPurchaseNo(int purchaseNo) {
		this.purchaseNo = purchaseNo;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public int getProductAmount() {
		return productAmount;
	}

	public void setProductAmount(int productAmount) {
		this.productAmount = productAmount;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public Date getEdt() {
		return edt;
	}

	public void setEdt(Date edt) {
		this.edt = edt;
	}

	@Override
	public String toString() {
		return "Order [orderNo=" + orderNo + ", purchaseNo=" + purchaseNo + ", productNo=" + productNo
				+ ", productAmount=" + productAmount + ", discount=" + discount + ", totalPrice=" + totalPrice
				+ ", memberNo=" + memberNo + ", enrollDate=" + enrollDate + ", memberName=" + memberName + ", edt="
				+ edt + "]";
	}

	
	
}
