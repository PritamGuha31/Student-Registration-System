<%@page import="com.srs.beans.Student" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
</head>
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
      
      	<%
		Student student= (Student)session.getAttribute("student");
	if(student == null){
		response.sendRedirect("Home.jsp");
	}
%>

	<form action="update" method="POST">
        
         <div class="form_settings">
           <p><span> Candidate's Name: </span><input class="contact" type="text" name="cname" value=<%= student.getCname() %> required/></p>
            <p><span> Father's Name: </span><input class="contact" type="text" name="fname" value=<%=student.getFname() %> required/></p>
            <p><span> Mother's Name: </span><input class="contact" type="text" name="mname" value=<%= student.getMname() %> required/></p>
            <p><span>DOB: </span><input class="contact" type="text" name="cdob" value=<%= student.getDob() %> placeholder="YYYY-MM-DD" required/></p>
            <p><span> Gender: </span> <select name="gender"><option value="default">Select gender...</option>
            												<option value="male">Male</option>
            												<option value="female">Female</option>
            												<option value="others">Others </option></select>
            <p><span> Category: </span> <select name="category"><option value="default">Select category...</option>
            												<option value="general">General</option>
            												<option value="sc">SC</option>
            												<option value="st">ST</option>
            												<option value="obc">OBC</option></select>
            <p><span> Nationality: </span><input class="contact" type="text" name="nation" value=<%= student.getNation() %> required/></p>
            <p><span> Annual Family Income: </span><input class="contact" type="text" name="afi" value= <%= student.getAif() %> required/></p>
            </br>
            <div class="horizontal-line"></div></br>
            
            <p><span>Address: </span><textarea class="contact textarea" rows="4" cols="50" name="caddress" required><%= student.getCaddress() %></textarea></p>
            <p><span> District: </span><input class="contact" type="text" name="district" value=<%= student.getDistrict() %> required/></p>
            <p><span> State: </span><input class="contact" type="text" name="state" value=<%= student.getState()%> required/></p>
            <p><span>Email: </span><input class="contact" type="email" name="cemail" value=<%= student.getCemail()%> required/></p>
            <p><span>Phone: </span><input class="contact" type="number" name="cphone" value=<%= student.getCphone()%> required/></p>
            <p><span>Aadhaar Number: </span><input class="contact" type="number" name="caadhar" value=<%= student.getCaadhar()%> required/></p>
            </br>
            <div class="horizontal-line"></div></br>
            
            <p><span>Password: </span><input class="contact" type="password" name="cpass" value=<%= student.getCpass()%> required/></p>
            <p><span> Security Question: </span> <select name="secqtn"><option value=<%= student.getSecqtn() %>>Select security question...</option>
            												<option value="qtn1">What is your nickname?</option>
            												<option value="qtn2">What is your favourite sport?</option>
            												<option value="qtn3">What primary school did you attend?</option>
            												<option value="qtn4">What is your mother's maiden name?</option></select>
            <p><span> Answer: </span><input class="contact" type="text" name="secans" value=<%= student.getSecans() %> required/></p>
            </br>
            <div class="horizontal-line"></div></br>
            <p style="padding-top: 15px"><span>&nbsp;</span><input class="submit" type="submit" name="contact_submitted" value="Register" /></p>
          </div> 
          <br>
        </form>
      
      </div>
	<div class="ruler"></div>
	 
    </div>
      
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