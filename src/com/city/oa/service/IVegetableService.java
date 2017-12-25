package com.city.oa.service;
import java.util.List;
import com.city.oa.model.VegetableModel;
public interface IVegetableService {
	public  int add(VegetableModel em) throws Exception;
	public VegetableModel  getVegetable(String vip) throws Exception;
	public List<VegetableModel>getListByall()throws Exception;
	public int getVegetableCount() throws Exception;	
	public void delete(String id);
	public void update(VegetableModel id);
}
