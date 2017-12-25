package com.city.oa.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.city.oa.factory.ServiceFactory;
import com.city.oa.model.PrivilegeModel;
import com.city.oa.service.IPrivilegeService;

@WebServlet("/home/Priv/priv.do")
public class PrivilegeToMainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PrivilegeToMainController() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init(ServletConfig config) throws ServletException {
	}
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			IPrivilegeService  em=ServiceFactory.createPrivilegeService();
			int i = em.getPrivilegeCount();
			List<PrivilegeModel> list =em.getListByall();
			request.setAttribute("i", i);
			request.setAttribute("list", list);
			request.getRequestDispatcher("ManagePrivilege.jsp").forward(request, response);;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
