package com.city.oa.controller;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.city.oa.factory.ServiceFactory;
import com.city.oa.model.UsersModel;
import com.city.oa.security.MD5;
@WebServlet("/home/Users/updateuser.do")
public class UpdateUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String  name = request.getParameter("id");
		
			
			UsersModel em=ServiceFactory.createUsersService().getUserByName(name);
			String password=request.getParameter("password");
			String jiami = null;
			System.out.println(password);
			jiami =MD5.EncoderByMd5(password);
			em.setPassword(jiami);
			ServiceFactory.createUsersService().update(em);	
			response.sendRedirect("tomain.do");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
