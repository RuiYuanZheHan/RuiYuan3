package com.city.oa.service.impl;
import java.util.List;
import com.city.oa.factory.DaoFactory;
import com.city.oa.model.VegetableModel;
import com.city.oa.service.IVegetableService;
public class VegetableServiceImpl implements IVegetableService {
	@Override
	public int   add(VegetableModel em) throws Exception {
		// TODO Auto-generated method stub
		 int i  = DaoFactory.createVegetableDao().create(em);
		 return  i;
		 
	}
	@Override
	public VegetableModel getVegetable(String em) throws Exception {
		// TODO Auto-generated method stub
		return DaoFactory.createVegetableDao().getVegetable(em);
	}
	@Override
	public int getVegetableCount() throws Exception {
		// TODO Auto-generated method stub
		return DaoFactory.createVegetableDao().getListByAll().size();
	}
	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		try {
			DaoFactory.createVegetableDao().delete(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public List<VegetableModel> getListByall() throws Exception {
		// TODO Auto-generated method stub
		return DaoFactory.createVegetableDao().getListByAll();
	}
	@Override
	public void update(VegetableModel id) {
		// TODO Auto-generated method stub
		try {
			DaoFactory.createVegetableDao().update(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


