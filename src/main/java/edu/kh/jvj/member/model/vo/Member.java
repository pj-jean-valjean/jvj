package edu.kh.jvj.member.model.vo;

import java.sql.Date;

public class Member {
	
	private int memberNo;
	private String memberEmail;
	private String memberPw;
	private String memberNickname;
	private String memberName;
	private String memberPhone;
	private String memberAddress;
	private Date enrollDate;
	private int statusCode;
	private int gradeCode;
	
	
	// 로그인 api용 변수
	private String service;
	private String id;
	
	
	
	public Member() {}

	// getter/setter
	
	public int getMemberNo() {
		return memberNo;
	}


	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}


	public String getMemberEmail() {
		return memberEmail;
	}


	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}


	public String getMemberPw() {
		return memberPw;
	}


	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}


	public String getMemberNickname() {
		return memberNickname;
	}


	public void setMemberNickname(String memberNickname) {
		this.memberNickname = memberNickname;
	}


	public String getMemberName() {
		return memberName;
	}


	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}


	public String getMemberPhone() {
		return memberPhone;
	}


	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}


	public String getMemberAddress() {
		return memberAddress;
	}


	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}


	public Date getEnrollDate() {
		return enrollDate;
	}


	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public int getGradeCode() {
		return gradeCode;
	}

	public void setGradeCode(int gradeCode) {
		this.gradeCode = gradeCode;
	}

	
	
	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Member [memberNo=" + memberNo + ", memberEmail=" + memberEmail + ", memberPw=" + memberPw
				+ ", memberNickname=" + memberNickname + ", memberName=" + memberName + ", memberPhone=" + memberPhone
				+ ", memberAddress=" + memberAddress + ", enrollDate=" + enrollDate + ", statusCode=" + statusCode
				+ ", gradeCode=" + gradeCode + ", service=" + service + ", id=" + id + "]";
	}
	
	
	
	
}
