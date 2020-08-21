<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<link rel="stylesheet" href="assets/css/myCss.css">
</head>

<body style="background: white;">


	<body style="background-color: white; background: white;">
	<%@include file="navbar.jsp"%>
	
<div class="container-fluid">
		<div class="row">
			Mes informations
			<table class="table table-striped table-class col-6" id="table-id">
				<thead>
					<tr>
						<th>Nom</th>
						<th>Prenom</th>
						<th>Adresse mail</th>
						<th>Date de Naissance</th>
						<th>Numéro de porte</th>
						<th>Complément d'adresse</th>
						<th>Rue</th>
						<th>Code postal</th>
						<th>Ville</th>
					</tr>
				</thead>

				<tbody>
					<tr>
						<td>${user.nom}</td>
						<td>${user.prenom}</td>
						<td>${user.mail}</td>
						<td>${user.dateNaissance}</td>
						<td>${user.numeroPorte}</td>
						<td>${user.complementAdresse}</td>
						<td>${user.nomRue}</td>
						<td>${user.codePostal}</td>
						<td>${user.ville}</td>
						<td><a href="#"> <i class="fa fa-trash"
								onclick="afficherModaleModifier(${user.mail})"></i>
						</a></td>
				<tbody>
			</table>
			</div>
<div class="row">
			Mes commandes 
			<!-- Tableau livre  -->
			<table class="table table-striped table-class col-6" id="table-id">
				
				<thead>
					<tr>
						<th>Numéro de commande</th>
						<th>Nombre d'articles</th>
						<th>Date de commande</th>				
						<th>Montant</th>
						<th>Etat de la commande</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach var="livre" items="${listeLivre}">
						<tr>
							<td>${commande.numeroCommande}</td>
							<td>${livre.nombreArticles}</td>
							<td>${livre.dateCommande}</td>
							<td>${livre.etatCommande}</td>
							<td>${livre.prixTotal}</td>					
							<td>
								<button class="btn btn-danger">
									<i class="fa fa-trash"></i>
								</button>
								<button class="btn btn-warning">
									<i class="fa fa-edit"> </i>
								</button>
							</td>
					</c:forEach>
				<tbody>
			</table>
		</div>
	</div>
	<div class="modal fade" id="modalLRForm" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog cascading-modal" role="document">
        <!--Content-->
        <div class="modal-content">

                    <!--Panel 8-->
                    <div class="tab-pane fade" id="panel8" role="tabpanel">

                        <!--Body-->
                        <form method="post" action="updateUser" class="was-validated">
                            <div class="modal-body">
                                <div class="container-fluid">
                                    <div class="row">
                                        <div class="col md-form form-sm mb-2">
                                            <i class="fa fa-user prefix"></i> <input type="text"
                                                                                     id="nom"
                                                                                     class="form-control form-control-sm validate"
                                                                                     placeholder="Nom" name="nom"
                                                                                     required>

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
                                                                              placeholder="N°" name="numeroPorte"
                                                                              min="0" required>

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
                                                                                 placeholder="Complément d'adresse"
                                                                                 name="complementAdresse"   >
                                                                             
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
                                                                                     id="email"
                                                                                     class="form-control form-control-sm validate"
                                                                                     onchange="testEmail()" name="mail"
                                                                                     placeholder="Email"
                                                                                     required> <span
                                            class="error text-danger"
                                            id="result"></span>
                                    </div>

                                    <div class="md-form form-sm mb-2">
                                        <i class="fa fa-lock prefix"></i> <input type="password"
                                                                                 id="password"
                                                                                 class="form-control form-control-sm validate"
                                                                                 placeholder="Password" name="password"
                                                                                 required>
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
                                            data-dismiss="modal">Close
                                    </button>
                                </div>
                            </div>
                        </form>
                    </div>
                    <!--/.Panel 8-->
                </div>

            </div>
        </div>
        <!--/.Content-->
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
</body></html>