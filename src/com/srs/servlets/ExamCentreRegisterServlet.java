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

@WebServlet("/institute_register_request")
public class ExamCentreRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("name");
		String principal=request.getParameter("principal");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		String locality=request.getParameter("locality");
		int pin=Integer.parseInt(request.getParameter("pin"));
		String city=request.getParameter("city");
		int seats=Integer.parseInt(request.getParameter("seats"));
		String details=request.getParameter("details");
		String pass=request.getParameter("pass");
		School school=new School(0,name,principal,email,address,locality,pin,city,seats,details,pass,"PENDING");
		Utils u=new Utils();
		if(u.addSchool(school)){
			HttpSession session=request.getSession();
			school=u.validateSchool(email, pass);
			session.setAttribute("school", school);
			response.sendRedirect("ExaminationCentreHome.jsp");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
