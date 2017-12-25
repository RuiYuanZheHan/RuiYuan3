package com.city.oa.controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.city.oa.factory.ServiceFactory;
import com.city.oa.model.VIPModel;
@WebServlet("/home/VIP/addvip.do")
public class VIPAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}
	public void destroy() {
		// TODO Auto-generated method stub
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			PrintWriter out = response.getWriter();
			VIPModel em=new VIPModel();
			String name=request.getParameter("na");
			int discount=Integer.parseInt(request.getParameter("discount"));
			String phone=request.getParameter("phone");
			em.setName(name);
			em.setPrivilege_cir(discount);
			em.setPhone(phone);
			int i =     ServiceFactory.createVIPService().add(em);
			if(i!=0){
				out.print("1");
			}
			else{
				out.print("0");
			}
			out.flush();
			out.close();
			//request.getRequestDispatcher("vip.do").forward(request, response);
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
