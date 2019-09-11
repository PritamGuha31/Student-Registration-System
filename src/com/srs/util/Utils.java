package com.srs.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.srs.beans.Admin;
import com.srs.beans.Books;
import com.srs.beans.ExamRegistry;
import com.srs.beans.QuestionPapers;
import com.srs.beans.School;
import com.srs.beans.Student;

public class Utils {
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	public boolean addStudent(Student student){
		boolean inserted=false;
		try{
			conn = DBUtils.getConnection("srs");			
			String sql = "insert into student (cname,fname,mname,dob,gender,category,nation,aif,caddress,district,state,cemail,cphone,caadhar,cpass,secqtn,secans,picture) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";			
			pst = DBUtils.getPreparedStatement(sql);			
			pst.setString(1, student.getCname());
			pst.setString(2, student.getFname());
			pst.setString(3, student.getMname());
			pst.setString(4, student.getDob());
			pst.setString(5, student.getGender());
			pst.setString(6, student.getCategory());
			pst.setString(7, student.getNation());
			pst.setLong(8, student.getAif());
			pst.setString(9, student.getCaddress());
			pst.setString(10,student.getDistrict());
			pst.setString(11,student.getState());
			pst.setString(12,student.getCemail());
			pst.setLong(13, student.getCphone());
			pst.setLong(14, student.getCaadhar());
			pst.setString(15, student.getCpass());
			pst.setString(16, student.getSecqtn());
			pst.setString(17, student.getSecans());
			pst.setString(18, student.getPicture());
			int r = pst.executeUpdate();
			//ResultSet rs = pst.getGeneratedKeys();
			
			if(r>0){
				inserted=true;
				//cid=rs.getInt(1);
			}
			
			DBUtils.closeResources();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return inserted;
	}
	
	public Student validateStudent(String email, String pass){
		Student student=null;
		conn=DBUtils.getConnection("srs");
		String sql="select * from student where cemail='"+email+"' and cpass='"+pass+"'";
		stmt = DBUtils.getSimpleStatement();
		try{
			rs=stmt.executeQuery(sql);
			if(rs!=null){
				while(rs.next()){
					student=new Student(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getInt(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getLong(14),rs.getLong(15),rs.getString(16),rs.getString(17),rs.getString(18),rs.getString(20));
					
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		DBUtils.closeResources();
		return student;
	}
	
	public boolean addSchool(School school){
		boolean inserted=false;
		try{
			conn = DBUtils.getConnection("srs");
			
			String sql = "insert into examcentre (name,principal,email,address,locality,pin,city,seats,details,password,status) values (?,?,?,?,?,?,?,?,?,?,?)";
			
			pst = DBUtils.getPreparedStatement(sql);
			
			pst.setString(1, school.getName());
			pst.setString(2, school.getPrincipal());
			pst.setString(3, school.getEmail());
			pst.setString(4, school.getAddress());
			pst.setString(5, school.getLocality());
			pst.setInt(6, school.getPin());
			pst.setString(7, school.getCity());
			pst.setInt(8, school.getSeats());
			pst.setString(9, school.getDetails());
			pst.setString(10, school.getPassword());
			pst.setString(11,school.getStatus());
			
			int r = pst.executeUpdate();
			//ResultSet rs = pst.getGeneratedKeys();
			
			if(r>0){
				inserted=true;
				//cid=rs.getInt(1);
			}
			
			DBUtils.closeResources();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return inserted;
	}
	
	public School validateSchool(String email, String pass){
		School school=null;
		conn=DBUtils.getConnection("srs");
		String sql="select * from examcentre where email='"+email+"' and password='"+pass+"'";
		stmt = DBUtils.getSimpleStatement();
		try{
			rs=stmt.executeQuery(sql);
			if(rs!=null){
				while(rs.next()){
					school=new School(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8),rs.getInt(9),rs.getString(10),rs.getString(11),rs.getString(12));
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		DBUtils.closeResources();
		return school;
	}
	
	public School validateSchoolByID(int id){
		School school=null;
		conn=DBUtils.getConnection("srs");
		String sql="select * from examcentre where schoolid='"+id+"'";
		stmt = DBUtils.getSimpleStatement();
		try{
			rs=stmt.executeQuery(sql);
			if(rs!=null){
				while(rs.next()){
					school=new School(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8),rs.getInt(9),rs.getString(10),rs.getString(11),rs.getString(12));
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		DBUtils.closeResources();
		return school;
	}
	
	public List<QuestionPapers> getAllQuestionPapers(){
		List<QuestionPapers> qtnpapers=new ArrayList<QuestionPapers>();
		conn=DBUtils.getConnection("srs");
		String type="QUESTION";
		String sql="select * from questionpapers where type='"+type+"'";
		stmt = DBUtils.getSimpleStatement();
		try{
			rs = stmt.executeQuery(sql);			
			if(rs != null){
				while(rs.next()){
					QuestionPapers qtnpaper = new QuestionPapers();
					qtnpaper.setId(rs.getInt(1));
					qtnpaper.setTitle(rs.getString(2));
					qtnpaper.setDescription(rs.getString(3));
					qtnpaper.setInputsteam(rs.getAsciiStream(4));
					qtnpaper.setType(rs.getString(5));
					qtnpapers.add(qtnpaper);
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		DBUtils.closeResources();
		return qtnpapers;
	}
	
	public List<QuestionPapers> getAllModelPapers(){
		List<QuestionPapers> modelpapers=new ArrayList<QuestionPapers>();
		conn=DBUtils.getConnection("srs");
		String type="MODEL";
		String sql="select * from questionpapers where type='"+type+"'";
		stmt = DBUtils.getSimpleStatement();
		try{
			rs = stmt.executeQuery(sql);			
			if(rs != null){
				while(rs.next()){
					QuestionPapers modelpaper = new QuestionPapers();
					modelpaper.setId(rs.getInt(1));
					modelpaper.setTitle(rs.getString(2));
					modelpaper.setDescription(rs.getString(3));
					modelpaper.setInputsteam(rs.getAsciiStream(4));
					modelpaper.setType(rs.getString(5));
					modelpapers.add(modelpaper);
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		DBUtils.closeResources();
		return modelpapers;
	}
	
	public List<School> getAllPendingCentres(){
		List<School> centres=new ArrayList<School>();
		conn=DBUtils.getConnection("srs");
		String status1="PENDING";
		String status2="PROCESSING";
		String sql="select * from examcentre where status='"+status1+"' OR status='"+status2+"'";
		stmt = DBUtils.getSimpleStatement();
		try{
			rs = stmt.executeQuery(sql);			
			if(rs != null){
				while(rs.next()){
					School centre = new School();
					centre.setSchoolid(rs.getInt(1));
					centre.setName(rs.getString(2));
					centre.setPrincipal(rs.getString(3));
					centre.setEmail(rs.getString(4));
					centre.setAddress(rs.getString(5));
					centre.setLocality(rs.getString(6));
					centre.setPin(rs.getInt(7));
					centre.setCity(rs.getString(8));
					centre.setSeats(rs.getInt(9));
					centre.setDetails(rs.getString(10));
					centre.setPassword(rs.getString(11));
					centre.setStatus(rs.getString(12));
					centres.add(centre);
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		DBUtils.closeResources();
		return centres;
	}
	
	public School getExaminationCentre(int id){
		School school=null;
		conn=DBUtils.getConnection("srs");
		String sql="select * from examcentre where schoolid='"+id+"'";
		stmt = DBUtils.getSimpleStatement();
		try{
			rs = stmt.executeQuery(sql);			
			if(rs != null){
				while(rs.next()){
					school=new School(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8),rs.getInt(9),rs.getString(10),rs.getString(11),rs.getString(12));
			}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		DBUtils.closeResources();
		return school;
	}
	
	public boolean changeStatus(int id, String s){
		boolean updated = false;
		try{
			conn = DBUtils.getConnection("srs");
			
			String sql = "update examcentre set status=? where schoolid=?";
			
			pst = DBUtils.getPreparedStatement(sql);
			try{
				pst.setString(1, s);
				pst.setInt(2, id);
			}catch(SQLException e){
				e.printStackTrace();
			}
			int r = pst.executeUpdate();
			
			if(r > 0){
				updated = true;
			}
			
			DBUtils.closeResources();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return updated;
	}
	
	public List<School> getAllApprovedCentres(){
		List<School> centres=new ArrayList<School>();
		conn=DBUtils.getConnection("srs");
		String status1="APPROVED";
		String sql="select * from examcentre where status='"+status1+"'";
		stmt = DBUtils.getSimpleStatement();
		try{
			rs = stmt.executeQuery(sql);			
			if(rs != null){
				while(rs.next()){
					School centre = new School();
					centre.setSchoolid(rs.getInt(1));
					centre.setName(rs.getString(2));
					centre.setPrincipal(rs.getString(3));
					centre.setEmail(rs.getString(4));
					centre.setAddress(rs.getString(5));
					centre.setLocality(rs.getString(6));
					centre.setPin(rs.getInt(7));
					centre.setCity(rs.getString(8));
					centre.setSeats(rs.getInt(9));
					centre.setDetails(rs.getString(10));
					centre.setPassword(rs.getString(11));
					centre.setStatus(rs.getString(12));
					centres.add(centre);
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		DBUtils.closeResources();
		return centres;
	}
	
	public boolean addintoRegistry(ExamRegistry er){
		boolean inserted=false;
		try{
			conn=DBUtils.getConnection("srs");
			String sql="insert into examregistry (roll,tenboard,tenyear,tenmarks,twelveboard,twelveyear,twelvemarks,schoolid) values (?,?,?,?,?,?,?,?)";
			pst = DBUtils.getPreparedStatement(sql);
			pst.setInt(1, er.getStudent().getRoll());
			pst.setString(2, er.getTenboard());
			pst.setInt(3, er.getTenyear());
			pst.setString(4, er.getTenmarks());
			pst.setString(5, er.getTwelveboard());
			pst.setInt(6, er.getTwelveyear());
			pst.setString(7, er.getTwelvemarks());
			pst.setInt(8, er.getSchool().getSchoolid());
			int r = pst.executeUpdate();
			if(r>0){
				inserted=true;
			}
			DBUtils.closeResources();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return inserted;
	}
	
	public boolean incrementSeatsBooked(int id){
		int seatsbooked=0,totalseats=0;
		boolean updated=false;
			conn=DBUtils.getConnection("srs");
			String sql="select * from approvedcentres where schoolid='"+id+"'";
			stmt = DBUtils.getSimpleStatement();
			try{
				rs = stmt.executeQuery(sql);
				if(rs != null){
					while(rs.next()){
						seatsbooked=rs.getInt(5);
						totalseats=rs.getInt(4);
					}
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
			if(seatsbooked<totalseats){
				seatsbooked++;
				sql="update approvedcentres set seatsbooked=? where schoolid=?";
				pst=DBUtils.getPreparedStatement(sql);
				try{
					pst.setInt(1, seatsbooked);
					pst.setInt(2, id);
					int r = pst.executeUpdate();
					if(r > 0){
						updated = true;
					}
				}catch(SQLException e){
					e.printStackTrace();
				}
				
			}
			DBUtils.closeResources();
			return updated;
		}
	
	public boolean checkRegistered(int roll){
		boolean present=false;
		conn=DBUtils.getConnection("srs");
		String sql="select * from examregistry where roll='"+roll+"'";
		stmt = DBUtils.getSimpleStatement();
		try{
			rs = stmt.executeQuery(sql);
			if(rs != null){
				while(rs.next()){
					present=true;
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		DBUtils.closeResources();
		return present;
	}
	
	public ExamRegistry getExamInfo(int roll){
		ExamRegistry er=null;
		conn=DBUtils.getConnection("srs");
		String sql="select stu.*,ec.*,er.* from examregistry er,student stu,examcentre ec where stu.roll=er.roll and ec.schoolid=er.schoolid and er.roll='"+roll+"'";
		stmt = DBUtils.getSimpleStatement();
		try{
			rs = stmt.executeQuery(sql);
			if(rs != null){
				while(rs.next()){
					Student student=new Student(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getInt(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getLong(14),rs.getLong(15),rs.getString(16),rs.getString(17),rs.getString(18),rs.getString(20));
					School school=new School(rs.getInt(21),rs.getString(22),rs.getString(23),rs.getString(24),rs.getString(25),rs.getString(26),rs.getInt(27),rs.getString(28),rs.getInt(29),rs.getString(30),rs.getString(31),rs.getString(32));
					er=new ExamRegistry(rs.getInt(33),student,rs.getString(35),rs.getInt(36),rs.getString(37),rs.getString(38),rs.getInt(39),rs.getString(40),school);
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		DBUtils.closeResources();
		return er;
	}
	
	public boolean addApprovedCentre(School school){
		boolean updated=false;
		try{
		conn=DBUtils.getConnection("srs");
		String sql="insert into approvedcentres (schoolid,locality,totalseats,seatsbooked) values (?,?,?,?)";
		pst = DBUtils.getPreparedStatement(sql);
		pst.setInt(1, school.getSchoolid());
		pst.setString(2, school.getLocality());
		pst.setInt(3, school.getSeats());
		pst.setInt(4, 0);
		int r = pst.executeUpdate();
		if(r>0){
			updated=true;
		}
		DBUtils.closeResources();	
	}catch(SQLException e){
		e.printStackTrace();
	}
	return updated;
	}
	
	
	public List<Student> getAllStudentDetails(){
		List<Student> studentdetails=new ArrayList<Student>();
		conn=DBUtils.getConnection("srs");
		String sql="select * from student";
		stmt = DBUtils.getSimpleStatement();
		try{
			rs = stmt.executeQuery(sql);			
			if(rs != null){
				while(rs.next()){
					Student studentdetail = new Student();
					studentdetail.setRoll(rs.getInt(1));
					studentdetail.setCname(rs.getString(2));
					studentdetail.setFname(rs.getString(3));
					studentdetail.setMname(rs.getString(4));
					studentdetail.setDob(rs.getString(5));
					studentdetail.setGender(rs.getString(6));
					studentdetail.setCategory(rs.getString(7));
					studentdetail.setNation(rs.getString(8));
					studentdetail.setAif(rs.getInt(9));
					studentdetail.setCaddress(rs.getString(10));
					studentdetail.setDistrict(rs.getString(11));
					studentdetail.setState(rs.getString(12));
					studentdetail.setCemail(rs.getString(13));
					studentdetail.setCphone(rs.getLong(14));
					studentdetail.setCaadhar(rs.getLong(15));
					studentdetail.setCpass(rs.getString(16));
					studentdetail.setSecqtn(rs.getString(17));
					studentdetail.setSecans(rs.getString(18));
					studentdetail.setPicture(rs.getString(20));
					studentdetails.add(studentdetail);
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		DBUtils.closeResources();
		return studentdetails;
	}
	public Student validateStudentbyRoll(int roll){
		Student student=null;
		conn=DBUtils.getConnection("srs");
		String sql="select * from student where roll='"+roll+"'";
		stmt = DBUtils.getSimpleStatement();
		try{
			rs=stmt.executeQuery(sql);
			if(rs!=null){
				while(rs.next()){
					student=new Student(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getInt(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getLong(14),rs.getLong(15),rs.getString(16),rs.getString(17),rs.getString(18),rs.getString(20));
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		DBUtils.closeResources();
		return student;
	}
	public boolean deleteStudent(int roll){
		boolean updated=false;
		try{
			conn = DBUtils.getConnection("srs");			
			String sql="delete from examregistry where roll='"+roll+"'";
			pst=DBUtils.getPreparedStatement(sql);
			int r=pst.executeUpdate();
			if(r>0){
				sql = "delete from student where roll='"+roll+"'";			
				pst = DBUtils.getPreparedStatement(sql);			
				r = pst.executeUpdate();
			//ResultSet rs = pst.getGeneratedKeys();
				if(r>0){
					updated=true;
				//cid=rs.getInt(1);
				}
			}
				DBUtils.closeResources();			
		}catch(SQLException e){
			e.printStackTrace();
		}		
		return updated;
	}
	
	public static void sendEmail(String host, String port,
			final String userName, final String password, String toAddress,
			String subject, String message) throws AddressException,
			MessagingException {

		// sets SMTP server properties
		Properties properties = new Properties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", port);
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");

		// creates a new session with an authenticator
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		};

		Session session = Session.getInstance(properties, auth);

		// creates a new e-mail message
		Message msg = new MimeMessage(session);

		msg.setFrom(new InternetAddress(userName));
		InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
		msg.setRecipients(Message.RecipientType.TO, toAddresses);
		msg.setSubject(subject);
		msg.setSentDate(new Date());
		msg.setText(message);

		// sends the e-mail
		Transport.send(msg);

	}
	
	public boolean bookBorrowed(int roll){
		boolean result=false;
		conn=DBUtils.getConnection("srs");
		String sql="select bookidborrowed from student where roll='"+roll+"'";
		stmt = DBUtils.getSimpleStatement();
		try{
			rs = stmt.executeQuery(sql);
			if(rs != null){
				while(rs.next()){
					if(rs.getInt(1)==0)
						result=false;
					else 
						result=true;
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		DBUtils.closeResources();
		
		return result;
	}
	
	public List<Books> getAllAvailableBooks(){
		List<Books> allbooks=new ArrayList<Books>();
		conn=DBUtils.getConnection("srs");
		String status1="YES";
		String sql="select * from books where availability='"+status1+"'";
		stmt = DBUtils.getSimpleStatement();
		try{
			rs = stmt.executeQuery(sql);			
			if(rs != null){
				while(rs.next()){
					Books book = new Books();
					book.setBookid(rs.getInt(1));
					book.setBookname(rs.getString(2));
					book.setAuthor(rs.getString(3));
					book.setSubject(rs.getString(4));
					book.setPath(rs.getString(5));
					allbooks.add(book);
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		DBUtils.closeResources();
		return allbooks;
	}
	
	public boolean borrowBook(int bookid, int roll){
		int r=0,r1=0,r2=0;
		boolean res=false;
		conn=DBUtils.getConnection("srs");
		String sql="insert into libraryregister (roll,book_id,borrow_date,due_date) values (?, ?, now(), DATE_ADD(now(),INTERVAL 1 MONTH))";
		pst = DBUtils.getPreparedStatement(sql);
		try{
		pst.setInt(1, roll);
		pst.setInt(2, bookid);
		r = pst.executeUpdate();
		sql="update student set bookidborrowed='"+bookid+"' where roll='"+roll+"'";
		pst=DBUtils.getPreparedStatement(sql);
		r1=pst.executeUpdate();
		String avail="NO";
		sql="update books set availability='"+avail+"' where book_id='"+bookid+"'";
		pst=DBUtils.getPreparedStatement(sql);
		r2=pst.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		if(r>0 && r1>0 && r2>0)
			res=true;
		return res;
		}
	
	public String borrowedBook(int roll){
		int bookid=0;
		String bookname="";
		conn=DBUtils.getConnection("srs");
		String sql="select bookidborrowed from student where roll='"+roll+"'";
		stmt = DBUtils.getSimpleStatement();
		try{
			rs = stmt.executeQuery(sql);
			if(rs != null){
				while(rs.next()){
					bookid=rs.getInt(1);
				}
			}
			if(bookid!=0){
				sql="select book_name from books where book_id='"+bookid+"'";
				stmt = DBUtils.getSimpleStatement();
				rs=stmt.executeQuery(sql);
				if(rs!=null){
					while(rs.next()){
						bookname=rs.getString(1);
					}
				}
			}else
				bookname="No book borrowed";
		}catch(SQLException e){
			e.printStackTrace();
		}
		DBUtils.closeResources();
		return bookname;
	}
	
	public int getBookIDFromRoll(int roll){
		int id=0;
		conn=DBUtils.getConnection("srs");
		String sql="select bookidborrowed from student where roll='"+roll+"'";
		stmt = DBUtils.getSimpleStatement();
		try{
			rs = stmt.executeQuery(sql);
			if(rs != null){
				while(rs.next()){
					id=rs.getInt(1);
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		DBUtils.closeResources();
		
		return id;
	}
	
	public Books getBook(int id){
		Books book=null;
		conn=DBUtils.getConnection("srs");
		String sql="select * from books where book_id='"+id+"'";
		stmt = DBUtils.getSimpleStatement();
		try{
			rs = stmt.executeQuery(sql);
			if(rs != null){
				while(rs.next()){
					book=new Books(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		DBUtils.closeResources();
		return book;
	}
	
	public boolean returnBook(int roll, int bookid){
		boolean res=false;
		int r1=0, r2=0;
		conn=DBUtils.getConnection("srs");
		try{
			String sql="update student set bookidborrowed=0 where roll='"+roll+"'";
			pst=DBUtils.getPreparedStatement(sql);
			r1=pst.executeUpdate();
			String avail="YES";
			sql="update books set availability='"+avail+"' where book_id='"+bookid+"'";
			pst=DBUtils.getPreparedStatement(sql);
			r2=pst.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		if(r1>0 && r2>0)
			res=true;
		return res;
	}
	
	public List<Books> getAllBorrowedBooks(){
		List<Books> books=new ArrayList<Books>();
		conn=DBUtils.getConnection("srs");
		String status1="NO";
		String sql="select * from books where availability='"+status1+"'";
		stmt = DBUtils.getSimpleStatement();
		try{
			rs = stmt.executeQuery(sql);			
			if(rs != null){
				while(rs.next()){
					Books book = new Books();
					book.setBookid(rs.getInt(1));
					book.setBookname(rs.getString(2));
					book.setAuthor(rs.getString(3));
					book.setSubject(rs.getString(4));
					book.setPath(rs.getString(5));
					books.add(book);
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		DBUtils.closeResources();
		return books;
	}
	
	public String getStudentFromBook(int id){
		String name="";
		conn=DBUtils.getConnection("srs");
		String sql="select cname from student where bookidborrowed='"+id+"'";
		stmt = DBUtils.getSimpleStatement();
		try{
			rs = stmt.executeQuery(sql);
			if(rs != null){
				while(rs.next()){
					name=rs.getString(1);
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		DBUtils.closeResources();
		return name;
	}
	
	public String getDueDate(int id){
		int roll=0;
		String date="";
		conn=DBUtils.getConnection("srs");
		String sql="select roll from student where bookidborrowed='"+id+"'";
		stmt = DBUtils.getSimpleStatement();
		try{
			rs = stmt.executeQuery(sql);
			if(rs != null){
				while(rs.next()){
					roll=rs.getInt(1);
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		sql="select due_date from libraryregister where roll='"+roll+"' AND book_id='"+id+"'";
		stmt = DBUtils.getSimpleStatement();
		try{
			rs = stmt.executeQuery(sql);
			if(rs != null){
				while(rs.next()){
					date=rs.getString(1);
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return date;
	}
	
	public int getRollFromBook(int id){
		int roll=0;
		conn=DBUtils.getConnection("srs");
		String sql="select roll from student where bookidborrowed='"+id+"'";
		stmt = DBUtils.getSimpleStatement();
		try{
			rs = stmt.executeQuery(sql);
			if(rs != null){
				while(rs.next()){
					roll=rs.getInt(1);
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		DBUtils.closeResources();
		return roll;
	}
	
	public List<School> allAvailableSchools(){
		List<School> centres=new ArrayList<School>();
		conn=DBUtils.getConnection("srs");
		String status1="APPROVED";
		String sql="select * from examcentre e, approvedcentres a where status='"+status1+"' and seatsbooked < totalseats and e.schoolid = a.schoolid";
		stmt = DBUtils.getSimpleStatement();
		try{
			rs = stmt.executeQuery(sql);			
			if(rs != null){
				while(rs.next()){
					School centre = new School();
					centre.setSchoolid(rs.getInt(1));
					centre.setName(rs.getString(2));
					centre.setPrincipal(rs.getString(3));
					centre.setEmail(rs.getString(4));
					centre.setAddress(rs.getString(5));
					centre.setLocality(rs.getString(6));
					centre.setPin(rs.getInt(7));
					centre.setCity(rs.getString(8));
					centre.setSeats(rs.getInt(9));
					centre.setDetails(rs.getString(10));
					centre.setPassword(rs.getString(11));
					centre.setStatus(rs.getString(12));
					centres.add(centre);
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		DBUtils.closeResources();
		return centres;
	}
	
	public boolean changeExaminationCentre(int oldschoolid, int newschoolid, int roll){
		boolean res=false;
		int r1=0, r2=0, r3=0;
		int seatsbooked=0,totalseats=0;
		conn=DBUtils.getConnection("srs");
		try{
			String sql="update examregistry set schoolid='"+newschoolid+"' where roll='"+roll+"'";
			pst=DBUtils.getPreparedStatement(sql);
			r1=pst.executeUpdate();
			String sql1="select * from approvedcentres where schoolid='"+oldschoolid+"'";
			stmt = DBUtils.getSimpleStatement();
			try{
				rs = stmt.executeQuery(sql1);
				if(rs != null){
					while(rs.next()){
						seatsbooked=rs.getInt(5);
					}
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
			seatsbooked--;
			sql="update approvedcentres set seatsbooked='"+seatsbooked+"' where schoolid='"+oldschoolid+"'";
			pst=DBUtils.getPreparedStatement(sql);
			r2=pst.executeUpdate();
			sql1="select * from approvedcentres where schoolid='"+newschoolid+"'";
			stmt = DBUtils.getSimpleStatement();
			try{
				rs = stmt.executeQuery(sql1);
				if(rs != null){
					while(rs.next()){
						seatsbooked=rs.getInt(5);
						totalseats=rs.getInt(4);
					}
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
			if(seatsbooked<totalseats){
			seatsbooked++;
			sql="update approvedcentres set seatsbooked='"+seatsbooked+"' where schoolid='"+newschoolid+"'";
			pst=DBUtils.getPreparedStatement(sql);
			r3=pst.executeUpdate();
		}
		}catch(SQLException e){
			e.printStackTrace();
		}
		if(r1>0 && r2>0 && r3>0)
			res=true;
		return res;
	}
	
	public Admin validateAdmin(String adminid, String pass){
		Admin admin=null;
		conn=DBUtils.getConnection("srs");
		String sql="select * from admin where adminid='"+adminid+"' and adminpass='"+pass+"'";
		stmt = DBUtils.getSimpleStatement();
		try{
			rs=stmt.executeQuery(sql);
			if(rs!=null){
				while(rs.next()){
					admin=new Admin(rs.getString(1),rs.getString(2));
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		DBUtils.closeResources();
		return admin;
	}
}