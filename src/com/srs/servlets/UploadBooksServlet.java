package com.srs.servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.srs.beans.Books;
import com.srs.util.Utils;
/**
 * Servlet implementation class UploadBooksServlet
 */
@WebServlet("/uploadBook")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
maxFileSize=1024*1024*10,      // 10MB
maxRequestSize=1024*1024*50)

public class UploadBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private File file;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadBooksServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    private static final String SAVE_DIR="books";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
            String savePath = "E:/my stuff/Advanced Java Training at Globsyn/Project/StudentRegistrationSystem/WebContent/" + SAVE_DIR;
                File fileSaveDir=new File(savePath);
                if(!fileSaveDir.exists()){
                    fileSaveDir.mkdir();
                }
            String title=request.getParameter("title");
            String author=request.getParameter("author");
            String subject=request.getParameter("subject");
            Part part=request.getPart("book");
            String fileName=extractFileName(part);
            /*if you may have more than one files with same name then you can calculate some random characters and append that characters in fileName so that it will  make your each image name identical.*/
            part.write(savePath + File.separator + fileName);
           /* 
            //You need this loop if you submitted more than one file
            for (Part part : request.getParts()) {
            String fileName = extractFileName(part);
            part.write(savePath + File.separator + fileName);
        }*/
            try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/srs","root","root123");
            String query="INSERT INTO books (book_name,author,subject,path,availability) values (?, ?, ?, ?,?)";
           
                PreparedStatement pst;
                pst=con.prepareStatement(query);
                pst.setString(1, title);
                pst.setString(2,author);
                pst.setString(3, subject);
                String filePath= savePath + File.separator + fileName ;
                pst.setString(4,filePath);
                pst.setString(5, "YES");
                pst.executeUpdate();
                pst.close();
                con.close();
            }catch(SQLException e){
            	out.print(e);
            } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            response.sendRedirect("AdminHome.jsp");
            
	}
	
	private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
