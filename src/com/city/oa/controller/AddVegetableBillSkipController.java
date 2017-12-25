package com.city.oa.controller;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.city.oa.factory.ServiceFactory;
import com.city.oa.model.VegetableModel;
@WebServlet("/home/VegeBill/skipaddvegebill.do")
public class AddVegetableBillSkipController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public AddVegetableBillSkipController() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		
			List<VegetableModel> list = ServiceFactory.createVegetableService().getListByall();
			request.setAttribute("list",list);
			request.getRequestDispatcher("AddVegeBill.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
