package edu.kh.jvj.payment.model.vo;

public class Payment {
	
	//1. 일반 정보
	//PURCHASE_NO
	private int purchaseNo;
	private int orderNo;
	
	//PRODUCT_CD
	private int productCd;
	
	//TOTAL_PRICE
	private int totalPrice;
	
	//PAYMENT_STATUS
	private String paymentStatus;
	
	//PAYMENT_DT
	private String paymentDt;
	
	//REFUND_DT
	private String refundDt;
	
	//MEMBER_NO
	private int memberNo;
	
	private int productNo;
	
	private String productName;
	
	private String productOption;
	
	private int amount;
	
	private String store_imp_uid;
	
	
	
	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public String getStore_imp_uid() {
		return store_imp_uid;
	}

	public void setStore_imp_uid(String store_imp_uid) {
		this.store_imp_uid = store_imp_uid;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public int getPurchaseNo() {
		return purchaseNo;
	}

	public void setPurchaseNo(int purchaseNo) {
		this.purchaseNo = purchaseNo;
	}

	public int getProductCd() {
		return productCd;
	}

	public void setProductCd(int productCd) {
		this.productCd = productCd;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getPaymentDt() {
		return paymentDt;
	}

	public void setPaymentDt(String paymentDt) {
		this.paymentDt = paymentDt;
	}

	public String getRefundDt() {
		return refundDt;
	}

	public void setRefundDt(String refundDt) {
		this.refundDt = refundDt;
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

	public String getProductOption() {
		return productOption;
	}

	public void setProductOption(String productOption) {
		this.productOption = productOption;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Payment [purchaseNo=" + purchaseNo + ", productCd=" + productCd + ", totalPrice=" + totalPrice
				+ ", paymentStatus=" + paymentStatus + ", paymentDt=" + paymentDt + ", refundDt=" + refundDt
				+ ", memberNo=" + memberNo + ", productName=" + productName + ", productOption=" + productOption
				+ ", amount=" + amount + "]";
	}
	
}
