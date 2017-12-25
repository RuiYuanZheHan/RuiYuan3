package com.city.oa.model;
public class Vege_FormModel {
	private String  consumer;
	private VegetableModel  vegemodel;
	private VIPModel vipmodel;
	private String eattime;
	private int vegebillid = 0;
	private float statitics;
	
	public float getStatitics() {
		return statitics;
	}


	public void setStatitics(float statitics) {
		this.statitics = statitics;
	}


	public int getVegebillid() {
		return vegebillid;
	}


	public void setVegebillid(int vegebillid) {
		this.vegebillid = vegebillid;
	}


	public VegetableModel getVegemodel() {
		return vegemodel;
	}


	public void setVegemodel(VegetableModel vegemodel) {
		this.vegemodel = vegemodel;
	}
	public VIPModel getVipmodel() {
		return vipmodel;
	}
	public void setVipmodel(VIPModel vipmodel) {
		this.vipmodel = vipmodel;
	}
	public String getEattime() {
		return eattime;
	}

	public void setEattime(String date) {

		this.eattime = date;
	}

	public String getConsumer() {
		return consumer;
	}
	public void setConsumer(String consumer) {

		this.consumer = consumer;
	}

}
