<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.srs.beans.QuestionPapers" %>
<%@page import="com.srs.util.Utils" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>DOWNLOAD QUESTION PAPERS</title>
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
	  
	  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<%
	List<QuestionPapers> qtnpapers = new ArrayList<QuestionPapers>();
	Utils u=new Utils();
	qtnpapers=u.getAllQuestionPapers();
%>
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
      	<h1> DOWNLOAD QUESTION PAPERS </h1>
      	<div class="container">
  			<table class="table">
    			<thead>
      				<tr>
        				<th>ID</th>
        				<th>Title</th>
        				<th>Description</th>
        				<th></th>
      				</tr>
    			</thead>
    			<tbody>
      				<tr>
      				<%
      					if(!qtnpapers.isEmpty()){
      						for(QuestionPapers qpr : qtnpapers){
      				%>
        			<td><%= qpr.getId() %></td>
        			<td><%= qpr.getTitle() %></td>
        			<td><%= qpr.getDescription() %> </td>
        			<td><a href="downloadquestionpaper?id=<%=qpr.getId()%>"> DOWNLOAD </a></td>
      </tr>
      <%
      		}
      	}
      	%>
      	
    </tbody>
  </table>
</div>
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