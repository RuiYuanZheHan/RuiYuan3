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
import com.city.oa.model.VegetableModel;
import com.city.oa.service.IVegetableService;
@WebServlet("/home/Vege/vege.do")
public class VegeToMainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public VegeToMainController() {
		super();
		// TODO Auto-generated constructor stub
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			IVegetableService  em=ServiceFactory.createVegetableService();
			int i = em.getVegetableCount();
			List<VegetableModel> list =em.getListByall();
			request.setAttribute("i", i);
			request.setAttribute("list", list);
			RequestDispatcher rd = request.getRequestDispatcher("ManageVege.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
