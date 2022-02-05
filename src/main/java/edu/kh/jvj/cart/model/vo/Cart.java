package edu.kh.jvj.cart.model.vo;

public class Cart {

	private int cartNo; // 장바구니 번호
	private int productNo; // 상품번호
	private int addq; // 수량
	private int memberNo; // 회원번호
	private int opt; // 옵션 번호
	private int optq; // 옵션 갯수

	private int[] optSetNum = { 1348, 1350, 1351 }; // 추가옵션 번호

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

	public int getCartNo() {
		return cartNo;
	}

	public void setCartNo(int cartNo) {
		this.cartNo = cartNo;
	}

	public int getOpt() {
		return opt;
	}

	public void setOpt(int opt) {
		this.opt = opt;
	}

	public int getOptq() {
		return optq;
	}

	public void setOptq(int optq) {
		this.optq = optq;
	}

	public int[] getOptSetNum() {
		return optSetNum;
	}

	public void setOptSetNum(int[] optSetNum) {
		this.optSetNum = optSetNum;
	}

}
