package edu.kh.jvj.mypage.model.vo;

import java.sql.Date;

public class Coupon {
	
	private int couponNo; // 쿠폰 번호
	private String couponName; // 쿠폰 이름
	private int discountPer; // 할인률
	
	private Date provideDate; // 발급일
	private Date expireDate; // 만료일
	
	private int couponStatusCode; // 쿠폰상태코드
	private int memberNo; // 회원 번호
	
	public Coupon() {}
	
	public int getCouponNo() {
		return couponNo;
	}
	public void setCouponNo(int couponNo) {
		this.couponNo = couponNo;
	}
	public String getCouponName() {
		return couponName;
	}
	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}
	public int getDiscountPer() {
		return discountPer;
	}
	public void setDiscountPer(int discountPer) {
		this.discountPer = discountPer;
	}
	public Date getProvideDate() {
		return provideDate;
	}
	public void setProvideDate(Date provideDate) {
		this.provideDate = provideDate;
	}
	public Date getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}
	public int getCouponStatusCode() {
		return couponStatusCode;
	}
	public void setCouponStatusCode(int couponStatusCode) {
		this.couponStatusCode = couponStatusCode;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public Coupon(int couponNo, String couponName, int discountPer, Date provideDate, Date expireDate,
			int couponStatusCode, int memberNo) {
		super();
		this.couponNo = couponNo;
		this.couponName = couponName;
		this.discountPer = discountPer;
		this.provideDate = provideDate;
		this.expireDate = expireDate;
		this.couponStatusCode = couponStatusCode;
		this.memberNo = memberNo;
	}
	@Override
	public String toString() {
		return "Coupon [couponNo=" + couponNo + ", couponName=" + couponName + ", discountPer=" + discountPer
				+ ", provideDate=" + provideDate + ", expireDate=" + expireDate + ", couponStatusCode="
				+ couponStatusCode + ", memberNo=" + memberNo + "]";
	}
	
	
	
	
}
