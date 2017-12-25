package com.city.oa.service.impl;
import java.util.List;
import com.city.oa.factory.DaoFactory;
import com.city.oa.model.UsersModel;
import com.city.oa.service.IUsersService;
public class UsersServiceImpl implements IUsersService {
	@Override
	public int add(UsersModel em) throws Exception {
		// TODO Auto-generated method stub
		int i = DaoFactory.createUsersDao().create(em);;
		return i;
	}
	@Override
	public UsersModel getUser(int id) throws Exception {
		return DaoFactory.createUsersDao().getUsers(id);
	}
	@Override
	public List<UsersModel> getListByall() throws Exception {
		// TODO Auto-generated method stub
		List<UsersModel> list = DaoFactory.createUsersDao().getListByAll() ;
		return list;
	}
	@Override
	public int getUserCount() throws Exception {
		List<UsersModel> list = DaoFactory.createUsersDao().getListByAll() ;	  
		return list.size();
	}
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		try {
			DaoFactory.createUsersDao().delete(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void update(UsersModel id) {
		// TODO Auto-generated method stub
		try {
			DaoFactory.createUsersDao().update(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean validate(String name, String password) throws Exception {
		//		boolean result=false;
		//		UsersModel um=DaoFactory.createUsersDao().getUsers(name);
		//		System.out.println(um+"dsdsds");
		//		if(um!=null&&um.getPassword()!=null)
		//		{
		//			if(um.getPassword().equals(password))
		//				result=true;
		//		}
		//		return result;
		return true;
	}
	@Override
	public UsersModel getUserByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return DaoFactory.createUsersDao().getUsersbyname(name);
	}
}
