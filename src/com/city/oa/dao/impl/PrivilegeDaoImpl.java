package com.city.oa.dao.impl;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.city.oa.dao.IPrivilegeDao;
import com.city.oa.factory.ConnectionFactory;
import com.city.oa.model.PrivilegeModel;
public class PrivilegeDaoImpl implements IPrivilegeDao {

	@Override
	public int  create(PrivilegeModel em) throws Exception {
		Connection cn=ConnectionFactory.getConnection();
		CallableStatement ps=cn.prepareCall("{call addtoPrivilege(?,?,?)}");
		ps.setInt(1, em.getDiscount());
		ps.setString(2, em.getP_time());
		ps.setString(3,  em.getP_end());
		int i  = ps.executeUpdate();
		ps.close();
		cn.close();
		if(i==0){
			cn.rollback();

		}
		return i;
	}

	@Override
	public PrivilegeModel getPriv(int id) throws Exception {
		PrivilegeModel em = null;
		Connection cn=ConnectionFactory.getConnection();
		CallableStatement ps=cn.prepareCall("{call selectprivilege(?)}");
		ps.setInt(1,id);
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			em=new PrivilegeModel();	
			em.setPr_id(rs.getInt("p_id"));
			em.setDiscount(rs.getInt("discount"));
			em.setP_time(rs.getString("p_time"));
			em.setP_end(rs.getString("p_end"));
		}
		rs.close();
		ps.close();
		cn.close();
		return em;
	}

	@Override
	public List<PrivilegeModel> getListByAll() throws Exception {
		List<PrivilegeModel>  list = new ArrayList<PrivilegeModel>();
		Connection cn=ConnectionFactory.getConnection();
		CallableStatement ps=cn.prepareCall("{call selectprivilege1}");
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			PrivilegeModel em =new PrivilegeModel();
			em.setPr_id(rs.getInt("p_id"));
			em.setDiscount(rs.getInt("discount"));
			em.setP_time(rs.getString("p_time"));
			em.setP_end(rs.getString("p_end"));
			list.add(em);
		}
		rs.close();
		ps.close();
		cn.close();
		return list;
	}

	@Override
	public void delete(int id) throws Exception {
		Connection cn=ConnectionFactory.getConnection();
		CallableStatement ps=cn.prepareCall("{call deleteprivilege(?)}");
		ps.setInt(1, id);
		ps.executeUpdate();
		ps.close();
		cn.close();
	}

	@Override
	public void update(PrivilegeModel em) throws Exception {
		Connection cn=ConnectionFactory.getConnection();
		CallableStatement ps=cn.prepareCall("{call updateprivilege(?,?,?,?)}");
		ps.setInt(1, em.getDiscount());
		ps.setString(2, em.getP_time());
		ps.setString(3,  em.getP_end());
		ps.setInt(4, em.getPr_id());
		ps.executeUpdate();
		ps.close();
		cn.close();
	}
}
