package com.city.oa.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.city.oa.factory.ServiceFactory;

@WebServlet("/home/VegeBill/billdelete.do")
public class DeleteVegetableBillController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DeleteVegetableBillController() {
        super();
    
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("id");
		ServletContext  ctx = this.getServletContext();
		String na =(String) ctx.getAttribute("na");
		ServiceFactory.createVege_FormService().delete(Integer.parseInt(name));
		request.getRequestDispatcher("viewbill.do?id="+na).forward(request, response);
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
