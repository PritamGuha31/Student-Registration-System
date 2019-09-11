<%@page import="com.srs.beans.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HOME</title>
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
<%
Student student=(Student)session.getAttribute("student");
if(student!=null)
	response.sendRedirect("StudentProfile.jsp");
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
      <div class="banner">
          <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
  <!-- Wrapper for slides -->
  <div class="carousel-inner">
    <div class="item active">
      <img src="img/banner-img.jpg" alt="" class="">
      <img src="coverpic.jpg" alt="" class="">
        <div class="carousel-caption">
          <i class="fw-icon-pencil"></i>
        <h2 style="color: #FFFFFF">Welcome to Joint Examination Centre</h2>
        <h1 style="color: #FFFFFF">Register for the Examination here</h1>
        <a href="Reg1.jsp" class="btn"> Register</a>
      </div>
    </div>
    <div class="item">
      <img src="img/coverpic.jpg" alt="">
      <div class="carousel-caption">
          <i class="fw-icon-pencil"></i>
        <h2 style="color: #000000">Welcome to Joint Examination Centre</h2>
        <h1 style="color: #000000">Register to become an Examination centre here</h1>
        <a href="ExaminationCentreRegister.jsp" class="btn"> Register </a>
      </div>
    </div>
    <div class="item">
      <img src="img/coverpic2.jpg" alt="">
      <div class="carousel-caption">
          <i class="fw-icon-pencil"></i>
        <h2 style="color: #FFFFFF">Welcome to Joint Examination Centre</h2>
        <h1 style="color: #FFFFFF">Changing the face of education</h1>
		<!-- <a href="#" class="btn"> Login/Register </a> -->
        </div>
    </div>
  </div>

  <!-- Controls -->
  <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left"></span>
  </a>
  <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right"></span>
  </a>
</div>
      </div>
      <div class="content-wrap">
        <div class="main-title">
          <ul class="grid effect-8" id="grid">
            <li >
          <h4 style="font-size: 35px">"Education is the most powerful weapon <br> <br /> which you can use to change the world"</h4>
                   <h1><br /> Nelson Mandela</h1>
            </li>
          </ul>
          
        </div>
      </div>
      <div class="lines">
        <div class="more-btn">
          <a href="About.jsp" class="btn">Know More About Us</a>
        </div>
      </div>
      <div class="content-wrap">
        
        <div class="main-title spacing-bt">
          <ul class="grid effect-8" id="grid">
            <li><h1>Joint Examination Centre</h1>
          <h4>An initiative of the Central Board of Secondary Education<br> Celebrating over 50 years of excellence and producing gems</h4></li>
          </ul>
          
        </div>
      <div class="row">

      <div class="featured-block">
        
        <div class="col-md-4">
        <div class="icon-btn">
          <i class="fw-icon-pencil icon"></i>
        </div>
        <div class="block">
          <h5>Download past question papers</h5>
          <p>All the past question papers of Joint Examination at one place to serve you better and prepare you better. </p>
          <a href="DownloadQuestionPapers.jsp" class="more"> Download <i class="fw-icon-chevron-right"></i></a>
        </div>
        </div>
      </div>
      <div class="featured-block">
        <div class="col-md-4">
        <div class="icon-btn">
          <i class="fw-icon-group icon"></i>
        </div>
        <div class="block">
          <h5>Download model question papers</h5>
          <p>Model Question papers prepared by teachers of over 10 years experience to help you in your endeavour. </p>
          <a href="DownloadModelPapers.jsp" class="more"> Download<i class="fw-icon-chevron-right"></i></a>
        </div>
        </div>
      </div>
      <div class="featured-block">
        <div class="col-md-4">
        <div class="icon-btn">
          <i class="fw-icon-wrench icon"></i>
        </div>
        <div class="block">
          <h5> LOGIN </h5>
          <p> <br /> Have already registered? Check your registration profile here <br /> <br /> </p>
          <%@include file="Login.jsp" %>
          <a href="#" data-toggle='modal' data-target='#myModal' class="more"> STUDENTS <i class="fw-icon-chevron-right"></i></a>
          |<%@include file="ExamCentreLogin.jsp" %><a href="#" data-toggle='modal' data-target='#examcentreModal' class="more"> EXAM CENTRES <i class="fw-icon-chevron-right"></i></a>
        </div>
        </div>
      </div>
      </div>
      </div>
      <div class="ruler"></div>
      <div class="content-wrap centering">
        <div class="main-title spacing-bt">
          <ul class="grid effect-8" id="grid">
              <li><h1> FROM THE DESK </h1>
                  <h4>Message from our Chairman, Controller and Head of Operations</h4>
            </li>
          </ul>  
        </div>
        <div class="featured-items">
          <ul class="grid effect-2" id="grid">
            <li>
              <div class="item">
            <h5>From the <br> Chairman</h5>
          <div class="grow">
            <img src="img/CM.jpg" alt="">
           </div>
            <p> Dear candidates, <br /> Enginnering is an important and learned profession. Engineers are vital to our economy and society. Their knowledge and skills are...</p>
            <p><a href="#" class="more"> read more <i class="fw-icon-chevron-right"></i></a></p>
          </div>
            </li>
            <li>
              <div class="item">
            <h5>From the <br> Controller</h5>
            <div class="grow">
            <img src="img/principal.jpg" alt="">
            </div>
            <p>What is education? Is it book-learning? No. Is it diverse knowledge? Not even that. The training by which the current and expression of will are...</p>
            <p><a href="#" class="more"> read more <i class="fw-icon-chevron-right"></i></a></p>
          </div>
            </li>
            <li>
              <div class="item">
            <h5>From the<br> Head of Operations</h5>
            <div class="grow">
            <img src="img/principal2.jpg" alt="">
            </div>
            <p>Education plays a vital role in shaping tomorrows’ leaders. Not only can we become a better nation by acquiring the skills necessary to be...</p>
            <p><a href="#" class="more"> read more <i class="fw-icon-chevron-right"></i></a></p>
          </div>
            </li>
          </ul>
          
          
          
        </div>
        </div>
		<div class="ruler"></div>
	 
    </div>      
    <div class="content-wrap centering">
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