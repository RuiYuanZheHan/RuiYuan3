package com.city.oa.dao;

import java.util.List;


import com.city.oa.model.VIPModel;

public interface IVIPDao {
	int create(VIPModel em) throws Exception;
	void delete(int code) throws Exception;
	void update(VIPModel em) throws Exception;
	public VIPModel getVIP(int code) throws Exception;
	List<VIPModel> getListByAll() throws Exception;
	public VIPModel getVIP(String name) throws Exception ;
}
