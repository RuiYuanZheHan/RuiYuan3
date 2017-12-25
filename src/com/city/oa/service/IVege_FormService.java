package com.city.oa.service;
import java.util.List;

import com.city.oa.model.Vege_FormModel;

public interface IVege_FormService {
	public abstract void add(Vege_FormModel em) throws Exception;
	public List<Vege_FormModel>getListByall(String name)throws Exception;
	public int getVege_formCount(String name ) throws Exception;	  
	public float counter(String name)throws Exception;
	public void delete(int id);
}
