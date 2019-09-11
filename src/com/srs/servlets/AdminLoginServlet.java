package com.srs.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.srs.beans.Admin;
import com.srs.util.Utils;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/loginAdmin")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String adminid=request.getParameter("adminid");
		String pass=request.getParameter("pass");
		Utils u=new Utils();
		Admin admin=new Admin();
		admin=u.validateAdmin(adminid, pass);
		if(admin!=null){
			HttpSession session=request.getSession();
			session.setAttribute("admin", admin);
			response.sendRedirect("AdminHome.jsp");
		}else{
			PrintWriter out=response.getWriter();
			response.setContentType("text/html");  
			out.println("<script type=\"text/javascript\">");  
			out.println("alert('You have entered wrong Admin ID and password combination');");  
			out.println("window.location='AdminLogin.jsp';");
			out.println("</script>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
