package com.city.oa.service;
import java.util.List;


import com.city.oa.model.UsersModel;
public interface  IUsersService {
	public  int add(UsersModel em) throws Exception;
	public List<UsersModel>getListByall()throws Exception;
	public int getUserCount() throws Exception;	  
	public void delete(int id);
	public void update(UsersModel id);
	boolean validate(String name, String password) throws Exception;
	UsersModel getUser(int id) throws Exception;
	UsersModel getUserByName(String name) throws Exception;
}
