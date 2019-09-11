package com.srs.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.srs.beans.School;
import com.srs.util.Utils;

@WebServlet("/examcentrelogin_request")
public class ExamCentreLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
   		String email = request.getParameter("email");
		String password = request.getParameter("password");
		School school=new School();
		Utils u=new Utils();
		school=u.validateSchool(email, password);
		if(school!=null){
			HttpSession session=request.getSession();
			session.setAttribute("school", school);
			response.sendRedirect("ExaminationCentreHome.jsp");
		}else{
			PrintWriter out = response.getWriter();  
			response.setContentType("text/html");  
			out.println("<script type=\"text/javascript\">");  
			out.println("alert('You have entered wrong email ID and password combination');");  
			out.println("window.location='Home.jsp';");
			out.println("</script>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
