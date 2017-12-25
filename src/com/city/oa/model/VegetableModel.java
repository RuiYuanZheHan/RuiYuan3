package com.city.oa.model;

import java.sql.Blob;
public class VegetableModel {
	private  String vname;
	private PrivilegeModel  pr_id;
	private float vprice;
	private String vkind;
	private Blob photo;
	private  String phototype;
	
	public String getPhototype() {
		return phototype;
	}
	public void setPhototype(String phototype) {
		this.phototype = phototype;
	}
	private String  vege_style;

	public String getVname() {
		return vname;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}
	public PrivilegeModel getPr_id() {
		return pr_id;
	}
	public void setPr_id(PrivilegeModel pr_id) {
		this.pr_id = pr_id;
	}
	public float getVprice() {
		return vprice;
	}
	public void setVprice(float vprice) {
		this.vprice = vprice;
	}
	public String getVkind() {
		return vkind;
	}
	public void setVkind(String vkind) {
		this.vkind = vkind;
	}
	public Blob getPhoto() {
		return photo;
	}
	public void setPhoto(Blob photo) {
		this.photo = photo;
	}
	public String getVege_style() {
		return vege_style;
	}
	public void setVege_style(String vege_style) {
		this.vege_style = vege_style;
	}

}
