<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" href="<c:url value="/css/login.css" />"/>
<script src="<c:url value="js/jquery-3.2.1.min.js"/>"></script>
<script src="<c:url value="/js/loginAjax.js"/>"></script>


<div id="modal-wrapper" class="modal">
  
  <form class="modal-content animate" id = "loginForm">
     <div class="imgcontainer">
		    <span  onclick="document.getElementById('modal-wrapper').style.display='none'" class="close" title="Close PopUp" >&times;</span>
		     <img src="img/avatar.png" alt="Avatar" class="avatar">
		     <h1 style="text-align:center">Login</h1>
    </div>

    <div class="modal-body">
    	<div class = "row ">
    		  <input  type="text" placeholder="Entrez Pseudo/email" name="uname" id="uname">
    	</div>
    	<div class = "row uname">
    	</div>
        <div class= "row ">
        	   <input  type="password" placeholder="Entrez mot de passe" name="psw" id="psw">     
        </div>
        <div class= "row psw">
        </div>   
      
    </div>
    <div class="modal-footer">
      		<button class= "site-btn btn-sm login mr-auto" type="submit" id="login">login</button>     
      		<a  href="#" style="text-decoration:none; float:right; margin-right:34px;margin-left:34px; ">Mot de passe oublié ?</a>
    </div>
     <div class = "row">
  	   		<div class="register">
  	   			Pas encore membre?
  	   			<a href="register">Créer compte</a>
  	   		</div>
      </div>
  </form>
  
</div>