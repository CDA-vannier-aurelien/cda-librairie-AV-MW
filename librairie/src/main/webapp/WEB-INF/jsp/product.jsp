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
													</c:when>
													<c:otherwise>
														<p class="color-red">Non-Disponible</p>
													</c:otherwise>
												</c:choose>
											</div>
										</div>
										<c:if test="${livre.quantitee>0 }">
											<div class="footer-imagia text-center">
												<form method="get" action="ajouter">
													<div class="container-fluid">
														<div class="row">
															<button type="submit" value="${livre.reference }"
																name="reference" class="col-2">
																<i class="fa fa-shopping-cart"></i>
															</button>
															<span class="col-4" >Quantité</span>
															<input type="number" min="1" max="${livre.quantitee}" name="quantiteCommandee" class="col-3 offset-1" >
														</div>
													</div>
												</form>
											</div>
										</c:if>
									</div>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="d-flex justify-content-center">
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
	<!--Modal: Login / Register Form-->
	<div class="modal fade" id="modalLRForm" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog cascading-modal" role="document">
			<!--Content-->
			<div class="modal-content">

				<!--Modal cascading tabs-->
				<div class="modal-c-tabs">

					<!-- Nav tabs -->
					<ul class="nav nav-tabs md-tabs tabs-2 light-blue darken-3"
						role="tablist">
						<li class="nav-item"><a class="nav-link active"
							data-toggle="tab" href="#panel7" role="tab"><i
								class="fa fa-user-circle"></i> Login</a></li>
						<li class="nav-item"><a class="nav-link" data-toggle="tab"
							href="#panel8" role="tab"><i class="fa fa-user-plus"></i>
								Register</a></li>
					</ul>

					<!-- Tab panels -->
					<div class="tab-content">
						<!--Panel 7-->

						<div class="tab-pane fade in show active" id="panel7"
							role="tabpanel">

							<!--Body-->
							<form method="post" action="connection" class="was-validated"
								novalidate>
								<div class="modal-body mb-1">
									<div class="md-form form-sm mb-5">
										<i class="fa fa-envelope"></i> <input type="email"
											id="modalLRInput10"
											class="form-control form-control-sm validate" name="login">
										<label data-error="wrong" data-success="right"
											for="modalLRInput10">Your email</label>
									</div>

									<div class="md-form form-sm mb-4">
										<i class="fa fa-lock"></i> <input type="password"
											id="modalLRInput11"
											class="form-control form-control-sm validate" name="password">
										<label data-error="wrong" data-success="right"
											for="modalLRInput11">Your password</label>
									</div>
									<div class="text-center mt-2">
										<button class="btn btn-info">
											Log in <i class="fa fa-sign-in ml-1"></i>
										</button>
									</div>
								</div>
							</form>
							<!--Footer-->
							<div class="modal-footer">

								<button type="button"
									class="btn btn-outline-info waves-effect ml-auto"
									data-dismiss="modal">Close</button>
							</div>

						</div>
						<!--/.Panel 7-->

						<!--Panel 8-->
						<div class="tab-pane fade" id="panel8" role="tabpanel">

							<!--Body-->
							<form method="post" action="addUser.do" class="was-validated">
								<div class="modal-body">
									<div class="container-fluid">
										<div class="row">
											<div class="col md-form form-sm mb-2">
												<i class="fa fa-user prefix"></i> <input type="text"
													id="nom" class="form-control form-control-sm validate"
													placeholder="Nom" name="nom" required>

											</div>
											<div class="col md-form form-sm mb-2 mt-4">
												<input type="text" id="prenom"
													class="form-control form-control-sm validate"
													placeholder="Prenom" name="prenom" required>

											</div>
										</div>
										<div class="row">
											<div class="col-3 md-form form-sm mb-2">
												<i class="fa fa-home"></i> <input type="number" id="numero"
													class="form-control form-control-sm validate"
													placeholder="N°" name="numeroPorte" required>

											</div>
											<div class="col-9 md-form form-sm mb-2 mt-4">

												<input type="text" id="adresse"
													class="form-control form-control-sm validate"
													placeholder="Nom de la rue" name="nomRue" required>

											</div>
										</div>
										<div class="row">
											<div class="col md-form form-sm mb-2">
												<i class="fa fa-location-arrow prefix"></i> <input
													type="text" id="ville" name="ville"
													class="form-control form-control-sm validate"
													placeholder="Ville" required>

											</div>
											<div class="col md-form form-sm mb-2 mt-4">
												<input type="number" id="codePostal"
													class="form-control form-control-sm validate"
													placeholder="Code Postal" name="codePostal" required>
											</div>
											<div class="col md-form form-sm mb-2 mt-4">
												<input type="text" id="pays"
													class="form-control form-control-sm validate"
													placeholder="Pays" name="pays" required>
											</div>
										</div>
										<div class="md-form form-sm mb-2">
											<i class="fa fa-lock prefix"></i> <input type="text"
												id="complement"
												class="form-control form-control-sm validate"
												placeholder="Complément d'adresse" name="complementAdresse"
												required>
										</div>
										<div class="md-form form-sm mb-2">
											<i class="fa fa-calendar-minus-o prefix"></i> <input
												type="date" id="datenaiss"
												class="form-control form-control-sm validate"
												placeholder="Date de Naissance" name="dateNaissance"
												required>

										</div>
										<div class="md-form form-sm mb-2">
											<i class="fa fa-envelope prefix"></i> <input type="email"
												id="email" class="form-control form-control-sm validate"
												onchange="testEmail()" name="mail" placeholder="Email"
												required> <span class="error text-danger"
												id="result"></span>
										</div>

										<div class="md-form form-sm mb-2">
											<i class="fa fa-lock prefix"></i> <input type="password"
												id="password" class="form-control form-control-sm validate"
												placeholder="Password" name="password" required>
										</div>

										<div class="text-center form-sm mt-2 mb-4">
											<button class="btn btn-info" id="valider">
												Sign up <i class="fa fa-sign-in ml-1"></i>
											</button>
										</div>

									</div>
									<!--Footer-->
									<div class="modal-footer">
										<button type="button"
											class="btn btn-outline-info waves-effect ml-auto"
											data-dismiss="modal">Close</button>
									</div>
								</div>
							</form>
						</div>
						<!--/.Panel 8-->
					</div>

				</div>
			</div>
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/js/script.min.js"></script>
	<script src="assets/js/myScript.js"></script>
</body>

</html>