package com.city.oa.dao;

import java.util.List;


import com.city.oa.model.UsersModel;
public interface IUsersDao {
	 int  create(UsersModel em) throws Exception;
	 void delete(int code) throws Exception;
	 void update(UsersModel em) throws Exception;
	 List<UsersModel> getListByAll() throws Exception;
	UsersModel getUsers(int uid) throws Exception;
	UsersModel getUsersbyname(String name) throws Exception;
}
