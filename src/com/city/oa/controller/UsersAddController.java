package com.city.oa.controller;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.city.oa.factory.ServiceFactory;
import com.city.oa.model.UsersModel;
import com.city.oa.security.MD5;
@WebServlet("/home/Users/users.do")
public class UsersAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void init(ServletConfig config) throws ServletException {
	}
	public void destroy() {
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			UsersModel em=new UsersModel();
			String na=request.getParameter("name");
			String password=request.getParameter("password");
			String  identify  = request.getParameter("identify");
			String jiami = null;
			jiami =MD5.EncoderByMd5(password);
			em.setUname(na);
			em.setPassword(jiami);
			em.setIdentify(identify);
			int i = ServiceFactory.createUsersService().add(em);
			PrintWriter out = response.getWriter();
			response.setContentType("text/html;charset=utf-8");
			if(i!=0){
				out.print("1");
			}
			else{
			
				out.print("0");
			}
			out.flush();
			out.close();
		}
		catch(Exception e){
			e.printStackTrace();
	
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
