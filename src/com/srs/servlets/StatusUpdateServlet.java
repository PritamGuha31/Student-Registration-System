package com.srs.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.srs.beans.School;
import com.srs.util.Utils;

@WebServlet("/statusUpdate")
public class StatusUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
   		HttpSession session= request.getSession(false);
   		School centre=(School)session.getAttribute("centre");
   		int id=centre.getSchoolid();
   		String rstatus= request.getParameter("rstatus");
   		Utils u=new Utils();
   		boolean update=u.changeStatus(id, rstatus);
   		if(update) {	
			centre.setStatus(rstatus);
			if(rstatus.equals("APPROVED")){
	   			boolean res=u.addApprovedCentre(centre);
	   		}
			response.sendRedirect("ViewExaminationCentreRegister.jsp");
		}
   		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
