package com.city.oa.controller;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.city.oa.factory.ServiceFactory;
import com.city.oa.model.VegetableModel;

@WebServlet("/home/Vege/showvegephoto.do")
public class VegePhotoToShowController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public VegePhotoToShowController() {
        super();
    }
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}
	public void destroy() {
		// TODO Auto-generated method stub
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String name=request.getParameter("id");
			System.out.println(name+"66666666666666666666666");
			VegetableModel em=ServiceFactory.createVegetableService().getVegetable(name);
			System.out.println(em);
			if(em!=null){
				response.setContentType(em.getPhototype());
				OutputStream out=response.getOutputStream();
				InputStream in=em.getPhoto().getBinaryStream();
				int data=0;
				while((data=in.read())!=-1){
					out.write(data);
				}
				out.flush();
				out.close();		
			}	
		}
		catch(Exception e){
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
