package com.city.oa.controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.city.oa.factory.ServiceFactory;
import com.city.oa.model.PrivilegeModel;
import com.city.oa.model.VegetableModel;
/**
 * Servlet implementation class UpdateVegeController
 */
@WebServlet("/home/Vege/skipupdatevege.do")
public class UpdateToVegeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateToVegeController() {
        super();
        // TODO Auto-generated constructor stub
    }
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		try {
			List<PrivilegeModel>  emp = ServiceFactory.createPrivilegeService().getListByall();
			VegetableModel em = ServiceFactory.createVegetableService().getVegetable(id);
			request.setAttribute("em", em);
			request.setAttribute("emp",emp);
			request.getRequestDispatcher("UpdateVegeInfo.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
