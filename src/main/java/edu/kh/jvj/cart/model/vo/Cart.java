package edu.kh.jvj.cart.model.vo;

public class Cart {
	private int productNo; // 상품번호
	private int addq; // 수량
	private int memberNo; // 회원번호
	public Cart() {
		// TODO Auto-generated constructor stub
	}
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	public int getAddq() {
		return addq;
	}
	public void setAddq(int addq) {
		this.addq = addq;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	
}
