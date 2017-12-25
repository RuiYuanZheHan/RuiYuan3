package com.city.oa.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.city.oa.factory.ServiceFactory;
import com.city.oa.model.VIPModel;
import com.jspsmart.upload.SmartUpload;
@WebServlet("/home/VIP/updatevip.do")
public class UpdateVIPController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public UpdateVIPController() {
		super();
	}
	private ServletConfig config=null;
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
	}   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			int id =Integer.parseInt( request.getParameter("id"));
			SmartUpload upload=new SmartUpload();
			upload.initialize(config, request, response);		

			upload.upload();	
			VIPModel em=ServiceFactory.createVIPService().getVIP(id);		
			String name=upload.getRequest().getParameter("name");
			int     discount=Integer.parseInt(upload.getRequest().getParameter("discount"));
			String  phone=upload.getRequest().getParameter("phone");
			em.setName(name);
			em.setPrivilege_cir(discount);
			em.setPhone(phone);
			ServiceFactory.createVIPService().update(em);	
			response.sendRedirect("vip.do");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
