package com.city.oa.service.impl;
import java.util.List;
import com.city.oa.factory.DaoFactory;
import com.city.oa.model.Vege_FormModel;
import com.city.oa.service.IVege_FormService;
public class Vege_FormServiceImpl implements IVege_FormService {

	@Override
	public void add(Vege_FormModel em) throws Exception {
		// TODO Auto-generated method stub
		DaoFactory.createVege_formDao().create(em);
	}
	@Override
	public int getVege_formCount(String name) throws Exception {
		List <Vege_FormModel>list = DaoFactory.createVege_formDao().getListByAll(name);
		return list.size();
	}
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		try {
			DaoFactory.createVege_formDao().delete(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public List<Vege_FormModel> getListByall(String name) throws Exception {
		// TODO Auto-generated method stub
		List <Vege_FormModel>list = DaoFactory.createVege_formDao().getListByAll(name);
		return list;
	}
	@Override
	public float counter(String name) throws Exception {
		// TODO Auto-generated method stub
		return DaoFactory.createVege_formDao().counter(name);
	}
}
