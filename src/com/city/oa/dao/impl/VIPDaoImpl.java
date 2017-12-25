package com.city.oa.dao.impl;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.city.oa.dao.IVIPDao;
import com.city.oa.factory.ConnectionFactory;
import com.city.oa.model.VIPModel;

public class VIPDaoImpl implements IVIPDao {
	@Override
	public void delete(int code) throws Exception {
		Connection cn=ConnectionFactory.getConnection();
		CallableStatement	 ps=cn.prepareCall("{call deletevip(?)}");
		ps.setInt(1,code );
		ps.executeUpdate();
		ps.close();
		cn.close();
	}
	@Override
	public List<VIPModel> getListByAll() throws Exception {
		List<VIPModel>  list = new ArrayList<VIPModel>();
		Connection cn=ConnectionFactory.getConnection();
		CallableStatement	 ps=cn.prepareCall("{call selectvip}");
		
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			VIPModel em =new VIPModel();
			em.setName(rs.getString("vip_name"));
			em.setPhone(rs.getString("phone"));
			em.setPrivilege_cir(rs.getInt("privilege_cir"));
			em.setVip_ID(rs.getInt("VIP_ID"));
			list.add(em);
		}
		rs.close();
		ps.close();
		cn.close();
		return list;
	}
	@Override
	public int  create(VIPModel em) throws Exception {
		Connection cn=ConnectionFactory.getConnection();
		CallableStatement	 ps=cn.prepareCall("{call addtovip(?,?,?)}");
		ps.setString(1, em.getName());
		ps.setString(2, em.getPhone());
		ps.setInt(3, em.getPrivilege_cir());
		int i = 	ps.executeUpdate();
		ps.close();
		cn.close();
		return i;
		
	}
	@Override
	public VIPModel getVIP(int code) throws Exception {
		VIPModel em = null;
		Connection cn=ConnectionFactory.getConnection();
		CallableStatement	 ps=cn.prepareCall("{call selectvip1(?)}");
		ps.setInt(1,code);
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			em=new VIPModel();
			em.setVip_ID(rs.getInt("VIP_ID"));
			em.setName(rs.getString("VIP_name"));
			em.setPhone(rs.getString("phone"));
			em.setPrivilege_cir(rs.getInt("privilege_cir"));
		}
		rs.close();
		ps.close();
		cn.close();
		return em;
	}
	public VIPModel getVIP(String name) throws Exception {
		VIPModel em = null;
		Connection cn=ConnectionFactory.getConnection();
		CallableStatement	 ps=cn.prepareCall("{call selectvip2(?)}");
		ps.setString(1,name);
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			em=new VIPModel();
			em.setVip_ID(rs.getInt("VIP_ID"));
			em.setName(rs.getString("VIP_name"));
			em.setPhone(rs.getString("phone"));
			em.setPrivilege_cir(rs.getInt("privilege_cir"));
		}
		rs.close();
		ps.close();
		cn.close();
		return em;
	}
	@Override
	public void update(VIPModel em) throws Exception {
		Connection cn=ConnectionFactory.getConnection();
		CallableStatement	 ps=cn.prepareCall("{call updatevip(?,?,?,?)}");
		ps.setString(1, em.getName());
		ps.setString(2, em.getPhone());
		ps.setInt(3, em.getPrivilege_cir());
		ps.setInt(4, em.getVip_ID());
		ps.executeUpdate();
		ps.close();
		cn.close();
	}
}
