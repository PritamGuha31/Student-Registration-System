package com.srs.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.srs.beans.ExamRegistry;
import com.srs.beans.School;
import com.srs.beans.Student;
import com.srs.util.Utils;


@WebServlet("/registerexam_request")
public class ExamRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    		HttpSession session=request.getSession(false);
    		Student student=(Student)session.getAttribute("student");
    		String value = request.getParameter("centre");
    		if(value.equals("default")){
    			PrintWriter out=response.getWriter();
    			response.setContentType("text/html");  
    			out.println("<script type=\"text/javascript\">");  
    			out.println("alert('You have not chosen any examination centre.');");  
    			out.println("window.location='RegisterExam.jsp';");
    			out.println("</script>");
    		}
    		int schoolid=Integer.parseInt(request.getParameter("centre"));
    		String tenboard=request.getParameter("tenboard");
    		int tenyear=Integer.parseInt(request.getParameter("tenyear"));
    		String tenmarks=request.getParameter("tenmarks");
    		String twelveboard=request.getParameter("twelveboard");
    		int twelveyear=Integer.parseInt(request.getParameter("twelveyear"));
    		String twelvemarks=request.getParameter("twelvemarks");
    		Utils u=new Utils();
    		School school=u.validateSchoolByID(schoolid);
    		ExamRegistry er=new ExamRegistry(0,student,tenboard,tenyear,tenmarks,twelveboard,twelveyear,twelvemarks,school);
    		boolean inserted=u.addintoRegistry(er);
    		if(inserted){
    			boolean res=u.incrementSeatsBooked(schoolid);
    			response.sendRedirect("StudentProfile.jsp");
    		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
