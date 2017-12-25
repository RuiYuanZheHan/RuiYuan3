package com.city.oa.service.impl;
import java.util.List;
import com.city.oa.dao.IPrivilegeDao;
import com.city.oa.factory.DaoFactory;
import com.city.oa.model.PrivilegeModel;
import com.city.oa.service.IPrivilegeService;
public class PrivilegeServiceImpl implements IPrivilegeService {
	@Override
	public int add(PrivilegeModel em) throws Exception {
		// TODO Auto-generated method stub
		IPrivilegeDao aa = DaoFactory.createPrivilegeDao();
		int i =	aa.create(em);
		return i;
	}



	@Override
	public List<PrivilegeModel> getListByall() throws Exception {
		List<PrivilegeModel> list = DaoFactory.createPrivilegeDao().getListByAll() ;
		return list;
	}

	@Override
	public int getPrivilegeCount() throws Exception {
		List<PrivilegeModel> list = DaoFactory.createPrivilegeDao().getListByAll() ;
		return list.size();
	}



	@Override
	public PrivilegeModel getPriv(int em) throws Exception {
		return DaoFactory.createPrivilegeDao().getPriv(em);

	}



	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		try {
			DaoFactory.createPrivilegeDao().delete(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	@Override
	public void update(PrivilegeModel em) {
		// TODO Auto-generated method stub
		try {
			DaoFactory.createPrivilegeDao().update(em);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
