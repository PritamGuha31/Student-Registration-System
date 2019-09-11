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
import com.srs.beans.Student;
import com.srs.util.Utils;

/**
 * Servlet implementation class ChangeExamCentre
 */
@WebServlet("/changeCentre")
public class ChangeExamCentre extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeExamCentre() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("centrebox"));
		HttpSession session=request.getSession(false);
		Student student=(Student)session.getAttribute("student");
		Utils u=new Utils();
		ExamRegistry er=u.getExamInfo(student.getRoll());
		boolean res = u.changeExaminationCentre(er.getSchool().getSchoolid(), id, student.getRoll());
		if(res==true){
			response.sendRedirect("StudentProfile.jsp");
		}
		/*response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.print(id);
		out.print(er.getSchool().getSchoolid());*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
