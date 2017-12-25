package com.city.oa.model;
public class VIPModel {

	private int vip_ID;
	private String name=null;
	private String phone=null;
	private int privilege_cir;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getVip_ID() {
		return vip_ID;
	}
	public void setVip_ID(int vip_ID) {
		this.vip_ID = vip_ID;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getPrivilege_cir() {
		return privilege_cir;
	}
	public void setPrivilege_cir(int privilege_cir) {
		this.privilege_cir = privilege_cir;
	}

}
