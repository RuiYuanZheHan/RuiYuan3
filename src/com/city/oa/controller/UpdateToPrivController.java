package com.city.oa.controller;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.city.oa.factory.ServiceFactory;
import com.city.oa.model.PrivilegeModel;
import com.jspsmart.upload.SmartUpload;
@WebServlet("/home/Priv/skipupdatepriv.do")
public class UpdateToPrivController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public UpdateToPrivController() {
		super();
	}
	private ServletConfig config=null;
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
	}   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String id = request.getParameter("id");
			
			SmartUpload upload=new SmartUpload();
			upload.initialize(config, request, response);		
			upload.upload();	
			PrivilegeModel em=ServiceFactory.createPrivilegeService().getPriv(Integer.parseInt(id));
			int  discount=Integer.parseInt(upload.getRequest().getParameter("discount"));
			String  begin=upload.getRequest().getParameter("begin");
			String  end=upload.getRequest().getParameter("end");
			em.setDiscount(discount);
			em.setP_time(begin);
			em.setP_end(end);
			ServiceFactory.createPrivilegeService().update(em);
			response.sendRedirect("priv.do");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
