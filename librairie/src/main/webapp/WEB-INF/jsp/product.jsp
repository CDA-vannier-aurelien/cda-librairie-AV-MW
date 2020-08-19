<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title>Liste Livres</title>
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i">
<link rel="stylesheet" href="assets/fonts/font-awesome.min.css">
<link rel="stylesheet" href="assets/css/styles.min.css">
</head>

<body style="background-color: white; background: white;">
	<%@include file="navbar.jsp"%>


	<section class="card-section-imagia">
		
		<div class="container">
			<div class="row">


				<c:forEach items="${liste}" var="livre">

					<div class="col-sm-6 col-md-3 col-xl-3">
						<div class="card-container-imagia">
							<div class="card-imagia">
								<div class="front-imagia">
									<div class="cover-imagia">
										<img alt="" src="assets/img/Ajax Pour les nuls.jpeg">
									</div>

									<div class="content-imagia">
										<h3 class="name-imagia">${livre.titre }</h3>
										<p class="subtitle-imagia">de ${livre.auteur }</p>
										<p class="text-center">
											<em> ${livre.description } </em>
										</p>
									</div>

								</div>
								<div class="back-imagia">
									<div class="content-imagia content-back-imagia">
										<div>
											<h3>${livre.titre }</h3>
											<br>
											<div>
												<p>Auteur : ${livre.auteur }</p>
												<p>Editeur : ${livre.editeur }</p>
												<p>Prix : ${livre.prix } €</p>
												<p>Nombre de pages : ${livre.nbPage }</p>
												<p>Quantitée restante : ${livre.quantitee }</p>
												<c:choose>
													<c:when test="${livre.quantitee>0 }">
														<p class="color-green ">Disponible</p>
											</div>
										</div>
									</div>
									<div class="footer-imagia">
										<button> <i class="fa fa-shopping-cart"></i></button>
									</div>
									</c:when>
									<c:otherwise>
										<p class="color-red">Non-Disponible</p>
								</div>
							</div>
						</div>

						</c:otherwise>
						</c:choose>

					</div>
			</div>
		</div>
		</div>
		</c:forEach>
		</div>

		</div>
		<div class="d-flex justify-content-center"">
			<nav aria-label="Page navigation">
				<ul class="pagination">
					<c:if test="${ pageEnCours > 1 }">
						<c:url value="/listeLivre" var="lienPrecedent">
							<c:param name="page" value="${ pageEnCours - 1 }" />
						</c:url>
						<li class="page-item"><a class="page-link"
							href="${lienPrecedent }">&lt;</a></li>
					</c:if>
					<li class="page-item"><a class="page-link" href="#">${ pageEnCours }</a></li>
					<c:if test="${ pageEnCours < (count / nbElementsParPage)  }">
						<c:url value="/listeLivre" var="lienSuivant">
							<c:param name="page" value="${ pageEnCours + 1 }" />
						</c:url>
						<li class="page-item"><a class="page-link"
							href="${lienSuivant }">&gt;</a></li>
					</c:if>
				</ul>
			</nav>
		</div>
	</section>
	<footer class="footer text-faded text-center py-5"
		style="background-color: rgb(238, 244, 247); position: relative;">
		<div class="container">
			<p class="m-0 small" style="color: rgb(102, 109, 112);">Copyright&nbsp;©&nbsp;
				librairie 2020</p>
		</div>
	</footer>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/js/script.min.js"></script>
	<script src="assets/js/myScript.js"></script>
</body>

</html>