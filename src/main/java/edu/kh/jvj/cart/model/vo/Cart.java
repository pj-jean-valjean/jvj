package edu.kh.jvj.cart.model.vo;

import java.util.Arrays;
import java.util.List;

public class Cart {

	private int cartNo; // 장바구니 번호
	private int productNo; // 상품번호
	
	private int addq; // 수량
	private int memberNo; // 회원번호
	private int opt; // 옵션 번호
	private int optq; // 옵션 갯수

	private int[] optSetNum = { 1348, 1350, 1351 }; // 추가옵션 번호

	private String productName; // 상품이름
	private int price; // 상품 가격
	private List<Integer> optList ; //옵션리스트
	
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

	public List<Integer> getOptList() {
		return optList;
	}

	public void setOptList(List<Integer> optList) {
		this.optList = optList;
	}

	@Override
	public String toString() {
		return "Cart [cartNo=" + cartNo + ", productNo=" + productNo + ", addq=" + addq + ", memberNo=" + memberNo
				+ ", opt=" + opt + ", optq=" + optq + ", optSetNum=" + Arrays.toString(optSetNum) + ", productName="
				+ productName + ", price=" + price + ", optList=" + optList + "]";
	}

}
