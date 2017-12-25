package com.city.oa.controller;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.city.oa.factory.ServiceFactory;
import com.city.oa.model.UsersModel;
import com.city.oa.security.MD5;
@WebServlet("/home/main/login.do")
public class UserLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public UserLoginController() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name").trim();
		String password=request.getParameter("password").trim();
		String identity = request.getParameter("identity");
		PrintWriter out = response.getWriter();

		try {

			String pass = MD5.EncoderByMd5(password);
		
			UsersModel um =ServiceFactory.createUsersService().getUserByName(name);
	
		
			if(um!=null){
		
				if(MD5.getMD5(pass, um.getPassword())){
					if(um.getIdentify().equals(identity)){
						if(um.getIdentify().equals("酒店经理")){
							out.println("2");
						
							out.flush();
							out.close();
						}else {
							out.println("1");
							out.flush();
							out.close();
						}
					}else{
						out.println("3");
						out.flush();
						out.close();
					}

				}else{
					out.println("密码不正确");
					out.flush();
					out.close();
				}
			}
			else{
				out.println("用户不存在");
				out.flush();
				out.close();
			}
		} catch (Exception e) {
			out.println("用户名不存在");
			out.flush();
			out.close();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
