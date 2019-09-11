package com.srs.servlets;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.srs.beans.Books;
import com.srs.util.Utils;

/**
 * Servlet implementation class PDFViewerServlet
 */
@WebServlet("/readBook")
public class PDFViewerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PDFViewerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int bookid=Integer.parseInt(request.getParameter("bookid"));
		Utils u=new Utils();
		Books book=u.getBook(bookid);
		String path=book.getPath();
		String path1=path.replace('\\','/');
		String fileName=path1.substring(path1.lastIndexOf("/")+1);
		/*response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println(path1);
		out.print(bookname);*/
		response.setContentType("APPLICATION/PDF");
		PrintWriter out=response.getWriter();
		response.setHeader("Content-Disposition", "inline; fileName=\""+fileName+"\"");
		FileInputStream fi=new FileInputStream(path1);
		int i;
		while((i=fi.read()) != -1)
			out.write(i);
		fi.close();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
