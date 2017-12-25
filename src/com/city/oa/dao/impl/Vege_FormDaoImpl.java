package com.city.oa.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.city.oa.dao.IVege_FormDao;
import com.city.oa.factory.ConnectionFactory;
import com.city.oa.factory.ServiceFactory;
import com.city.oa.model.VIPModel;
import com.city.oa.model.Vege_FormModel;
import com.city.oa.model.VegetableModel;
public class Vege_FormDaoImpl implements IVege_FormDao {
	public void create(Vege_FormModel em) throws Exception {
		Connection cn=ConnectionFactory.getConnection();
		CallableStatement ps = null;
		
		if(em.getVipmodel()!=null){
			 ps=cn.prepareCall("{call addtoPrivilege(?,?,?,?,?)}");
			ps.setString(1, em.getEattime());
			ps.setString(2, em.getConsumer());
			ps.setInt(3, em.getVipmodel().getVip_ID());
			ps.setString(4, em.getVegemodel().getVname());
			ps.setFloat(5,  em.getVegemodel().getVprice());
			
		}
		else{
			 ps=cn.prepareCall("{call addtovege_form1(?,?,?,?)}");
			ps.setString(1, em.getEattime());
			ps.setString(2, em.getConsumer());
			ps.setString(3, em.getVegemodel().getVname());
			ps.setFloat(4,  em.getVegemodel().getVprice());
			
			
		}

		ps.execute();
		ps.close();
		cn.close();
	}

	public void delete(int  id) throws Exception {
		Connection cn=ConnectionFactory.getConnection();
		CallableStatement	 ps=cn.prepareCall("{call deletevege_form(?)}");
		ps.setInt(1, id);
		ps.executeUpdate();
		ps.close();
		cn.close();
	}

	public List<Vege_FormModel> getListByAll(String consumer ) throws Exception {
		List<Vege_FormModel>  list = new ArrayList<Vege_FormModel>();
		Connection cn=ConnectionFactory.getConnection();
		CallableStatement	 ps=cn.prepareCall("{call selectvege_form(?)}");
		ps.setString(1, consumer);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			Vege_FormModel em =new Vege_FormModel();
			em.setConsumer(rs.getString("consumer"));
			em.setEattime(rs.getString("vege_time"));
			String  vname = rs.getString("vname");
			em.setVegebillid(rs.getInt("vege_form_id")); 
			em.setStatitics(rs.getFloat("statistic"));
			VegetableModel vege = ServiceFactory.createVegetableService().getVegetable(vname);

			int vip = rs.getInt("vip_id");
			if(vip != 0)
			{
				VIPModel vip1 = ServiceFactory.createVIPService().getVIP(vip);
				em.setVipmodel(vip1);
				em.setStatitics(vege.getVprice());
			}
			em.setVegemodel(vege);
			em.setStatitics(vege.getVprice());
			list.add(em);
		}
		rs.close();
		ps.close();
		cn.close();
		return list;
	}
	@Override
	public float counter(String name) throws Exception {
		float sum = 0;
		Connection cn=ConnectionFactory.getConnection();
		CallableStatement	 ps=cn.prepareCall("{call countervege_form(?)}");
		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			sum+=rs.getFloat("a");
		}
		rs.close();
        ps.close();
		cn.close();
		return sum;
	}
}
