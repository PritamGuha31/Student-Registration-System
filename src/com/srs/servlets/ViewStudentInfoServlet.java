package com.srs.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.srs.beans.Student;
import com.srs.util.Utils;


@WebServlet("/viewstudentinfo")
public class ViewStudentInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int roll = Integer.parseInt(request.getParameter("roll"));
		Student student = new Student();
		Utils u = new Utils();
		student = u.validateStudentbyRoll(roll);
		if(student != null){
			HttpSession session = request.getSession();
			session.setAttribute("student", student);
			response.sendRedirect("ViewMoreStudentInfo.jsp");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
