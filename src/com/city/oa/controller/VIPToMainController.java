package com.city.oa.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.city.oa.factory.ServiceFactory;
import com.city.oa.model.VIPModel;
import com.city.oa.service.IVIPService;
@WebServlet("/home/VIP/vip.do")
public class VIPToMainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public VIPToMainController() {super();}
	public void init(ServletConfig config) throws ServletException {}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			IVIPService  em=ServiceFactory.createVIPService();
			int i = em.getVIPCount();
			List<VIPModel> list =em.getListByall();
			request.setAttribute("i", i);
			request.setAttribute("list", list);
			RequestDispatcher rd = request.getRequestDispatcher("ManageVIP.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
