package edu.kh.jvj.admin.model.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class ProductWrite {
	private String title;
	private int price;
	private String place;
	private int people;
	private int stock;
	private String editordata;
	private String classdate;
	private List<MultipartFile> imgList;
	private int writecate;
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
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getEditordata() {
		return editordata;
	}
	public void setEditordata(String editordata) {
		this.editordata = editordata;
	}
	public String getClassdate() {
		return classdate;
	}
	public void setClassdate(String classdate) {
		this.classdate = classdate;
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
	@Override
	public String toString() {
		return "ProductWrite [title=" + title + ", price=" + price + ", place=" + place + ", people=" + people
				+ ", stock=" + stock + ", editordata=" + editordata + ", classdate=" + classdate + ", imgList="
				+ imgList + ", writecate=" + writecate + "]";
	}
	
	
	
	
}
