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

@WebServlet("/changeStatus")
public class ExamCentreStatusChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
   		int id=Integer.parseInt(request.getParameter("id"));
   		Utils u=new Utils();
   		School centre=u.getExaminationCentre(id);
   		HttpSession session = request.getSession();
		session.setAttribute("centre", centre);
		response.sendRedirect("ChangeStatus.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
