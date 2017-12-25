package com.city.oa.controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.city.oa.factory.ServiceFactory;
import com.city.oa.model.VIPModel;
@WebServlet("/home/VIP/showvip.do")
public class VIPToShowController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public VIPToShowController() {
		super();
		// TODO Auto-generated constructor stub
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println(Integer.parseInt(request.getParameter("id")));
		//		System.out.println(request.getParameter("name"));

		int id=Integer.parseInt(request.getParameter("id").trim());
		String name = request.getParameter("name");

		try {
			List list = ServiceFactory.createVege_FormService().getListByall(name);
			float sum =  ServiceFactory.createVege_FormService().counter(name);
			VIPModel aa =ServiceFactory.createVIPService().getVIP(id);
			request.setAttribute("aa", aa);
			request.setAttribute("list", list);
			request.setAttribute("sum", sum);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("vipshow.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
