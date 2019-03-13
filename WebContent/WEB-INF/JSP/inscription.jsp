<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>Pacman</title>
	<meta charset="UTF-8">
	<meta name="description" content="Pacman score classement">
	<meta name="keywords" content="pacman, game, ghost,score , classement, html">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="<c:url value="/img/favicon.ico" />" rel="shortcut icon"/>
	
	<!-- Google Fonts -->
	<link href="https://fonts.googleapis.com/css?family=Roboto:400,400i,500,500i,700,700i" rel="stylesheet">

	<!-- Stylesheets -->
	<link rel="stylesheet" href="<c:url value="/css/font-awesome.min.css"/>"/>
	<link rel="stylesheet" href= "<c:url value="/css/bootstrap.min.css"/>"/>
	<link rel="stylesheet" href= "<c:url value="/css/owl.carousel.css"/>"/>
	<link rel="stylesheet" href="<c:url value="/css/style.css" />"/>
	<link rel="stylesheet" href="<c:url value="/css/register.css" />"/>

</head>
<body>
	<!-- Page Preloder -->
	<div id="preloder">
		<div class="loader"></div>
	</div>

	<!-- Header section -->
	     <c:import url="/jsp/menu.jsp" /> 
	<!-- Header section end -->
		<c:import url="/jsp/loginForm.jsp" />

	<!-- main section -->
	<section class="main-section">
			   <h4 id="insc-title">Devenez membre de Pacman Rating</h4>
				<form class="insc-form needs-validation m-auto"  method="post" action="register" novalidate>
					  <div class="form-row"> 
					  	 <label class="col-4 col-sm-3" for="uname">Pseudo</label> 
						  <input class="col-6 col-sm-4" type="text" placeholder="pseudo" name="uname" id="uname" required>
						  <div class="invalid-feedback uname">
						  		${form.erreurs['uname']}
						  </div>
					  </div>
					   <div class="form-row">
					  		 <label class="col-4 col-sm-3" for="email">Email</label> 
						     <input class="col-6 col-sm-4"  type="email" placeholder="Email" name="email" id="email" required> 
						 	 <div class="invalid-feedback email">
						 	 	${form.erreurs['email']}
						 	 </div>
					  </div>
					   <div class="form-row">
					  	     <label class="col-4 col-sm-3" for="bday">Date de naissance</label> 
						     <input class="col-6 col-sm-4" type="date" placeholder="Date de naissance" name="bday" id="bday" required> 
						      <div class="invalid-feedback bday">
						      		${form.erreurs['bday']}
						      </div>
					  </div>
					  <div class="form-row">
					     	 <label class="col-4 col-sm-3"  for="pwd">Mot de passe </label>
						     <input class="col-6 col-sm-4"  type="password" placeholder="Mot de passe " name="pwd" id="pwd" required>
						  	 <div class="invalid-feedback pwd">
						  	 	${form.erreurs['pwd']}
						  	 </div>
					  </div>
					  <div class="form-row">
					    		<label class="col-4 col-sm-3" for="confirmation">Confirmation Mot de passe </label>
					     		<input class="col-6 col-sm-4"  type="password" placeholder="Mot de passe " id="confirmation" name="confirmation" required>
					 	 		<div class="invalid-feedback confirmation">
					 	 			${form.erreurs['confirmation']}
					 	 		</div>
					  </div>
					  
					  <div class="row">
					     <div class ="col-5 col-sm-3 m-auto" >      
					    	<button type="submit" class="submit site-btn btn btn-dark">Créer mon compte</button>
					    </div>
					  </div>
					 <div class="row">
						  <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
					</div>
			</form>
	</section>
	<!--main section end -->


	<!-- footer section -->
	 <c:import url="/jsp/footer.jsp" /> 
	
	<!--====== Javascripts & Jquery ======-->
	<script src="<c:url value="js/jquery-3.2.1.min.js"/>"></script>
	<script src= "<c:url value="js/bootstrap.min.js"/>"></script>
	<script src= "<c:url value="js/owl.carousel.min.js"/>"></script>
	<script src= "<c:url value="js/jquery.marquee.min.js"/>"></script>
	<script src="<c:url value="js/main.js"/>"></script>
	<script src="<c:url value="js/RegisterValid.js"/>"></script>
    </body>
</html>