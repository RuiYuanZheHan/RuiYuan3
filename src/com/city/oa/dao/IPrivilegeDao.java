package com.city.oa.dao;

import java.util.List;

import com.city.oa.model.PrivilegeModel;

public interface  IPrivilegeDao {
	int create(PrivilegeModel em) throws Exception;
	PrivilegeModel getPriv(int id) throws Exception;
	List<PrivilegeModel> getListByAll() throws Exception;
	void delete(int  id) throws Exception;
	void update(PrivilegeModel em) throws Exception;
}
