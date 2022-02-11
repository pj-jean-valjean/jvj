package edu.kh.jvj.review.model.vo;

public class Review {
	
	private int orderNo; // 주문번호
	private String title; // 리뷰제목
	private int point; // 평점
	private String content; // 내용
	private String date; // 날짜
	private int memberNo; // 회원번호
	private int categoryNo; // 카테고리 번호
	
	public Review() {
		// TODO Auto-generated constructor stub
	}
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public int getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}
	@Override
	public String toString() {
		return "Review [orderNo=" + orderNo + ", title=" + title + ", point=" + point + ", content=" + content
				+ ", date=" + date + ", memberNo=" + memberNo + ", categoryNo=" + categoryNo + "]";
	}
	
	}
