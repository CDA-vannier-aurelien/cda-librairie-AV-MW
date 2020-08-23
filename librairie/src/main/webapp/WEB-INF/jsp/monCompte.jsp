<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="background: white;">

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title>Mon compte</title>
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

	<div class="container-fluid">
		<div class="row mt-2 mb-4">
			<div class="h1 col-6 text-center">Mes Informations</div>
			<div class="h1 col-6 text-center">Mes commandes</div>
		</div>
		<div class="row">

			<div class="container col-6">
				<div class="row">
					<div class="col md-form form-sm mb-2">
						<em class="fa fa-user prefix"></em> <input type="text" id="nom"
							class="form-control form-control-sm validate"
							placeholder="${user.nom}" name="nom" readonly>

					</div>
					<div class="col md-form form-sm mb-2 mt-4">
						<input type="text" id="prenom"
							class="form-control form-control-sm validate"
							placeholder="${user.prenom}" name="prenom" readonly>

					</div>
				</div>
				<div class="row">
					<div class="col-3 md-form form-sm mb-2">
						<em class="fa fa-home"></em> <input type="number" id="numero"
							class="form-control form-control-sm validate"
							placeholder="${user.numeroPorte}" name="numeroPorte" min="0"
							readonly>

					</div>
					<div class="col-9 md-form form-sm mb-2 mt-4">

						<input type="text" id="nomRue"
							class="form-control form-control-sm validate"
							placeholder="${user.nomRue}" name="nomRue" readonly>

					</div>
				</div>
				<div class="row">
					<div class="col md-form form-sm mb-2">
						<em class="fa fa-location-arrow prefix"></em> <input type="text"
							id="ville" name="ville"
							class="form-control form-control-sm validate"
							placeholder="${user.ville}" readonly>

					</div>
					<div class="col md-form form-sm mb-2 mt-4">
						<input type="number" id="codePostal"
							class="form-control form-control-sm validate"
							placeholder="${user.codePostal}" name="codePostal" readonly>
					</div>
					<div class="col md-form form-sm mb-2 mt-4">
						<input type="text" id="pays"
							class="form-control form-control-sm validate"
							placeholder="${user.pays}" name="pays" readonly>
					</div>
				</div>
				<div class="md-form form-sm mb-2">
					<em class="fa fa-lock prefix"></em> <input type="text"
						id="complement" class="form-control form-control-sm validate"
						placeholder="${user.complementAdresse}" name="complementAdresse"
						readonly>
				</div>
				<div class="md-form form-sm mb-2">
					<em class="fa fa-calendar-minus-o prefix"></em> <input type="text"
						id="datenaiss" class="form-control form-control-sm validate"
						placeholder="${user.dateNaissance}" name="dateNaissance" readonly>

				</div>
				<div class="md-form form-sm mb-2">
					<em class="fa fa-envelope prefix"></em> <input type="email"
						id="email" class="form-control form-control-sm validate"
						name="mail" placeholder="${user.mail}" readonly>
				</div>
				<button data-toggle="modal" data-target="#modalModifier"
					type="button" class="btn btn-outline-info waves-effect ml-auto " onclick="modifierUser('${user.nom}','${user.prenom}','${user.numeroPorte}','${user.nomRue}','${user.ville}','${user.pays}','${user.codePostal}','${user.complementAdresse}')">
					Modifier</button>

			</div>

			<!-- Tableau livre  -->
			<table class="table table-striped table-class col-6">

				<thead>
					<tr>
						<th>N° commande</th>
						<th>Date de commande</th>
						<th>Etat de la commande</th>
						<th>Outils</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach var="commande" items="${listeCommande}">
					<div class="accordion">
						<tr>
							<td data-toggle="collapse" data-target="#accordion${commande.numeroCommande}" class="clickable" onclick="listCommandeLine('${commande.numeroCommande}')">${commande.numeroCommande}</td>
							<td>${commande.dateCommande}</td>
							<td>
							<c:choose  >
							<c:when test="${!commande.estValidee}">
							 en cours de validation

							</c:when>
							<c:otherwise>
							 en cours de livraison
							</c:otherwise>

							</c:choose>
							</td>

							<td>
								<c:choose>
									<c:when test="${!commande.estValidee}">
								<a class="text-danger" onclick="supprimerCommande('${commande.numeroCommande}')">
									<em class="fa fa-trash"></em>
								</a>
									</c:when>
									<c:otherwise>
										<em class="fa fa-check-circle text-success" ></em>
									</c:otherwise>
								</c:choose>

							</td>
						</tr>
						<tr>
							<td colspan="12" class="hiddenRow">
								<div class="accordian-body collapse" id="accordion${commande.numeroCommande}">
									<table class="table table-striped">
										<thead>
										<tr class="info">
											<th>Livre</th>
											<th>Quantité</th>
											<th>Prix</th>
										</tr>
										</thead>

										<tbody id="commandeLine${commande.numeroCommande}">
										</tbody>
									</table>
								</div>
							</td>
						</tr>
					</div>
					</c:forEach>
				<tbody>
			</table>
			<div class="col-6 offset-6">
				<div class="d-flex justify-content-center">
					<nav aria-label="Page navigation">
						<ul class="pagination">
							<c:if test="${ pageEnCours > 1 }">
								<c:url value="/monCompte" var="lienPrecedent">
									<c:param name="page" value="${ pageEnCours - 1 }" />
								</c:url>
								<li class="page-item"><a class="page-link"
														 href="${lienPrecedent }">&lt;</a></li>
							</c:if>
							<li class="page-item"><a class="page-link" href="#">${ pageEnCours }</a>

							</li>
							<c:if test="${ pageEnCours < (count / nbElementsParPage)  }">
								<c:url value="/monCompte" var="lienSuivant">
									<c:param name="page" value="${ pageEnCours + 1 }" />
								</c:url>
								<li class="page-item"><a class="page-link"
														 href="${lienSuivant }">&gt;</a></li>
							</c:if>
						</ul>
					</nav>
				</div>
			</div>
		</div>
<form action="supprimerCommande" method="post" class="d-none" id="suppCommande">
	<input type="hidden" id="referenceCommande" name="refeCommande">
</form>

	</div>
	<div class="modal fade" id="modalModifier" tabindex="-1"
		aria-labelledby="modalModifierLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="modaleSuppressionLabel">Mon Compte
						</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<form method="post" action="updateUser" class="was-validated">
					<div class="modal-body">
						<div class="container-fluid">
							<div class="row">
								<div class="col md-form form-sm mb-2">
									<em class="fa fa-user prefix"></em> <input type="text"
										id="nomModifier" class="form-control form-control-sm validate"
										placeholder="Nom" name="nom" required>
								</div>
								<div class="col md-form form-sm mb-2 mt-4">
									<input type="text" id="prenomModifier"
										class="form-control form-control-sm validate"
										placeholder="Prenom" name="prenom" required>
								</div>
							</div>
							<div class="row">
								<div class="col-3 md-form form-sm mb-2">
									<em class="fa fa-home"></em> <input type="number"
										id="numeroModifier"
										class="form-control form-control-sm validate" placeholder="N°"
										name="numeroPorte" min="0" required>
								</div>
								<div class="col-9 md-form form-sm mb-2 mt-4">
									<input type="text" id="rueModifier"
										class="form-control form-control-sm validate"
										placeholder="Nom de la rue" name="nomRue" required>
								</div>
							</div>
							<div class="row">
								<div class="col md-form form-sm mb-2">
									<em class="fa fa-location-arrow prefix"></em> <input type="text"
										id="villeModifier" name="ville"
										class="form-control form-control-sm validate"
										placeholder="Ville" required>
								</div>
								<div class="col md-form form-sm mb-2 mt-4">
									<input type="number" id="codePostalModifier"
										class="form-control form-control-sm validate"
										placeholder="Code Postal" name="codePostal" required>
								</div>
								<div class="col md-form form-sm mb-2 mt-4">
									<input type="text" id="paysModifier"
										class="form-control form-control-sm validate"
										placeholder="Pays" name="pays" required>
								</div>
							</div>
							<div class="md-form form-sm mb-2">
								<em class="fa fa-lock prefix"></em> <input type="text"
									id="complementAdresseModifier"
									class="form-control form-control-sm validate"
									placeholder="Complément d'adresse" name="complementAdresse">
							</div>

							<div class="md-form form-sm mb-2">
								<em class="fa fa-lock prefix"></em> <input type="password"
									id="password" class="form-control form-control-sm validate"
									placeholder="Password" name="password">
							</div>
							<div class="text-center form-sm mt-2 mb-4">
								<button class="btn btn-info" id="valider">
									Modifier <em class="fa fa-sign-in ml-1"></em>
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
		</div>
	</div>
	<footer class="footer text-faded text-center py-5"
		style="background-color: rgb(238, 244, 247);">
		<div class="container">
			<p class="m-0 small" style="color: rgb(102, 109, 112);">Copyright&nbsp;ï¿½&nbsp;Brand
				2020</p>
		</div>
	</footer>
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/js/script.min.js"></script>
	<script src="assets/js/myScript.js"></script>
</body>
</html>