package com.city.oa.model;
public class PrivilegeModel {
	private int pr_id;
	private int discount;
	private String p_time;
	private String p_end;
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public String getP_time() {
		return p_time;
	}
	public void setP_time(String p_time) {
		this.p_time = p_time;
	}
	public String getP_end() {
		return p_end;
	}
	public void setP_end(String p_end) {
		this.p_end = p_end;
	}
	public int getPr_id() {
		return pr_id;
	}
	public void setPr_id(int pr_id) {
		this.pr_id = pr_id;
	}
}
