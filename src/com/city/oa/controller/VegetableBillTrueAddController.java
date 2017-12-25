package com.city.oa.controller;
import java.io.IOException;
import java.util.Calendar;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.city.oa.factory.ServiceFactory;
import com.city.oa.model.VIPModel;
@WebServlet("/home/VegeBill/trueadd.do")
public class VegetableBillTrueAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public VegetableBillTrueAddController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name= request.getParameter("name");
		ServletContext  ctx = this.getServletContext();
		try {
           VIPModel  vip =  ServiceFactory.createVIPService().getVIP(name);
           if(vip!=null){
        		
        		ctx.setAttribute("na",vip.getName());
        		
           }
           else{
        	   ctx.setAttribute("na", name);
        	   //System.out.print("123456"+ctx.getAttribute("na"));
           }
           System.out.println(vip);
   			Calendar c = Calendar.getInstance();
			String year = String.valueOf(c.get(Calendar.YEAR));
			String month = String.valueOf(c.get(Calendar.MONTH) + 1);
			String day = String.valueOf(c.get(Calendar.DAY_OF_MONTH));
		
			String date = year + "-" + month + "-" + day;
			
			ctx.setAttribute("date",date);
			request.getRequestDispatcher("skipaddvegebill.do").forward(request, response);
		} catch (Exception e) {
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
