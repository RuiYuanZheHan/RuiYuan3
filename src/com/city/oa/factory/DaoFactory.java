package com.city.oa.factory;

import com.city.oa.dao.IPrivilegeDao;
import com.city.oa.dao.IUsersDao;
import com.city.oa.dao.IVIPDao;
import com.city.oa.dao.IVege_FormDao;
import com.city.oa.dao.IVegeatableDao;
import com.city.oa.dao.impl.PrivilegeDaoImpl;
import com.city.oa.dao.impl.UsersDaoImpl;
import com.city.oa.dao.impl.VIPDaoImpl;
import com.city.oa.dao.impl.Vege_FormDaoImpl;
import com.city.oa.dao.impl.VegetableDaoImpl;
public class DaoFactory {

	public static IUsersDao createUsersDao(){
		return new UsersDaoImpl();
	}
	public static IPrivilegeDao createPrivilegeDao(){
		return new PrivilegeDaoImpl();
	}
	public static IVege_FormDao createVege_formDao(){
		return new Vege_FormDaoImpl();
	}
	public static IVegeatableDao createVegetableDao(){
		return new VegetableDaoImpl();
	}
	public static IVIPDao createVIPDao(){
		return new VIPDaoImpl();
	}
}
