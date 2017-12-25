package com.city.oa.factory;

import com.city.oa.service.IPrivilegeService;
import com.city.oa.service.IUsersService;
import com.city.oa.service.IVIPService;
import com.city.oa.service.IVege_FormService;
import com.city.oa.service.IVegetableService;
import com.city.oa.service.impl.PrivilegeServiceImpl;
import com.city.oa.service.impl.UsersServiceImpl;
import com.city.oa.service.impl.VIPServiceImpl;
import com.city.oa.service.impl.Vege_FormServiceImpl;
import com.city.oa.service.impl.VegetableServiceImpl;

public class ServiceFactory {
	public static IUsersService createUsersService(){
		return new UsersServiceImpl();
	}
	public static IVIPService createVIPService(){
		return new VIPServiceImpl();
	}
	public static IVegetableService createVegetableService(){
		return  new  VegetableServiceImpl();
	}
	public static IVege_FormService createVege_FormService(){
		return  new  Vege_FormServiceImpl();
	}
	public static IPrivilegeService createPrivilegeService(){
		return new PrivilegeServiceImpl();
	}
	
}
