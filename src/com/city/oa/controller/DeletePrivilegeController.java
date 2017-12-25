package com.city.oa.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.city.oa.factory.ServiceFactory;
@WebServlet("/home/Priv/privilegedelete.do")
public class DeletePrivilegeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DeletePrivilegeController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		 ServiceFactory.createPrivilegeService().delete(Integer.parseInt(id));
		request.getRequestDispatcher("priv.do").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
