package edu.kh.jvj.payment.model.vo;

public class RegualrPayInfo {
	private  int productCd =1   ;
	private  int productNo    ;
	private  String  productName       ;
	private  String  productOption    ;   
	private  String  tid    ;   
	private  String  partner_order_id    ;   
	private  int amount       ;
     private int  totalPrice       ;
     private int  memberNo    ;
     private boolean shippingAddrEqualMemberAddr;   
     private String  shippingName       ;
     private String  memberId       ;
     private String  shippingAddr       ;
     private String  shippingPhone       ;
     private String  shippingEmail       ;
     private String  shippingMsg       ;
	public int getProductCd() {
		return productCd;
	}
	public void setProductCd(int productCd) {
		this.productCd = productCd;
	}
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
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
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getPartner_order_id() {
		return partner_order_id;
	}
	public void setPartner_order_id(String partner_order_id) {
		this.partner_order_id = partner_order_id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
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
	public boolean isShippingAddrEqualMemberAddr() {
		return shippingAddrEqualMemberAddr;
	}
	public void setShippingAddrEqualMemberAddr(boolean shippingAddrEqualMemberAddr) {
		this.shippingAddrEqualMemberAddr = shippingAddrEqualMemberAddr;
	}
	public String getShippingName() {
		return shippingName;
	}
	public void setShippingName(String shippingName) {
		this.shippingName = shippingName;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getShippingAddr() {
		return shippingAddr;
	}
	public void setShippingAddr(String shippingAddr) {
		this.shippingAddr = shippingAddr;
	}
	public String getShippingPhone() {
		return shippingPhone;
	}
	public void setShippingPhone(String shippingPhone) {
		this.shippingPhone = shippingPhone;
	}
	public String getShippingEmail() {
		return shippingEmail;
	}
	public void setShippingEmail(String shippingEmail) {
		this.shippingEmail = shippingEmail;
	}
	public String getShippingMsg() {
		return shippingMsg;
	}
	public void setShippingMsg(String shippingMsg) {
		this.shippingMsg = shippingMsg;
	}
	@Override
	public String toString() {
		return "RegualrPayInfo [productCd=" + productCd + ", productNo=" + productNo + ", productName=" + productName
				+ ", productOption=" + productOption + ", tid=" + tid + ", partner_order_id=" + partner_order_id
				+ ", amount=" + amount + ", totalPrice=" + totalPrice + ", memberNo=" + memberNo
				+ ", shippingAddrEqualMemberAddr=" + shippingAddrEqualMemberAddr + ", shippingName=" + shippingName
				+ ", memberId=" + memberId + ", shippingAddr=" + shippingAddr + ", shippingPhone=" + shippingPhone
				+ ", shippingEmail=" + shippingEmail + ", shippingMsg=" + shippingMsg + "]";
	}
	
     
}
