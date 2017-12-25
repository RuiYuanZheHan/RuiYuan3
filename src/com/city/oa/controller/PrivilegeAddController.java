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
import com.city.oa.model.PrivilegeModel;

@WebServlet("/home/Priv/addpriv.do")
public class PrivilegeAddController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public void init(ServletConfig config) throws ServletException {
	}

	public PrivilegeAddController() {
		super();
		// TODO Auto-generated constructor stub
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
     		int discount =  Integer.parseInt(request.getParameter("discount"));
			String p_time =request.getParameter("begin");
			String p_end = request.getParameter("end");
			int  i  = 0;
			PrivilegeModel em=new PrivilegeModel();
			em.setDiscount(discount);
			em.setP_time(p_time);
			em.setP_end(p_end);
			i = ServiceFactory.createPrivilegeService().add(em);
			System.out.println(p_time+"ewewe");
			PrintWriter out = response.getWriter();
			response.setContentType("text/html;charset=utf-8");
			if(i!=0){
				out.print("1");
			}
			out.flush();
			out.close();
			//response.sendRedirect("priv.do");
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage()+"544546546");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
