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
@WebServlet("/home/Vege/addvege.do")
public class VegeAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public VegeAddController() {	super();}
	private ServletConfig config=null;
	public void init(ServletConfig config) throws ServletException {this.config = config;	}
	public void destroy() {}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			SmartUpload upload=new SmartUpload();
			upload.initialize(config, request, response);		
			upload.upload();	
			VegetableModel em=new VegetableModel();
			String name=upload.getRequest().getParameter("name");
			float price=Float.parseFloat(upload.getRequest().getParameter("price"));
			String  kind=upload.getRequest().getParameter("kind");
			String  style=upload.getRequest().getParameter("style");
			int  pr_id = Integer.parseInt(upload.getRequest().getParameter("discount").trim());
			em.setVname(name);
			em.setVkind(kind);
			em.setVege_style(style);
			PrivilegeModel   pr = ServiceFactory.createPrivilegeService().getPriv(pr_id);
			pr.setPr_id(pr_id);
			em.setPr_id(pr);
			em.setVprice(price*pr.getDiscount()/10);
			if(upload.getFiles().getSize()>0){
				String fileName=upload.getFiles().getFile(0).getFileName();
				String contentType=upload.getFiles().getFile(0).getContentType().trim();
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
				em.setPhototype(contentType);
			}
			 ServiceFactory.createVegetableService().add(em);
			response.sendRedirect("vege.do");

		}
	catch(Exception e){
		e.printStackTrace();
	}
}
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	doGet(request, response);
}

}
