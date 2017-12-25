package com.city.oa.service;

import java.util.List;

import com.city.oa.model.PrivilegeModel;

public interface IPrivilegeService {
	public  int add(PrivilegeModel em) throws Exception;
	public PrivilegeModel  getPriv(int em) throws Exception;
	public List<PrivilegeModel>getListByall()throws Exception;
    public int getPrivilegeCount() throws Exception;	 
    public void delete(int id);
    public void update(PrivilegeModel id);
}
