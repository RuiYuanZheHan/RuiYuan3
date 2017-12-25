package com.city.oa.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialBlob;

import com.city.oa.factory.ServiceFactory;
import com.city.oa.model.PrivilegeModel;
import com.city.oa.model.VegetableModel;
import com.jspsmart.upload.SmartUpload;

/**
 * Servlet implementation class UpdateVegeController
 */
@WebServlet("/home/Vege/updatevege.do")
public class UpdateVegeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateVegeController() {
		super();
		// TODO Auto-generated constructor stub
	}
	private ServletConfig config=null;
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.config = config;
	}   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String id = request.getParameter("id").trim();
			SmartUpload upload=new SmartUpload();
			upload.initialize(config, request, response);		

			upload.upload();	
			VegetableModel em=ServiceFactory.createVegetableService().getVegetable(id);
			String name=upload.getRequest().getParameter("name");
			float price=Float.parseFloat(upload.getRequest().getParameter("price"));

			int  pr_id = Integer.parseInt(upload.getRequest().getParameter("discount").trim());
		
			PrivilegeModel pr = new PrivilegeModel();
			pr.setPr_id(pr_id);
			String kind=upload.getRequest().getParameter("kind");
			String style=upload.getRequest().getParameter("style");


			em.setVname(name);
			em.setVkind(kind);
			em.setVprice(price);
			em.setVege_style(style);
			em.setPr_id(pr);

			if(upload.getFiles().getSize()>0){
				String fileName=upload.getFiles().getFile(0).getFileName();
				upload.getFiles().getFile(0).saveAs("/upload/"+fileName);
				String realpath=request.getServletContext().getRealPath("/upload");
				@SuppressWarnings("resource")
				InputStream in=new FileInputStream(realpath+"/"+fileName);
				int size=upload.getFiles().getFile(0).getSize();
				byte[] contents=new byte[size];
				int data=0;
				int i=0;
				while((data=in.read())!=-1){
					contents[i]=(byte)data;
					i++;				
				}
				Blob photo=new SerialBlob(contents);	
				em.setPhoto(photo);
			}
			ServiceFactory.createVegetableService().update(em);
			request.getRequestDispatcher("vege.do").forward(request, response);
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
