<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!-- Footer top section -->
	<section class="footer-top-section">
		<div class="container">
			<div class="footer-top-bg">
				<img src="img/footer-top-bg.png" alt="">
			</div>
			<div class="row">
				<div class="col-lg-4">
					<div class="footer-logo text-white">
						<img src="img/footer-logo.png" alt="">
					</div>
				</div>
				
				<div class="col-lg-4 col-md-6 ml-auto">
					<div class="footer-widget">
						<h4 class="fw-title">Top Games</h4>
						<div class= "table-responsive">
							<table class = "table">
								<!--  table head -->
								<thead>
									<tr>
										<th class = "th-sm">Score</th>
										<th class = "th-sm">Player</th>
										<th class = "th-sm">Date</th>
									</tr>
								</thead>
								<!-- table head end -->
								
								<!-- table body -->
								<tbody class = "top-game">
										<c:forEach  var="game" items="${topGames}"  >
											<tr class="tg-item">
												<th scope = "row"> ${game.score} </th>
												<td scope = "row"> <c:out value = "${game.player}" /></td>
												<td scope = "row" class="tc-date"> <c:out value = "${game.date}" /> </td>
											</tr>
										</c:forEach>
								</tbody>
								<!-- table body end -->
							</table>
						</div>
						
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Footer top section end -->

	
	<!-- Footer section -->
	<footer class="footer-section">
		<div class="container">
			<ul class="footer-menu">
				   <li><a href="index.html">Home</a></li>
					<li><a href="classement">Classement</a></li>
					<li><a href="blog">Blog</a></li>
			</ul>
			<p class="copyright">
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved <i class="fa fa-heart-o" aria-hidden="true"></i> 
			</p>
		</div>
	</footer>
	<!-- Footer section end -->

