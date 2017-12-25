package com.city.oa.service;

import java.util.List;

import com.city.oa.model.VIPModel;
public interface IVIPService {
	public  int add(VIPModel em) throws Exception;
	public VIPModel  getVIP(int  em) throws Exception;
	public VIPModel  getVIP(String  em) throws Exception;
	public List<VIPModel>getListByall()throws Exception;
	public int getVIPCount() throws Exception;	
	public void delete(int id);
	public void update(VIPModel id);
}
