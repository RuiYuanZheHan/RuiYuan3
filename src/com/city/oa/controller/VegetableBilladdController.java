package com.city.oa.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.city.oa.factory.ServiceFactory;
import com.city.oa.model.VIPModel;
import com.city.oa.model.Vege_FormModel;
import com.city.oa.model.VegetableModel;
@WebServlet("/home/VegeBill/addvegetable.do")
public class VegetableBilladdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public VegetableBilladdController() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext  ctx = this.getServletContext();
		String id = request.getParameter("id");
		Vege_FormModel bill =  new  Vege_FormModel();
		try {
			
			String name =  (String) ctx.getAttribute("na");
			String date = (String) ctx.getAttribute("date");
			VIPModel vip = ServiceFactory.createVIPService().getVIP(name);
			VegetableModel 	vege = ServiceFactory.createVegetableService().getVegetable(id);

			if(vip!=null)
				bill.setVipmodel(vip);
			else
				bill.setVipmodel(null);

			bill.setVegemodel(vege);
			bill.setConsumer(name);
			//bill.setConsumer("aaa");
			bill.setEattime(date);

			//	bill.setUnitprice(vege.getVprice());
			ServiceFactory.createVege_FormService().add(bill);
			request.getRequestDispatcher("skipaddvegebill.do").forward(request, response);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
