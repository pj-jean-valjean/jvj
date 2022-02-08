package edu.kh.jvj.admin.model.vo;

import java.util.List;

import edu.kh.jvj.onedayclass.model.vo.ProductImage;

public class SubsInfo extends SimpleProduct{
	
	private List<ProductImage> classImgList;

	public List<ProductImage> getClassImgList() {
		return classImgList;
	}
	public void setClassImgList(List<ProductImage> classImgList) {
		this.classImgList = classImgList;
	}
	@Override
	public String toString() {
		return "SubsInfo [classImgList=" + classImgList + "]";
	}
}
