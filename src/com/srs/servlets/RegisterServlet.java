package com.srs.servlets;

import java.io.File;
import java.io.IOException;





import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.srs.beans.Student;
import com.srs.util.Utils;

@WebServlet("/register_request")
@MultipartConfig(fileSizeThreshold=1024*1024*2,
maxFileSize=1024*1024*10,
maxRequestSize=1024*1024*50)
public class RegisterServlet extends HttpServlet {
	private static final String SAVE_DIR="Profile Pictures";
	private static final long serialVersionUID = 1L;
	private String host;
	private String port;
	private String user;
	private String pass;

	public void init() {
		// reads SMTP server setting from web.xml file
		ServletContext context = getServletContext();
		host = context.getInitParameter("host");
		port = context.getInitParameter("port");
		user = context.getInitParameter("user");
		pass = context.getInitParameter("pass");
	}  
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cname=request.getParameter("cname");
		String fname=request.getParameter("fname");
		String mname=request.getParameter("mname");
		String cdob=request.getParameter("cdob");
		String gender=request.getParameter("gender");
		String category=request.getParameter("category");
		String nation=request.getParameter("nation");
		int afi=Integer.parseInt(request.getParameter("afi"));
		String caddress=request.getParameter("caddress");
		String district=request.getParameter("district");
		String state=request.getParameter("state");
		String cemail=request.getParameter("cemail");
		Long cphone=Long.parseLong(request.getParameter("cphone"));
		Long caadhar=Long.parseLong(request.getParameter("caadhar"));
		String cpass=request.getParameter("cpass");
		String secqtn=request.getParameter("secqtn");
		String secans=request.getParameter("secans");
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
            String savePath = "E:/my stuff/Advanced Java Training at Globsyn/Project/StudentRegistrationSystem/WebContent" + File.separator + SAVE_DIR;
                File fileSaveDir=new File(savePath);
                if(!fileSaveDir.exists()){
                    fileSaveDir.mkdir();
                }
            
            Part part=request.getPart("file_path");
            String fileName=extractFileName(part);

            /*if you may have more than one files with same name then you can calculate some random characters and append that characters in fileName so that it will  make your each image name identical.*/
            part.write(savePath + File.separator + fileName);
           /* 
            //You need this loop if you submitted more than one file
            for (Part part : request.getParts()) {
            String fileName = extractFileName(part);
            part.write(savePath + File.separator + fileName);
        }*/
		
            String filePath= savePath + File.separator + fileName ;
		
		
		Student student=new Student(0,cname,fname,mname,cdob,gender,category,nation,afi,caddress,district,state,cemail,cphone,caadhar,cpass,secqtn,secans,filePath);
		Utils u=new Utils();
		if(u.addStudent(student)){
			HttpSession session=request.getSession();
			student=u.validateStudent(cemail, cpass);
			session.setAttribute("student", student);
			String subject="WELCOME TO JOINT EXAMINATION CENTRE";
			String content="Congratulations! You have successfully created your profile at Joint Examination Centre. Please register for the examination as soon as possible in order to book seats at the nearest registered examination centre. Looking forward towards having a fruitful association with you.";
			try{
				Utils.sendEmail(host, port, user, pass, cemail, subject, content);
			}catch(Exception e){
				e.printStackTrace();
			}
			response.sendRedirect("StudentProfile.jsp");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
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
}
