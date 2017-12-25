package com.city.oa.dao;
import java.util.List;

import com.city.oa.model.Vege_FormModel;
public interface IVege_FormDao {
	void create(Vege_FormModel em) throws Exception;
	List<Vege_FormModel> getListByAll(String name ) throws Exception;
	void delete(int  vege_id) throws Exception;
	float counter(String name)throws Exception;
}
