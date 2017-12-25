package com.city.oa.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.city.oa.dao.IUsersDao;
import com.city.oa.factory.ConnectionFactory;
import com.city.oa.model.UsersModel;
public class UsersDaoImpl implements IUsersDao {

	@Override
	public int  create(UsersModel em) throws Exception {
		Connection cn=ConnectionFactory.getConnection();
		//String sql="insert into users(uname,upassword,identify)  values (?,?,?)";
		//PreparedStatement ps=cn.prepareStatement(sql);

		CallableStatement ps=cn.prepareCall("{call addtousers(?,?,?)}");
		ps.setString(1,em.getUname());
		ps.setString(2, em.getPassword());
		ps.setString(3, em.getIdentify());
		System.out.println(em.getPassword());
		System.out.println(em.getPassword().length());
		int  i = ps.executeUpdate();
		ps.close();
		cn.close();
		if(i!=0)
		{
			return 1;
		}else{
			return 0;
		}

	}

	@Override
	public void delete(int  id) throws Exception {
		Connection cn=ConnectionFactory.getConnection();
		CallableStatement ps=cn.prepareCall("{call deleteusers(?)}");
		ps.setInt(1, id);
		ps.executeUpdate();
		ps.close();
		cn.close();


	}


	public UsersModel getUsers(int id) throws Exception {
		UsersModel em = null;
		Connection cn=ConnectionFactory.getConnection();
		CallableStatement ps=cn.prepareCall("{call selectusers(?)}");
		ps.setInt(1,id);
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			em=new UsersModel();
			em.setUid(rs.getInt("uid"));
			em.setUname(rs.getString("uname"));
			em.setPassword(rs.getString("upassword"));
			em.setIdentify(rs.getString("identify"));
		}
		System.out.println(id);
		rs.close();
		ps.close();
		cn.close();
		return em;
	}
	@Override
	public List<UsersModel> getListByAll() throws Exception {
		List<UsersModel>  list = new ArrayList<UsersModel>();
		Connection cn=ConnectionFactory.getConnection();
		CallableStatement ps=cn.prepareCall("{call selectusers1}");
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			UsersModel em =new UsersModel();
			em.setUname(rs.getString("uname"));
			em.setUid(rs.getInt("uid"));		
			em.setIdentify(rs.getString("identify"));
			list.add(em);
		}
		rs.close();
		ps.close();
		cn.close();
		return list;
	}
	@Override
	public void update(UsersModel em) throws Exception {
		Connection cn=ConnectionFactory.getConnection();
		CallableStatement ps=cn.prepareCall("{call updateusers(?,?,?)}");
		ps.setString(1, em.getPassword());
		ps.setString(2,em.getIdentify());
		ps.setInt(3, em.getUid());
		ps.executeUpdate();
		ps.close();
		cn.close();
	}

	@Override
	public UsersModel getUsersbyname(String name) throws Exception {
		UsersModel em = null;
		Connection cn=ConnectionFactory.getConnection();
		CallableStatement ps=cn.prepareCall("{call selectusersbyname(?)}");
		ps.setString(1,name);
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			em=new UsersModel();
			em.setUid(rs.getInt("uid"));
			em.setUname(rs.getString("uname"));
			em.setPassword(rs.getString("upassword"));
			em.setIdentify(rs.getString("identify"));
		}
		
		rs.close();
		ps.close();
		cn.close();
		return em;
	}
}
