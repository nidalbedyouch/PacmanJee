<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<header class="header-section">
			<!-- menu -->
			<nav class="navbar navbar-expand-lg navbar-dark " style="background-color: #131313;">
				  <a class="navbar-brand " href="index">
						<img src="img/pacmanlogo.png" alt="" class = "logo"> 
				   </a>
				  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
				    <span class="navbar-toggler-icon"></span>
				  </button>
				  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
					    <div class="navbar-nav ">
					      <a class="nav-item nav-link active" href="/index">Home <span class="sr-only">(current)</span></a>
					      <a class="nav-item nav-link" href="#">Classement</a>
					      <a class="nav-item nav-link" href="#">Blog</a>
					    </div>
				    	<div class = "ml-auto">
				    	 <c:if test="${empty sessionScope.sessionUtilisateur}">
				     		 <button class="site-btn" onclick="document.getElementById('modal-wrapper').style.display='block'">Login</button>
				      	 	 <a class="site-btn" href="register">Register</a>
				      	 </c:if>
				         <c:if test="${!empty sessionScope.sessionUtilisateur}">
				         	<div class="dropdown dropdown">
							  <button class="btn site-btn dropdown-toggle" type="button" id="dropdownMenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							    ${sessionScope.sessionUtilisateur.pseudo}
							  </button>
							  <div class="dropdown-menu" aria-labelledby="dropdownMenu">
							    <button class="dropdown-item" type="button">settings</button>
							    <div class="dropdown-divider"></div>
							    <a class="dropdown-item" href="index?action=logout" >Logout</a> 
							  </div>
							</div>
				     		  
				      	 </c:if>
				      </div>
				  </div>
			</nav>
			
			
</header>