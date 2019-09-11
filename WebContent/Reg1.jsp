<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>REGISTER</title>
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
	  
	  <script type="text/javascript">
	  	function validate(){
	  		var phone = document.registerForm.cphone.value;
	  		var aadhar = document.registerForm.caadhar.value;
	  		var password = document.registerForm.cpass.value;
	  		var decimal=  /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,15}$/; 		
	  		if(phone.length!=10){
	  			alert("Phone number must consist of 10 digits.");
	  			document.registerForm.cphone.focus();
	  			return false;
	  		}
	  		if(aadhar.length != 12){
	  			alert("Aadhar number must consist of 12 digits.");
	  			document.registerForm.caadhar.focus();
	  			return false;	
	  		}
	  		if(!decimal.test(password)){
	  			alert("Password must contain at least one number (0-9), one lowercase letter (a-z), one uppercase letter (A-Z), one special character");
	  			document.registerForm.cpass.focus();
	  			return false;
	  		} 
	  	}
	  </script>
</head>
<body onload='document.registerForm.cname.focus()'>
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
      <h1 align="center">REGISTER FOR THE EXAMINATION</h1></br>
      <h3 align="center">STEP 1: PERSONAL DETAILS</h3>
        <form name="registerForm" action="register_request" method="POST" enctype="multipart/form-data">
        <div class="form_settings">
            <p><span> Candidate's Name: </span><input class="contact" type="text" name="cname" value="" required/></p>
            <p><span> Father's Name: </span><input class="contact" type="text" name="fname" value="" required/></p>
            <p><span> Mother's Name: </span><input class="contact" type="text" name="mname" value="" required/></p>
            <p><span>DOB: </span><input class="contact" type="text" name="cdob" value="" placeholder="YYYY-MM-DD" required/></p>
            <p><span> Gender: </span> <select name="gender"><option value="default">Select gender...</option>
            												<option value="Male">Male</option>
            												<option value="Female">Female</option>
            												<option value="others">Others </option></select>
            <p><span> Category: </span> <select name="category"><option value="default">Select category...</option>
            												<option value="General">General</option>
            												<option value="SC">SC</option>
            												<option value="ST">ST</option>
            												<option value="OBC">OBC</option></select>
            <p><span> Nationality: </span> <select name="nation"><option value="default">Select your nationality...</option>
            <option value="Afghan"> Afghan </option>
            <option value="Albanian"> Albanian </option>
            <option value="Algerian"> Algerian </option>
            <option value="American"> American </option>
            <option value="Andorran"> Andorran </option>
            <option value="Angolan"> Angolan </option>
            <option value="Antiguans"> Antiguans </option>
            <option value="Argentinean"> Argentinean </option>
            <option value="Armenian"> Armenian </option>
            <option value="Australian"> Australian </option>
            <option value="Austrian"> Austrian </option>
            <option value="Azerbaijani"> Azerbaijani </option>
            <option value="Bahamian"> Bahamian </option>
            <option value="Bahraini"> Bahraini </option>
            <option value="Bangladeshi"> Bangladeshi </option>
            <option value="Barbadian"> Barbadian </option>
            <option value="Barbudans"> Barbudans </option>
            <option value="Batswana"> Batswana </option>
            <option value="Belarusian"> Belarusian </option>
            <option value="Belgian"> Belgian </option>
            <option value="Belizean"> Belizean </option>
            <option value="Beninese"> Beninese </option>
            <option value="Bhutanese"> Bhutanese </option>
            <option value="Bolivian"> Bolivian </option>
            <option value="Bosnian"> Bosnian </option>
            <option value="Brazilian"> Brazilian </option>
            <option value="British"> British </option>
            <option value="Bruneian"> Bruneian </option>
            <option value="Bulgarian"> Bulgarian </option>
            <option value="Burkinabe"> Burkinabe </option>
            <option value="Burmese"> Burmese </option>
            <option value="Burundian"> Burundian </option>
            <option value="Cambodian"> Cambodian </option>
            <option value="Cameroonian"> Cameroonian </option>
            <option value="Canadian"> Canadian </option>
            <option value="Cape Verdean"> Cape Verdean </option>
            <option value="Central African"> Central African </option>
            <option value="Chadian"> Chadian </option>
            <option value="Chilean"> Chilean </option>
            <option value="Chinese"> Chinese </option>
            <option value="Colombian"> Colombian </option>
            <option value="Comoran"> Comoran </option>
            <option value="Congolese"> Congolese </option>
            <option value="Congolese"> Congolese </option>
            <option value="Costa Rican"> Costa Rican </option>
            <option value="Croatian"> Croatian </option>
            <option value="Cuban"> Cuban </option>
            <option value="Cypriot"> Cypriot </option>
            <option value="Czech"> Czech </option>
            <option value="Danish"> Danish </option>
            <option value="Djibouti"> Djibouti </option>
            <option value="Dominican"> Dominican </option>
            <option value="Dominican"> Dominican </option>
            <option value="Dutch"> Dutch </option>
            <option value="Dutchman"> Dutchman </option>
            <option value="Dutchwoman"> Dutchwoman </option>
            <option value="East Timorese"> East Timorese </option>
            <option value="Ecuadorean"> Ecuadorean </option>
            <option value="Egyptian"> Egyptian </option>
            <option value="Emirian"> Emirian </option>
            <option value="Equatorial Guinean"> Equatorial Guinean </option>
            <option value="Eritrean"> Eritrean </option>
            <option value="Estonian"> Estonian </option>
            <option value="Ethiopian"> Ethiopian </option>
            <option value="Fijian"> Fijian </option>
            <option value="Filipino"> Filipino </option>
            <option value="Finnish"> Finnish </option>
            <option value="French"> French </option>
            <option value="Gabonese"> Gabonese </option>
            <option value="Gambian"> Gambian </option>
            <option value="Georgian"> Georgian </option>
            <option value="German"> German </option>
            <option value="Ghanaian"> Ghanaian </option>
            <option value="Greek"> Greek </option>
            <option value="Grenadian"> Grenadian </option>
            <option value="Guatemalan"> Guatemalan </option>
            <option value="Guinea-Bissauan"> Guinea-Bissauan </option>
            <option value="Guinean"> Guinean </option>
            <option value="Guyanese"> Guyanese </option>
            <option value="Haitian"> Haitian </option>
            <option value="Herzegovinian"> Herzegovinian </option>
            <option value="Honduran"> Honduran </option>
            <option value="Hungarian"> Hungarian </option>
            <option value="I-Kiribati"> I-Kiribati </option>
            <option value="Icelander"> Icelander </option>
            <option value="Indian"> Indian </option>
            <option value="Indonesian"> Indonesian </option>
            <option value="Iranian"> Iranian </option>
            <option value="Iraqi"> Iraqi </option>
            <option value="Irish"> Irish </option>
            <option value="Irish"> Irish </option>
            <option value="Israeli"> Israeli </option>
            <option value="Italian"> Italian </option>
            <option value="Ivorian"> Ivorian </option>
            <option value="Jamaican"> Jamaican </option>
            <option value="Japanese"> Japanese </option>
            <option value="Jordanian"> Jordanian </option>
            <option value="Kazakhstani"> Kazakhstani </option>
            <option value="Kenyan"> Kenyan </option>
            <option value="Kittian and Nevisian"> Kittian and Nevisian </option>
            <option value="Kuwaiti"> Kuwaiti </option>
            <option value="Kyrgyz"> Kyrgyz </option>
            <option value="Laotian"> Laotian </option>
            <option value="Latvian"> Latvian </option>
            <option value="Lebanese"> Lebanese </option>
            <option value="Liberian"> Liberian </option>
            <option value="Libyan"> Libyan </option>
            <option value="Liechtensteiner"> Liechtensteiner </option>
            <option value="Lithuanian"> Lithuanian </option>
            <option value="Luxembourger"> Luxembourger </option>
            <option value="Macedonian"> Macedonian </option>
            <option value="Malagasy"> Malagasy </option>
            <option value="Malawian"> Malawian </option>
            <option value="Malaysian"> Malaysian </option>
            <option value="Maldivan"> Maldivan </option>
            <option value="Malian"> Malian </option>
            <option value="Maltese"> Maltese </option>
            <option value="Marshallese"> Marshallese </option>
            <option value="Mauritanian"> Mauritanian </option>
            <option value="Mauritian"> Mauritian </option>
            <option value="Mexican"> Mexican </option>
            <option value="Micronesian"> Micronesian </option>
            <option value="Moldovan"> Moldovan </option>
            <option value="Monacan"> Monacan </option>
            <option value="Mongolian"> Mongolian </option>
            <option value="Moroccan"> Moroccan </option>
            <option value="Mosotho"> Mosotho </option>
            <option value="Motswana"> Motswana </option>
            <option value="Mozambican"> Mozambican </option>
            <option value="Namibian"> Namibian </option>
            <option value="Nauruan"> Nauruan </option>
            <option value="Nepalese"> Nepalese </option>
            <option value="Netherlander"> Netherlander </option>
            <option value="New Zealander"> New Zealander </option>
            <option value="Ni-Vanuatu"> Ni-Vanuatu </option>
            <option value="Nicaraguan"> Nicaraguan </option>
            <option value="Nigerian"> Nigerian </option>
            <option value="Nigerien"> Nigerien </option>
            <option value="North Korean"> North Korean </option>
            <option value="Northern Irish"> Northern Irish </option>
            <option value="Norwegian"> Norwegian </option>
            <option value="Omani"> Omani </option>
            <option value="Pakistani"> Pakistani </option>
            <option value="Palauan"> Palauan </option>
            <option value="Panamanian"> Panamanian </option>
            <option value="Papua New Guinean"> Papua New Guinean </option>
            <option value="Paraguayan"> Paraguayan </option>
            <option value="Peruvian"> Peruvian </option>
            <option value="Polish"> Polish </option>
            <option value="Portuguese"> Portuguese </option>
            <option value="Qatari"> Qatari </option>
            <option value="Romanian"> Romanian </option>
            <option value="Russian"> Russian </option>
            <option value="Rwandan"> Rwandan </option>
            <option value="Saint Lucian"> Saint Lucian </option>
            <option value="Salvadoran"> Salvadoran </option>
            <option value="Samoan"> Samoan </option>
            <option value="San Marinese"> San Marinese </option>
            <option value="Sao Tomean"> Sao Tomean </option>
            <option value="Saudi"> Saudi </option>
            <option value="Scottish"> Scottish </option>
            <option value="Senegalese"> Senegalese </option>
            <option value="Serbian"> Serbian </option>
            <option value="Seychellois"> Seychellois </option>
            <option value="Sierra Leonean"> Sierra Leonean </option>
            <option value="Singaporean"> Singaporean </option>
            <option value="Slovakian"> Slovakian </option>
            <option value="Slovenian"> Slovenian </option>
            <option value="Solomon Islander"> Solomon Islander </option>
            <option value="Somali"> Somali </option>
            <option value="South African"> South African </option>
            <option value="South Korean"> South Korean </option>
            <option value="Spanish"> Spanish </option>
            <option value="Sri Lankan"> Sri Lankan </option>
            <option value="Sudanese"> Sudanese </option>
            <option value="Surinamer"> Surinamer </option>
            <option value="Swazi"> Swazi </option>
            <option value="Swedish"> Swedish </option>
            <option value="Swiss"> Swiss </option>
            <option value="Syrian"> Syrian </option>
            <option value="Taiwanese"> Taiwanese </option>
            <option value="Tajik"> Tajik </option>
            <option value="Tanzanian"> Tanzanian </option>
            <option value="Thai"> Thai </option>
            <option value="Togolese"> Togolese </option>
            <option value="Tongan"> Tongan </option>
            <option value="Trinidadian or Tobagonian"> Trinidadian or Tobagonian </option>
            <option value="Tunisian"> Tunisian </option>
            <option value="Turkish"> Turkish </option>
            <option value="Tuvaluan"> Tuvaluan </option>
            <option value="Ugandan"> Ugandan </option>
            <option value="Ukrainian"> Ukrainian </option>
            <option value="Uruguayan"> Uruguayan </option>
            <option value="Uzbekistani"> Uzbekistani </option>
            <option value="Venezuelan"> Venezuelan </option>
            <option value="Vietnamese"> Vietnamese </option>
            <option value="Welsh"> Welsh </option>
            <option value="Welsh"> Welsh </option>
            <option value="Yemenite"> Yemenite </option>
            <option value="Zambian"> Zambian </option>
            <option value="Zimbabwean"> Zimbabwean </option></select>
            <p><span> Annual Family Income: </span><input class="contact" type="text" name="afi" value="" placeholder="Enter in INR..." required/></p>
            <p><span>Profile Picture: </span><input class="contact" type="file" name="file_path" accept="image/*" value="" required/></p>
            
            </br>
            <div class="horizontal-line"></div></br>
            <h3 align="center">STEP 2: COMMUNICATION DETAILS</h3><br>
            <p><span>Address: </span><textarea class="contact textarea" rows="4" cols="50" name="caddress" required></textarea></p>
            <p><span> District: </span><input class="contact" type="text" name="district" value="" required/></p>
            <p><span> State: </span> <select name="state"><option value="default">Select your state...</option>
            <option value="Andaman and Nicobar Islands">Andaman and Nicobar Islands</option>
<option value="Andhra Pradesh">Andhra Pradesh</option>
<option value="Arunachal Pradesh">Arunachal Pradesh</option>
<option value="Assam">Assam</option>
<option value="Bihar">Bihar</option>
<option value="Chandigarh">Chandigarh</option>
<option value="Chhattisgarh">Chhattisgarh</option>
<option value="Dadra and Nagar Haveli">Dadra and Nagar Haveli</option>
<option value="Daman and Diu">Daman and Diu</option>
<option value="Delhi">Delhi</option>
<option value="Goa">Goa</option>
<option value="Gujarat">Gujarat</option>
<option value="Haryana">Haryana</option>
<option value="Himachal Pradesh">Himachal Pradesh</option>
<option value="Jammu and Kashmir">Jammu and Kashmir</option>
<option value="Jharkhand">Jharkhand</option>
<option value="Karnataka">Karnataka</option>
<option value="Kerala">Kerala</option>
<option value="Lakshadweep">Lakshadweep</option>
<option value="Madhya Pradesh">Madhya Pradesh</option>
<option value="Maharashtra">Maharashtra</option>
<option value="Manipur">Manipur</option>
<option value="Meghalaya">Meghalaya</option>
<option value="Mizoram">Mizoram</option>
<option value="Nagaland">Nagaland</option>
<option value="Orissa">Orissa</option>
<option value="Pondicherry">Pondicherry</option>
<option value="Punjab">Punjab</option>
<option value="Rajasthan">Rajasthan</option>
<option value="Sikkim">Sikkim</option>
<option value="Tamil Nadu">Tamil Nadu</option>
<option value="Tripura">Tripura</option>
<option value="Uttaranchal">Uttaranchal</option>
<option value="Uttar Pradesh">Uttar Pradesh</option>
<option value="West Bengal">West Bengal</option></select>
            <p><span>Email: </span><input class="contact" type="email" name="cemail" value="" required/></p>
            <p><span>Phone: </span><input class="contact" type="number" name="cphone" value="" pattern="{10}" required/></p>
            <p><span>Aadhaar Number: </span><input class="contact" type="number" name="caadhar" value="" required/></p>
            </br>
            <div class="horizontal-line"></div></br>
            <h3 align="center">STEP 3: LOGIN DETAILS</h3><br>
            <p><span>Password: </span><input class="contact" type="password" name="cpass" value="" required/></p>
            <p><span> Security Question: </span> <select name="secqtn"><option value="default">Select security question...</option>
            												<option value="What is your nickname?">What is your nickname?</option>
            												<option value="What is your favourite sport?">What is your favourite sport?</option>
            												<option value="What primary school did you attend?">What primary school did you attend?</option>
            												<option value="What is your mother's maiden name?">What is your mother's maiden name?</option></select>
            <p><span> Answer: </span><input class="contact" type="text" name="secans" value="" required/></p>
            </br>
            <div class="horizontal-line"></div></br>
            <p style="padding-top: 15px"><span>&nbsp;</span><input class="submit" type="submit" name="contact_submitted" value="Register" onClick="return validate();" /></p>
          </div>
          <br>
        </form>
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