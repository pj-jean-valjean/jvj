package edu.kh.jvj.admin.model.vo;


public class ProductWrite {
	//공통 product
	private int productNo;
	private String title;
	private int price;
	private String editordata;
	private int writecate;
	
	//클래스 
	private String place; //지점
	private int people; //최대인원
	private String classdate; //일시
	private String starthour; //시작시간
	private String startminute;//시작 분
	private String endhour;//끝 시간
	private String endminute; //끝 분
	
	
	
	
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
	public int getWritecate() {
		return writecate;
	}
	public void setWritecate(int writecate) {
		this.writecate = writecate;
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
	public String getStarthour() {
		return starthour;
	}
	public void setStarthour(String starthour) {
		this.starthour = starthour;
	}
	public String getStartminute() {
		return startminute;
	}
	public void setStartminute(String startminute) {
		this.startminute = startminute;
	}
	public String getEndhour() {
		return endhour;
	}
	public void setEndhour(String endhour) {
		this.endhour = endhour;
	}
	public String getEndminute() {
		return endminute;
	}
	public void setEndminute(String endminute) {
		this.endminute = endminute;
	}
	@Override
	public String toString() {
		return "ProductWrite [productNo=" + productNo + ", title=" + title + ", price=" + price + ", editordata="
				+ editordata + ", writecate=" + writecate  + ", place=" + place + ", people="
				+ people + ", classdate=" + classdate + ", starthour=" + starthour + ", startminute=" + startminute
				+ ", endhour=" + endhour + ", endminute=" + endminute + "]";
	}
	
	
	
}
