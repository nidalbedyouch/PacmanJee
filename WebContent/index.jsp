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
	<section class="main-section ">
		<div class="main-slider owl-carousel">
			<div class="hs-item set-bg" data-setbg="img/slider-1.jpg">
				<div class="hs-text">
					<div class="container">
						<h2> <span> Pacman </span> Game </h2>
						<p>   Pac-Man (パックマン, Pakkuman?) (à l'origine Puckman1) est un jeu vidéo créé par Tōru Iwatani pour l’entreprise japonaise Namco, sorti au Japon le 22 mai 19802. <br />   Le jeu consiste à déplacer Pac-Man, un personnage qui, vu de profil, ressemble à un diagramme circulaire à l’intérieur d’un labyrinthe,<br />    afin de lui faire manger toutes les pac-gommes qui s’y trouvent en évitant d’être touché par des fantômes.  <br /> </p>
					</div>
				</div>
			</div>
			<div class="hs-item set-bg" data-setbg="img/slider-2.jpg">
				<div class="hs-text">
					<div class="container">
						<h2> <span> Pacman </span> Game </h2>
						<p>  Pac-Man (パックマン, Pakkuman?) (à l'origine Puckman1) est un jeu vidéo créé par Tōru Iwatani pour l’entreprise japonaise Namco, sorti au Japon le 22 mai 19802. <br />    Le jeu consiste à déplacer Pac-Man, un personnage qui, vu de profil, ressemble à un diagramme circulaire à l’intérieur d’un labyrinthe,<br />    afin de lui faire manger toutes les pac-gommes qui s’y trouvent en évitant d’être touché par des fantômes.  <br /> </p>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--main section end -->


	<!-- Latest news section -->
	<div class="latest-news-section">
		<div class="ln-title">Latest News</div>
		<div class="news-ticker">
			<div class="news-ticker-contant">
				<div class="nt-item"><span class="new">new</span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. </div>
				<div class="nt-item"><span class="strategy">strategy</span>Isum dolor sit amet, consectetur adipiscing elit. </div>
				<div class="nt-item"><span class="racing">racing</span>Isum dolor sit amet, consectetur adipiscing elit. </div>
			</div>
		</div>
	</div>
	<!-- Latest news section end -->


	<!-- footer section -->
	 <c:import url="/jsp/footer.jsp" /> 
	


	<!--====== Javascripts & Jquery ======-->
	<script src="<c:url value="js/jquery-3.2.1.min.js"/>"></script>
	<script src= "<c:url value="js/bootstrap.min.js"/>"></script>
	<script src= "<c:url value="js/owl.carousel.min.js"/>"></script>
	<script src= "<c:url value="js/jquery.marquee.min.js"/>"></script>
	<script src="<c:url value="js/main.js"/>"></script>
    </body>
</html>