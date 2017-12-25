package com.city.oa.dao;

import java.util.List;

import com.city.oa.model.VegetableModel;


public interface IVegeatableDao {
	int create(VegetableModel em) throws Exception;
	VegetableModel getVegetable(String code) throws Exception;
	List<VegetableModel> getListByAll() throws Exception;
	void delete(String name) throws Exception;
	void update(VegetableModel em) throws Exception;
}
