package com.city.oa.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.city.oa.factory.ServiceFactory;
import com.city.oa.model.Vege_FormModel;
@WebServlet("/home/VegeBill/viewbill.do")
public class VegetableBillViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public VegetableBillViewController() {
		super();

	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("id");

		try {
			float sum=  ServiceFactory.createVege_FormService().counter(name); 
			List<Vege_FormModel> list =  (List<Vege_FormModel>) ServiceFactory.createVege_FormService().getListByall(name);
			request.setAttribute("billlist", list);
			request.setAttribute("sum", sum);
			request.getRequestDispatcher("Billshow.jsp").forward(request, response);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
