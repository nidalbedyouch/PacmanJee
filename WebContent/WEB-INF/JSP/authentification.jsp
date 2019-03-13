<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
		<title>Connexion-Pacman</title>
	    <link rel="stylesheet" href="<c:url value="/CSS/style.css"/>">
	    
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.2.1/css/bootstrap.min.css" />
		<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.2.1/js/bootstrap.min.js"></script>
	
	</head>
	<body >
		<div >
			<img src="IMAGE/pac-man-logo1.png" width="55%" height="30%">
			<h2>Login Form</h2>
				<div class ="shadow buttom">
					<form action="connexion" method = "post">
					  <div class="row">
					  	 <div class ="col-3"><label >Username</label> </div>
					  </div>
					  <div class="row">
					     <div class ="col-5">
					     	<input type="text" placeholder="Enter Username" name="uname" required> 
					     	<span class="erreur">${form.erreurs['uname']}</span>
		               		 <br />
					     </div>
					  </div>
					  <div class="row">
					     <div class ="col-3"><label>Password</label></div>
					  </div>   
					  <div class="row">
					     <div class ="col-5">
					     	<input type="password" placeholder="Enter Password" name="psw" required>
					     	<span class="erreur">${form.erreurs['psw']}</span>
		               		 <br />	
					     </div>
					  </div>
					  <div class="row">
						  	<div class ="col-5">      
						    	<a  title="inscription" href="inscription">premiere connexion</a>
						    </div>
						     <div class ="col-5">      
						    	<button type="submit">Login</button>
						    </div>
					  </div>
					  <div class="row">
						  <p class="${empty erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
				   	 </div>
					</form>
			</div>
		</div>
	</body>
</html>