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
	
	// 이메일 인증
	private String authKey;
	private int emailStatusCode;
	
	
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


	public String getAuthKey() {
		return authKey;
	}


	public void setAuthKey(String authKey) {
		this.authKey = authKey;
	}


	public int getEmailStatusCode() {
		return emailStatusCode;
	}


	public void setEmailStatusCode(int emailStatusCode) {
		this.emailStatusCode = emailStatusCode;
	}


	
	
	
	
	
	
	
	
}
