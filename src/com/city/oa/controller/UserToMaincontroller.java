package com.city.oa.controller;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.city.oa.factory.ServiceFactory;
import com.city.oa.model.UsersModel;
@WebServlet("/home/Users/tomain.do")
public class UserToMaincontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public UserToMaincontroller() {
		super();
		// TODO Auto-generated constructor stub
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int i = ServiceFactory.createUsersService().getUserCount();
			List<UsersModel> list =ServiceFactory.createUsersService().getListByall();
			request.setAttribute("i", i);
			request.setAttribute("list", list);
			request.getRequestDispatcher("ManagerUsers.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
