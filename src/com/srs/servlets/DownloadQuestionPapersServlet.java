package com.srs.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/downloadquestionpaper")
public class DownloadQuestionPapersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int BUFFER_SIZE = 4096;   
    
    // database connection settings
    private String dbURL = "jdbc:mysql://localhost:3306/srs";
    private String dbUser = "root";
    private String dbPass = "root123";
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    		int id=Integer.parseInt(request.getParameter("id"));
    		Connection conn = null; // connection to the database
            
            try {
                // connects to the database
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
     
                // queries the database
                String sql = "SELECT * FROM questionpapers WHERE id = ?";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setInt(1, id);
     
                ResultSet result = statement.executeQuery();
                if (result.next()) {
                    // gets file name and file blob data
                    String fileName = result.getString("title");
                    String description=result.getString("description");
                    Blob blob = result.getBlob("file");
                    InputStream inputStream = blob.getBinaryStream();
                    int fileLength = inputStream.available();
                     
                    System.out.println("fileLength = " + fileLength);
     
                    ServletContext context = getServletContext();
     
                    // sets MIME type for the file download
                    String mimeType = context.getMimeType(fileName);
                    if (mimeType == null) {        
                        mimeType = "application/octet-stream";
                    }              
                     
                    // set content properties and header attributes for the response
                    response.setContentType(mimeType);
                    response.setContentLength(fileLength);
                    String headerKey = "Content-Disposition";
                    String headerValue = String.format("attachment; filename=\"%s\"", fileName);
                    response.setHeader(headerKey, headerValue);
     
                    // writes the file to the client
                    OutputStream outStream = response.getOutputStream();
                     
                    byte[] buffer = new byte[BUFFER_SIZE];
                    int bytesRead = -1;
                     
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outStream.write(buffer, 0, bytesRead);
                    }
                     
                    inputStream.close();
                    outStream.close();             
                } else {
                    // no file found
                    response.getWriter().print("File not found for the id: " + id);  
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                response.getWriter().print("SQL Error: " + ex.getMessage());
            } catch (IOException ex) {
                ex.printStackTrace();
                response.getWriter().print("IO Error: " + ex.getMessage());
            } finally {
                if (conn != null) {
                    // closes the database connection
                    try {
                        conn.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }          
            }
    		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
