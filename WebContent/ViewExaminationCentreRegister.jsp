<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.srs.beans.School" %>
<%@page import="com.srs.util.Utils" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EXAMINATION CENTRES</title>
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
      
      <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
      
    <script src="js/html5shiv.js"></script>
      <script src="js/respond.min.js"></script>
	  <script src="js/modernizr.custom.js"></script>
</head>
<body>
<%
	List<School> pendingcentres = new ArrayList<School>();
	Utils u=new Utils();
	pendingcentres=u.getAllPendingCentres();
	List<School> approvedcentres = new ArrayList<School>();
	approvedcentres=u.getAllApprovedCentres();
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
                <li><a href="AdminHome.jsp">Home</a></li>
              <li><a href="logout">Logout</a></li>
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
      	<h4> CENTRES PENDING VERIFICATION </h4>
      		<table class="table table-striped">
    <thead>
      <tr>
        <th>Centre ID</th>
        <th>Name</th>
        <th>Principal</th>
        <th> Email  </th>
        <th> Status </th>
      </tr>
    </thead>
    <tbody>
      <tr>
      <%
      		if(!pendingcentres.isEmpty()){
    			for(School pendingcentre : pendingcentres){
    	%>
        <td><%= pendingcentre.getSchoolid() %></td>
        <td><%= pendingcentre.getName() %></td>
        <td><%= pendingcentre.getPrincipal() %></td>
        <td><%= pendingcentre.getEmail() %></td>
        <td><%= pendingcentre.getStatus() %>
      </tr>
      <%
      		}
      	}
      	%>
      </tbody>
      </table>
      
      <h4> ENTER CENTRE ID TO CHANGE THE STATUS </h4>
      <form action="changeStatus" method="POST">
        <div class="form_settings">
      <p><span> School ID: </span><input class="contact" type="text" name="id" value="" required/></p>
      <p style="padding-top: 15px"><span>&nbsp;</span><input class="submit" type="submit" name="contact_submitted" value="Submit" /></p>
      </div>
      <br>
      <h4>LIST OF APPROVED EXAMINATION CENTRES</h4>
      <table class="table table-striped">
    <thead>
      <tr>
        <th>Centre ID</th>
        <th>Name</th>
        <th>Principal</th>
        <th> Email  </th>
        <th> Status </th>
      </tr>
    </thead>
    <tbody>
      <tr>
      <%
      		if(!approvedcentres.isEmpty()){
    			for(School approvedcentre : approvedcentres){
    	%>
        <td><%= approvedcentre.getSchoolid() %></td>
        <td><%= approvedcentre.getName() %></td>
        <td><%= approvedcentre.getPrincipal() %></td>
        <td><%= approvedcentre.getEmail() %></td>
        <td><%= approvedcentre.getStatus() %>
      </tr>
      <%
      		}
      	}
      	%>
      </tbody>
      </table>
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