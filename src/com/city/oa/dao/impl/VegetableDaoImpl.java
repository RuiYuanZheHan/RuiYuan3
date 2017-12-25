package com.city.oa.dao.impl;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.city.oa.dao.IVegeatableDao;
import com.city.oa.factory.ConnectionFactory;
import com.city.oa.factory.ServiceFactory;
import com.city.oa.model.PrivilegeModel;
import com.city.oa.model.VegetableModel;

public class VegetableDaoImpl implements IVegeatableDao {
	@Override
	public int  create(VegetableModel em) throws Exception {
		int i = 0;
		Connection cn=ConnectionFactory.getConnection();
		CallableStatement	 ps=cn.prepareCall("{call addtovegetable(?,?,?,?,?,?,?)}");
		ps.setString(1,em.getVname());
		ps.setInt(2, em.getPr_id().getPr_id());
		ps.setFloat(3,  em.getVprice());
		ps.setString(4, em.getVkind());
		ps.setBlob(5, em.getPhoto());
		ps.setString(6, em.getVege_style());
		ps.setString(7, em.getPhototype());
		 i = ps.executeUpdate();
		ps.close();
		cn.close();
		return i;
		
	}
	public VegetableModel getVegetable(String name) throws Exception {
		VegetableModel em = null;
		Connection cn=ConnectionFactory.getConnection();
		CallableStatement	 ps=cn.prepareCall("{call selectvegetable(?)}");
		ps.setString(1, name);
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			em=new VegetableModel();	
			em.setVname(rs.getString("vname"));
			int id = rs.getInt("p_id");
			PrivilegeModel  privilege = ServiceFactory.createPrivilegeService().getPriv(id);
			em.setPr_id(privilege);
			em.setVege_style(rs.getString("vege_style"));
			em.setVkind(rs.getString("vkind"));
			em.setVprice(rs.getFloat("vprice"));
			em.setPhoto(rs.getBlob("photo"));
			em.setPhototype(rs.getString("phototype"));
		}
		rs.close();
		ps.close();
		cn.close();
		return em;
	}
	@Override
	public List<VegetableModel> getListByAll() throws Exception {
		List<VegetableModel>  list = new ArrayList<VegetableModel>();
		Connection cn=ConnectionFactory.getConnection();
		CallableStatement	 ps=cn.prepareCall("{call selectvegetable1}");
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			VegetableModel em =new VegetableModel();
			em.setVname(rs.getString("vname"));
			int id = rs.getInt("p_id");
			PrivilegeModel  privilege = ServiceFactory.createPrivilegeService().getPriv(id);
			em.setPr_id(privilege);
			em.setVege_style(rs.getString("vege_style"));
			em.setVkind(rs.getString("vkind"));
			em.setVprice(rs.getFloat("vprice"));
			em.setPhoto(rs.getBlob("photo"));
			em.setPhototype(rs.getString("phototype"));
			list.add(em);
		}
		rs.close();
		ps.close();
		cn.close();
		return list;
	}

	@Override
	public void delete(String name) throws Exception {
		Connection cn=ConnectionFactory.getConnection();
		CallableStatement	 ps=cn.prepareCall("{call deletevegetable(?)}");
		ps.setString(1, name);
		ps.executeUpdate();
		ps.close();
		cn.close();
	}

	@Override
	public void update(VegetableModel em) throws Exception {
		Connection cn=ConnectionFactory.getConnection();
		CallableStatement	 ps=cn.prepareCall("{call updatevegetable(?,?,?,?,?,?)}");
		ps.setInt(1, em.getPr_id().getPr_id());
		ps.setFloat(2,em.getVprice());
		ps.setString(3, em.getVkind());
		ps.setBlob(4, em.getPhoto());
		ps.setString(5, em.getVege_style());
		ps.setString(6, em.getVname());
		ps.executeUpdate();
		ps.close();
		cn.close();
	}
}
