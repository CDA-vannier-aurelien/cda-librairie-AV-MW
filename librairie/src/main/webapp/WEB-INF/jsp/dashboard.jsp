<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="background: white;">

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title>Dashboard</title>
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">

<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i">
<link rel="stylesheet" href="assets/fonts/font-awesome.min.css">
<link rel="stylesheet" href="assets/css/styles.min.css">
</head>

<body style="background: white;">

	<nav
		class="navbar navbar-light navbar-expand-md sticky-top bg-dark py-lg-4"
		id="mainNav">
		<div class="container-fluid">
			<a class="navbar-brand text-uppercase d-lg-none text-expanded"
				href="#" style="color: rgba(255, 255, 255, 0.7);">La Librarie</a>
			<button data-toggle="collapse" data-target="#navbarResponsive"
				class="navbar-toggler" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="nav navbar-nav mx-auto">
					<li class="nav-item" role="presentation"><a class="nav-link"
						href="index">Home</a></li>
					<li class="nav-item" role="presentation"><a class="nav-link"
						href="listeLivre">Produits</a></li>
					<c:if test="${sessionScope.user.labelRole == 'Libraire'}">
						<li class="nav-item" role="presentation"><a class="nav-link"
							href="dashboard">Dashboard</a></li>
					</c:if>
					<c:if test="${empty sessionScope.user }">
						<li class="nav-item" role="presentation"><a class="nav-link"
							data-toggle="modal" data-target="#modalLRForm">Login</a></li>
					</c:if>
					<c:if test="${!empty sessionScope.user }">

						<li class="nav-item dropdown"><a
							class="dropdown-toggle nav-link" data-toggle="dropdown"
							aria-expanded="false" href="#">${sessionScope.user.nom} </a>
							<div class="dropdown-menu" role="menu">
								<a class="dropdown-item" role="presentation" href="#">Mon
									compte</a> <a class="dropdown-item" role="presentation"
									href="panier">Mon panier</a><a class="dropdown-item"
									role="presentation" href="deconnexion">LogOut</a>
							</div></li>
					</c:if>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container-fluid">
		<div class="row mt-2">
			<div class="col-6 d-flex justify-content-center mt-2">
				<h2>Tableau Utilisateur</h2>

			</div>
			<div class="col-6 d-flex justify-content-center mt-2">
				<h2>Tableau livre Livre</h2>
			</div>
		</div>


		<div class="row">
			<table class="table table-striped table-class col-6" id="table-id">
				<thead>
					<tr>
						<th>Nom</th>
						<th>Prenom</th>
						<th>Adresse mail</th>
						<th>Outils</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach var="u" items="${listeUser}">
						<tr>
							<td>${u.nom}</td>
							<td >${u.prenom}</td>
							<td data-toggle="modal" data-target="#modalUtilisateur" onclick="transfertUser('${u.mail }','${u.nom}','${u.prenom}','${u.numeroPorte}','${u.nomRue}','${u.ville}','${u.pays}','${u.codePostal}','${u.complementAdresse}')">${u.mail}</td>

							<td><a href="#" class="text-success"> <i
									class="fa fa-checkcircle" onclick="validerMail('${u.mail}')"></i>
							</a>
								<form class="d-none" id="validateUser${u.mail}"
									action="validerMail" method="POST">
									<input type="hidden" value="${u.mail} " name="mail">

								</form> <a href="#" class="text-danger"> <i class="fa fa-trash"
									onclick="afficherModaleSuppression('${u.mail}')"></i>
							</a></td>
					</c:forEach>
				<tbody>
			</table>

			<!-- Tableau livre  -->
			<table class="table table-striped table-class col-6" id="table-id">


				<thead>
					<tr>
						<th>Référence</th>
						<th>Titre</th>
						<th>Quantitée</th>
						<th>Outils</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach var="livre" items="${listeLivre}">
						<tr>
							<td>${livre.reference}</td>
							<td>${livre.titre}</td>
							<td>${livre.quantitee}</td>
							<td><a data-toggle="modal"
								data-target="#modaleSuppressionLivre" class="text-danger"
								onclick="transfertRef(${livre.reference})"> <i
									class="fa fa-trash"></i>
							</a> <a data-toggle="modal"
								onclick="transfertRefAndQuantitee(${livre.reference},${livre.quantitee })"
								data-target="#modalModification" class="text-warning"> <i
									class="fa fa-edit"> </i></a></td>
					</c:forEach>
				<tbody>
			</table>
		</div>

		<div class="modal fade" id="modaleSuppression" tabindex="-1"
			aria-labelledby="modaleSuppressionLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="modaleSuppressionLabel">Confirmation
							Suppression</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						Confirmer vous la suppression de la demande de compte ? mail : <span
							id="idToDeleteText"></span>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Annuler</button>
						<form action="deleteUser" method="post">
							<input type="hidden" name="mail" id="idToDelete">
							<button type="submit" class="btn btn-primary">Valider</button>
						</form>
					</div>
				</div>
			</div>
		</div>

		<div class="modal fade" id="modaleSuppressionLivre" tabindex="-1"
			aria-labelledby="modaleSuppressionLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="modaleSuppressionLabel">Confirmation
							Suppression</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						Confirmer vous la suppression du livre id :<span id="idLivre">
						</span> <span id="idToDeleteText"></span>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Annuler</button>
						<form action="deleteLivre" method="post">
							<input type="hidden" name="reference" id="transfert">
							<button type="submit" class="btn btn-primary">Valider</button>
						</form>
					</div>
				</div>
			</div>
		</div>

		<div class="modal fade" id="modalModification" tabindex="-1"
			aria-labelledby="modaleSuppressionLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="modaleSuppressionLabel">Modification
							quantitée livre</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<form action="updateLivre" method="post">
						<div class="modal-body">
							<label> Ancienne quantitée :<span id="ancienneQuantitee">
							</span>
							</label> <br> <label for="quantiteLivre">Nouvelle Quantitée</label>
							<input type="number" name="quantite" id="quantiteLivre" min="0">
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Annuler</button>

							<input type="hidden" name="reference" id="transfertB">
							<button type="submit" class="btn btn-primary">Valider</button>

						</div>
					</form>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-6">
				<div class="d-flex justify-content-center">
					<nav aria-label="Page navigation">
						<ul class="pagination">
							<c:if test="${ pageEnCours > 1 }">
								<c:url value="/dashboard" var="lienPrecedent">
									<c:param name="page" value="${ pageEnCours - 1 }" />
								</c:url>
								<li class="page-item"><a class="page-link"
									href="${lienPrecedent }">&lt;</a></li>
							</c:if>
							<li class="page-item"><a class="page-link" href="#">${ pageEnCours }</a>

							</li>
							<c:if test="${ pageEnCours < (count / nbElementsParPage)  }">
								<c:url value="/dashboard" var="lienSuivant">
									<c:param name="page" value="${ pageEnCours + 1 }" />
								</c:url>
								<li class="page-item"><a class="page-link"
									href="${lienSuivant }">&gt;</a></li>
							</c:if>
						</ul>
					</nav>
				</div>
			</div>
			<div class="col-6">

				<div class="d-flex justify-content-center">
					<nav aria-label="Page navigation">
						<ul class="pagination">
							<c:if test="${ pageEnCoursLivre > 1 }">
								<c:url value="/dashboard" var="lienPrecedent">
									<c:param name="pageLivre" value="${ pageEnCoursLivre - 1 }" />
								</c:url>
								<li class="page-item"><a class="page-link"
									href="${lienPrecedent }">&lt;</a></li>
							</c:if>
							<li class="page-item"><a class="page-link" href="#">${ pageEnCoursLivre }</a>

							</li>
							<c:if
								test="${ pageEnCoursLivre < (countLivre / nbElementsParPageLivre)  }">
								<c:url value="/dashboard" var="lienSuivant">
									<c:param name="pageLivre" value="${ pageEnCoursLivre + 1 }" />
								</c:url>
								<li class="page-item"><a class="page-link"
									href="${lienSuivant }">&gt;</a></li>
							</c:if>
						</ul>
					</nav>
				</div>
			</div>
		</div>
		<div class="row mb-1 mt-2">
			<div class="col-6 d-flex justify-content-center">
				<h2>Tableau commande</h2>

			</div>
			<div class="col-6 d-flex justify-content-center">
				<h2>Ajout Livre</h2>
			</div>
		</div>
		<div class="row">
			<table class="table table-striped table-class col-6">

				<thead>
					<tr>
						<th>N°</th>
						<th>Mail</th>
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
							<td>${commande.userMail}</td>
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
								
									<c:if test="${!commande.estValidee}">
								<a><em class="fa fa-check-circle text-success" ></em>
								</a>
									</c:if>
									

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

			<div class="col-6">
				<form method="post" action="addLivre" class="was-validated">
					<div class="modal-body">
						<div class="container-fluid">
							<div class="row">
								<div class="col md-form form-sm mb-2">
									<i class="fa fa-user prefix"></i> <input type="number"
										onchange="testReference()" id="reference"
										class="form-control form-control-sm validate"
										placeholder="reference" name="reference" required min="0">
									<span class="error text-danger" id="result"></span>
								</div>
								<div class="col-9 md-form form-sm mb-2 mt-4">

									<input type="text" id="titre"
										class="form-control form-control-sm validate"
										placeholder="titre" name="titre" required>


								</div>

							</div>
							<div class="row">
								<div class="col-4 md-form form-sm mb-2">
									<i class="fa fa-home"></i> <input type="number" id="quantitee"
										class="form-control form-control-sm validate"
										placeholder="quantitee" name="quantitee" min="0" required>


								</div>
								<div class="col-4 md-form form-sm mb-2">
									<i class="fa fa-home"></i> <input type="number" id="prix"
										class="form-control form-control-sm validate"
										placeholder="prix" name="prix" min="0" required>

								</div>
								<div class="col-4 md-form form-sm mb-2">
									<i class="fa fa-home"></i> <input type="number" id="nbPage"
										class="form-control form-control-sm validate"
										placeholder="nbPage" name="nbPage" min="0" required>

								</div>
							</div>
							<div class="row">


								<div class="col md-form form-sm mb-2 mt-4">
									<input type="text" id="description"
										class="form-control form-control-sm validate"
										placeholder="description" name="description" required>
								</div>
							</div>
							<div class="md-form form-sm mb-2" id="divEditeur">
								<i class="fa fa-lock prefix"></i> <input type="text"
									list="listEditeur" id="editeur"
									class="form-control form-control-sm validate"
									placeholder="editeur" name="editeur"
									onkeydown="addOptionEditeur()" onchange="addOptionEditeur()"
									minlength="3" required>
								<datalist id="listEditeur">



								</datalist>
							</div>
							<div class="md-form form-sm mb-2" id="divAuteur">
								<i class="fa fa-envelope prefix"></i> <input type="text"
									list="listAuteur" id="auteur"
									class="form-control form-control-sm validate" name="auteur"
									placeholder="auteur" minlength="3"
									onkeydown="addOptionAuteur()" onchange="addOptionAuteur()"
									required> <span class="error text-danger"
									id="resultAuteur"></span> <a class="d-none"
									id="butttonModalAuteur" data-toggle="modal"
									data-target="#modalLRForm"> Auteur/Editeur non présent
									cliquez ici pour l'ajouter</a>
							</div>
							<datalist id="listAuteur">

							</datalist>

							<div class="text-center form-sm mt-2 mb-4">
								<button class="btn btn-info" id="valider">
									Valider <i class="fa fa-sign-in ml-1"></i>
								</button>
							</div>

						</div>

					</div>
				</form>



			</div>
		</div>
	</div>

	<div class="modal fade" id="modalUtilisateur" tabindex="-1"
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

				<div class="modal-body">
					<div class="container-fluid">
						<div class="row">
							<div class="col md-form form-sm mb-2">
								<i class="fa fa-user prefix"></i> <input type="text"
									id="nomModifier" class="form-control form-control-sm validate"
									placeholder="Nom" name="nom" readonly>
							</div>
							<div class="col md-form form-sm mb-2 mt-4">
								<input type="text" id="prenomModifier"
									class="form-control form-control-sm validate"
									placeholder="Prenom" name="prenom" readonly>
							</div>
						</div>
						<div class="row">
							<div class=" col-8 md-form form-sm mb-2">
								<i class="fa fa-envelope prefix"></i> <input type="email"
									id="mailModifier"
									class="form-control form-control-sm validate" 
									name="mail" min="0" readonly>
							</div>
						</div>
						<div class="row">
							<div class="col-3 md-form form-sm mb-2">
								<i class="fa fa-home"></i> <input type="number"
									id="numeroModifier"
									class="form-control form-control-sm validate"
									name="numeroPorte" min="0" readonly>
							</div>
							<div class=" col-3 md-form form-sm mb-2">
								<i class="fa fa-lock prefix"></i> <input type="text"
									id="complementAdresseModifier"
									class="form-control form-control-sm validate"
									placeholder="Complément d'adresse" name="complementAdresse" readonly>
							</div>
							<div class="col-6 md-form form-sm mb-2 mt-4">
								<input type="text" id="rueModifier"
									class="form-control form-control-sm validate"
									placeholder="Nom de la rue" name="nomRue" readonly>
							</div>
						</div>
						<div class="row">
							<div class="col md-form form-sm mb-2">
								<i class="fa fa-location-arrow prefix"></i> <input type="text"
									id="villeModifier" name="ville"
									class="form-control form-control-sm validate"
									placeholder="Ville" readonly>
							</div>
							<div class="col md-form form-sm mb-2 mt-4">
								<input type="number" id="codePostalModifier"
									class="form-control form-control-sm validate"
									placeholder="Code Postal" name="codePostal" readonly>
							</div>
							<div class="col md-form form-sm mb-2 mt-4">
								<input type="text" id="paysModifier"
									class="form-control form-control-sm validate"
									placeholder="Pays" name="pays" readonly>
							</div>
						</div>


					</div>
					<!--Footer-->
					<div class="modal-footer">
						<button type="button"
							class="btn btn-outline-info waves-effect ml-auto"
							data-dismiss="modal">Close</button>
					</div>
				</div>

			</div>
		</div>
	</div>
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
								class="fa fa-user-plus"></i>Ajout Editeur</a></li>
						<li class="nav-item"><a class="nav-link" data-toggle="tab"
							href="#panel8" role="tab"><i class="fa fa-user-plus"></i>
								Ajout Auteur</a></li>
					</ul>

					<!-- Tab panels -->
					<div class="tab-content">
						<!--Panel 7-->

						<div class="tab-pane fade in show active" id="panel7"
							role="tabpanel">

							<!--Body-->
							<form method="post" action="addEditeur" class="was-validated"
								novalidate>
								<div class="modal-body mb-1">
									<div class="row">
										<div class="col md-form form-sm mb-2 mt-4">
											<input type="text" id="nomEditeur"
												class="form-control form-control-sm validate"
												placeholder="Nom" name="nomEditeur" required
												onchange="testEditeur()"> <span
												id="resultTestEditeur"></span>
										</div>
									</div>
									<div class="text-center mt-2">
										<button class="btn btn-info" id="ajoutEditeur">
											Ajouter<i class="fa fa-sign-in ml-1"></i>
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
							<form method="post" action="addAuteur" class="was-validated">
								<div class="modal-body">
									<div class="container-fluid">
										<div class="row">
											<div class="col md-form form-sm mb-2">
												<i class="fa fa-user prefix"></i> <input type="text"
													id="nomAuteur"
													class="form-control form-control-sm validate"
													placeholder="Nom" name="nomAuteur">

											</div>
											<div class="col md-form form-sm mb-2 mt-4">
												<input type="text" id="prenom"
													class="form-control form-control-sm validate"
													placeholder="Prenom" name="prenomAuteur">

											</div>
										</div>
										<div class="row">
											<div class="col md-form form-sm mb-2">
												<i class="fa fa-home"></i> <input type="text"
													id="nomUsageAuteur"
													class="form-control form-control-sm validate"
													placeholder="Nom d'usage" name="nomUsageAuteur"
													data-toggle="tooltip"
													title="Si inconus , veuillez renseigner son nom et prénom"
													onchange="testAuteur()" required> <span
													id="resultTestAuteur"></span>
											</div>
										</div>

										<div class="text-center form-sm mt-2 mb-4">
											<button class="btn btn-info" id="ajoutAuteur">
												Ajouter<i class="fa fa-sign-in ml-1"></i>
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
	<footer class="footer text-faded text-center py-5"
		style="background-color: rgb(238, 244, 247); position: relative;">
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