package com.srs.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.srs.util.Utils;

 
@WebServlet("/removestudent")
public class RemoveStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    		int roll = Integer.parseInt(request.getParameter("roll"));
    		Utils u = new Utils();
    		boolean result = u.deleteStudent(roll);
    		if(result){
    			response.sendRedirect("ViewAllStudents.jsp");
    			
    		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
		
	}

}
