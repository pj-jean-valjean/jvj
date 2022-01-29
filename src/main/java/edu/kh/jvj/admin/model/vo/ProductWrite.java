package edu.kh.jvj.admin.model.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class ProductWrite {
	//공통 product
	private int productNo;
	private String title;
	private int price;
	private String editordata;
	
	
	//클래스 
	private int classNo; //
	private String place; //지점
	private int people; //최대인원
	private String classdate; //일시
	
	//상품
	private int stock;
	private List<MultipartFile> imgList;
	private int writecate;
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getEditordata() {
		return editordata;
	}
	public void setEditordata(String editordata) {
		this.editordata = editordata;
	}
	public int getClassNo() {
		return classNo;
	}
	public void setClassNo(int classNo) {
		this.classNo = classNo;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public int getPeople() {
		return people;
	}
	public void setPeople(int people) {
		this.people = people;
	}
	public String getClassdate() {
		return classdate;
	}
	public void setClassdate(String classdate) {
		this.classdate = classdate;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public List<MultipartFile> getImgList() {
		return imgList;
	}
	public void setImgList(List<MultipartFile> imgList) {
		this.imgList = imgList;
	}
	public int getWritecate() {
		return writecate;
	}
	public void setWritecate(int writecate) {
		this.writecate = writecate;
	}
	
	
	

	
}
