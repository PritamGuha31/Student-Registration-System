<%@page import="com.srs.beans.Student" %>
<%@page import="com.srs.util.Utils" %>
<%@page import="com.srs.beans.ExamRegistry" %>
<%@page import="java.util.Date" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>WELCOME</title>
<style type="text/css">

.form_settings
{ margin: 15px 0 0 0;
}

.form_settings p
{ padding: 0 0 4px 0;}

.form_settings span
{ float: left; 
  width: 200px; 
  text-align: left;}
  
.form_settings input, .form_settings textarea
{ padding: 5px; 
  width: 299px; 
  font: 100% arial; 
  border: 1px solid #E5E5DB; 
  background: #FFF; 
  color: #47433F;}
  
.form_settings .submit
{ font: 100% arial; 
  border: 0; 
  width: 99px; 
  margin: 0 0 0 212px; 
  height: 33px;
  padding: 2px 0 3px 0;
  cursor: pointer; 
  background: #3B3B3B; 
  color: #FFF;}

.form_settings textarea, .form_settings select
{ font: 100% arial; 
  width: 299px;}

.form_settings select
{ width: 310px;}

.form_settings .checkbox
{ margin: 4px 0; 
  padding: 0; 
  width: 14px;
  border: 0;
  background: none;}
  .horizontal-line {
        width: 1200px;
        border: 1px solid black;
        height: 1px
    }
    #sidebar_container
{ float: left;
  width: 224px;}

.sidebar_top
{ width: 222px;
  height: 14px;
  background: transparent url(side_top.png) no-repeat;}

.sidebar_base
{ width: 222px;
  height: 14px;
  background: url(side_base.png) no-repeat;}

.sidebar
{ float: right;
  width: 222px;
  padding: 0;
  margin: 0 0 16px 0;}

.sidebar_item
{ background: url(side_back.png) repeat-y;
  padding: 0 15px;
  width: 192px;
  border: solid black 1px;}

.sidebar li a.selected
{ color: #444;} 

.sidebar ul
{ margin: 0;} 
 </style>
<!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/custom-styles.css" rel="stylesheet">
    <link href="css/image-effects.css" rel="stylesheet">
	
	   <link href="css/normalize.css" rel="stylesheet">
		 <link href="css/component.css" rel="stylesheet">
      <link rel="stylesheet" href="css/font-awesome.css">
      <link rel="stylesheet" href="css/font-awesome-ie7.css">
	  
    <script src="js/html5shiv.js"></script>
      <script src="js/respond.min.js"></script>
	  <script src="js/modernizr.custom.js"></script>
	  
	   <link rel="stylesheet" href="js/fancybox/jquery.fancybox.css" type="text/css" media="screen" /> 
<!-- <link href="css/style.css" rel="stylesheet" type="text/css"> --> 
 <link href="css/font-awesome.css" rel="stylesheet" type="text/css"> 
<link href="css/animate.css" rel="stylesheet" type="text/css"> 

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	  
</head>
<%
	Student student=(Student)session.getAttribute("student");
	if(student==null)
		response.sendRedirect("Home.jsp");
	Utils u=new Utils();
	boolean res=u.checkRegistered(student.getRoll());
	boolean book=u.bookBorrowed(student.getRoll());
%>
<body>
<div class="container page-styling">
    <div class="header-wrapper">
      <div class="site-name">
        <h1>Joint Examination Centre</h1>
      </div>
      <div class="menu">
        <div class="navbar">
         
            <div class="navbar-header">
              <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
            </div>
            <div class="navbar-collapse collapse">
              <ul class="nav navbar-nav ">
                <li><a href="Home.jsp">Home</a></li>
                <li class="dropdown ">
              <a href="#" class="dropdown-toggle active" data-toggle="dropdown">Information <b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li><a href="InformationBrochure.jsp">Information Brochure</a></li>
                <li><a href="ImportantDates.jsp">Important Dates</a></li>
                <li><a href="Admission.jsp">Admission Process</a></li>
              </ul>
            </li>
            <li><a href="About.jsp">About</a></li>
                <li><a href="examrules.jsp">Exam Rules</a></li>
                <li><a href="contactus.jsp">Contact Us</a></li>
              </ul>

            </div><!--/.navbar-collapse -->

          </div>
          <div class="mini-menu">
            <label>
          <select class="selectnav">
            <option value="#" selected="">Home</option>
            <option value="#">About</option>
            <option value="#">→ Another action</option>
            <option value="#">→ Something else here</option>
            <option value="#">→ Another action</option>
            <option value="#">→ Something else here</option>
            <option value="#">Services</option>
            <option value="#">Portfolio</option>
            <option value="#">Contact</option>
          </select>
          </label>
          </div>
    </div>
      </div>
     <div class="content-wrap" >
     	<%@ include file="Navbar.jsp" %>
     	
     	<h1>Welcome <%= student.getCname() %> </h1>
     	<section id="aboutUs"><!--Aboutus-->
<div class="inner_wrapper aboutUs-container fadeInLeft animated wow">
  <div class="container">
    
    <div class="inner_section"> 
	  <div class="row">
			<div class="col-lg-12 about-us">
				<div class="row">
					<div class="col-md-6"> 
						<% String path= student.getPicture();
					int len= path.length();
					String path1=path.substring(path.lastIndexOf("\\"));
						//out.println(path1);
					%>
					<img class="img-responsive" src="Profile Pictures/<%=path1%>" height="300" width="250"> </div><!-- /.col-md-6 -->
						<div class="col-md-6">
								<ul style="font-size: 20px">
										<ol><span class="glyphicon glyphicon-sound-5-1"></span> Roll Number: <%= student.getRoll() %></ol>
										<ol><span class="glyphicon glyphicon-user"></span> Name: <%= student.getCname() %> </ol>
										<ol><span class="glyphicon glyphicon-king"></span> Father's Name: <%= student.getFname() %> </ol>
                                        <ol><span class="glyphicon glyphicon-queen"></span> Mother's Name: <%= student.getMname() %> </ol>
										<ol><span class="glyphicon glyphicon-calendar"></span> DOB: <%= student.getDob() %></ol>
										<ol><span class="glyphicon glyphicon-ok-sign"></span> Gender: <%= student.getGender() %></ol>
										<ol><span class="glyphicon glyphicon-ok"></span> Category: <%= student.getCategory() %></ol>
										<ol><span class="glyphicon glyphicon-flag"></span> Nationality: <%= student.getNation() %></ol>
										<ol><span class="glyphicon glyphicon-usd"></span> Annual Family Income: INR <%= student.getAif() %></ol>
										<ol><span class="glyphicon glyphicon-home"></span> Address: <%= student.getCaddress() %></ol>
										<ol><span class="glyphicon glyphicon-map-marker"></span> District: <%= student.getDistrict() %></ol>
										<ol><span class="glyphicon glyphicon-globe"></span> State: <%= student.getState() %></ol>
										<ol><span class="glyphicon glyphicon-phone"></span> Contact Number: <%= student.getCphone() %></ol>
										<ol><span class="glyphicon glyphicon-barcode"></span> Aadhar Number: <%= student.getCaadhar() %></ol>
										
										
									</ul><!-- /.about-us-list -->
								 
								</div><!-- /.col-md-6 -->
								
							</div><!-- /.row -->	
						</div><!-- /.col-lg-12 -->
					</div>
      
    </div>
  </div> 
  </div>
</section>
<%
	if(book==false){
%>
<font color="RED"><h4>You have not borrowed any books. <a href="BorrowBook.jsp" class="btn btn-info" role="button">Click Here to Borrow</a></h4></font>
     <% }else{ 
     	String duedate = u.getDueDate(u.getBookIDFromRoll(student.getRoll()));
     	String pattern = "yyyy-MM-dd";
     	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
     	Date date = simpleDateFormat.parse(duedate);
     	Date today = new Date();
     	int num = today.compareTo(date);
     	if(num<0){
     %>
     <font color="BLUE"><h3>You have borrowed <%= u.borrowedBook(student.getRoll()) %>. Read it <a href="readBook?bookid=<%= u.getBookIDFromRoll(student.getRoll()) %>">here</a>. </h3></font>
	 <% }else{ %>
	 <font color="BLUE"><h4>You had borrowed <%= u.borrowedBook(student.getRoll()) %>. But the due date is over. Return it by clicking <a href="returnBook?bookid=<%= u.getBookIDFromRoll(student.getRoll()) %>">here</a>.</h4></font>
<% } } %>
		
<br>
<%
	if(res==true){
		ExamRegistry er=u.getExamInfo(student.getRoll());%>
	<font color="RED"><marquee direction="right"><h3>You have already registered for Joint Examination.</h3></marquee></font>
		<ul class="list-group">
  <li class="list-group-item">Roll: <%= er.getStudent().getRoll() %></li>
  </ul>
  <h4>CLASS 10 INFORMATION </h4>
  <ul class="list-group">
  <li class="list-group-item list-group-item-success"> BOARD: <%= er.getTenboard() %> </li>
  <li class="list-group-item list-group-item-info"> YEAR OF PASSING: <%= er.getTenyear() %></li>
  <li class="list-group-item list-group-item-warning"> MARKS %: <%= er.getTenmarks() %></li>
  </ul>
  <h4>CLASS 12 INFORMATION </h4>
  <ul class="list-group">
  <li class="list-group-item list-group-item-success"> BOARD: <%= er.getTwelveboard() %> </li>
  <li class="list-group-item list-group-item-info"> YEAR OF PASSING: <%= er.getTwelveyear() %></li>
  <li class="list-group-item list-group-item-warning"> MARKS %: <%= er.getTwelvemarks() %></li>
  </ul>
  <ul class="list-group">
  <li class="list-group-item list-group-item-danger">Your examination centre is <%=er.getSchool().getName() %>.</li>
  <li class="list-group-item list-group-item-warning"> If you want to change your examination centre, press <a href="ChangeExaminationCentre.jsp"> here</a>.</li>
</ul>
		<%
	}else{%>
	<font color="RED"><h4>You have not registered for Joint Examination. <a href="RegisterExam.jsp" class="btn btn-info" role="button">Register Here</a></h4></font>
     <% } %>	
     </div>
     <div class="ruler"></div>
	 
    </div>      
    <div class="content-wrap centering">
        </div>
		<div class="ruler"></div>
	<div class="container">
	<div class="copy-rights">
		Copyright(c) 2017 Joint Examination Centre <br> All rights reserved. <br /> Designed by: Pritam Guha, Koustav Chakraborty, R.Mahesh Kumar.
	</div>
	</div>
    
    

     


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="js/jquery-1.9.1.js"></script>
    <script src="js/bootstrap.js"></script>
    <script src="js/modernizr-2.6.2-respond-1.1.0.min.js"></script>
     <script src="js/masonry.pkgd.min.js"></script>
    <script src="js/imagesloaded.js"></script>
    <script src="js/classie.js"></script>
    <script src="js/AnimOnScroll.js"></script>
    
    <script>
      new AnimOnScroll( document.getElementById( 'grid' ), {
        minDuration : 0.4,
        maxDuration : 0.7,
        viewportFactor : 0.2
      } );
    </script>
      
</body>
</html>