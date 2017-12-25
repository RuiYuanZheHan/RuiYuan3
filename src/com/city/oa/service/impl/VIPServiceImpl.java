package com.city.oa.service.impl;
import java.util.List;
import com.city.oa.dao.IVIPDao;
import com.city.oa.factory.DaoFactory;
import com.city.oa.model.VIPModel;
import com.city.oa.service.IVIPService;

public class VIPServiceImpl implements IVIPService {
	@Override
	public int add(VIPModel em) throws Exception {
		IVIPDao aa = DaoFactory.createVIPDao();
		int i = aa.create(em);
		return i;
		
	}
	@Override
	public VIPModel getVIP(int em) throws Exception {
		return DaoFactory.createVIPDao().getVIP(em);
	}
	@Override
	public List<VIPModel> getListByall() throws Exception {
		List<VIPModel> list = DaoFactory.createVIPDao().getListByAll() ;	  
		return list;
	}
	@Override
	public int getVIPCount() throws Exception {
		List<VIPModel> list = DaoFactory.createVIPDao().getListByAll() ;	  
		return list.size();
	}
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
				try {
					DaoFactory.createVIPDao().delete(id);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
	}
	@Override
	public void update(VIPModel id) {
		// TODO Auto-generated method stub
		try {
			DaoFactory.createVIPDao().update(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public VIPModel getVIP(String em) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
