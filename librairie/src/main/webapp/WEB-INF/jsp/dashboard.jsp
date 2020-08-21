<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
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
<link rel="stylesheet" href="assets/css/myCss.css">
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
		<div class="row">
			<table class="table table-striped table-class col-6" id="table-id">
				<thead>
					<tr>
						<th>Nom</th>
						<th>Prenom</th>
						<th>Adresse mail</th>
						<th>Role</th>
						<th>Activ�</th>
					</tr>
				</thead>

				<tbody>
					<%--            <c:forEach var="u" items="${utilisateur}">  --%>
					<tr>
						<td>${u.nom}</td>
						<td>${u.prenom}</td>
						<td>${u.mail}</td>
						<td>${u.labelRole}</td>
						<td>${u.estActive}</td>
						<td><a href="#"> <i class="fa fa-trash"
								onclick="afficherModaleSuppression(${u.mail})"></i>
						</a></td>
						<%--                </c:forEach>  --%>
				<tbody>
			</table>

			<!-- Tableau livre  -->
			<table class="table table-striped table-class col-6" id="table-id">


				<thead>
					<tr>
						<th>R�f�rences</th>
						<th>Titre</th>
						<th>Quantit�e</th>
						<th>Outils</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach var="livre" items="${listeLivre}">
						<tr>
							<td>${livre.reference}</td>
							<td>${livre.titre}</td>
							<td>${livre.quantitee}</td>
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

		<div class="modal fade" id="modaleSuppression" tabindex="-1"
			aria-labelledby="modaleSuppressionLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="modaleSuppressionLabel">Modal
							title</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						Etes vous sur de vouloir supprimer cet utilisateur? <span
							id="idToDeleteText"></span>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">non</button>
						<form action="dashboard" method="post">
							<input type="hidden" name="idToDelete" id="idToDelete">
							<button type="submit" class="btn btn-primary">oui</button>
						</form>
					</div>
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
		<div class="row">
			<table class="table table-striped table-class col-6" id="table-id">


				<thead>
					<tr>
						<th>R�f�rences</th>
						<th>Titre</th>
						<th>Quantit�e</th>
						<th>Outils</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach var="livre" items="${listeLivre}">
						<tr>
							<td>${livre.reference}</td>
							<td>${livre.titre}</td>
							<td>${livre.quantitee}</td>
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

			<div class="col-6">
				<form method="post" action="addUser.do" class="was-validated">
					<div class="modal-body">
						<div class="container-fluid">
							<div class="row">
								<div class="col md-form form-sm mb-2">
									<i class="fa fa-user prefix"></i> <input type="text"
										id="reference" class="form-control form-control-sm validate"
										placeholder="reference" name="reference" required>

								</div>
								<div class="col-9 md-form form-sm mb-2 mt-4">

									<input type="text" id="adresse"
										class="form-control form-control-sm validate"
										placeholder="titre" name="nomRue" required>

								</div>

							</div>
							<div class="row">
								<div class="col-3 md-form form-sm mb-2">
									<i class="fa fa-home"></i> <input type="number" id="numero"
										class="form-control form-control-sm validate"
										placeholder="quantitee" name="quantitee" min="0" required>

								</div>

								<div class="col md-form form-sm mb-2">
									<i class="fa fa-location-arrow prefix"></i> <input type="text"
										id="ville" name="ville"
										class="form-control form-control-sm validate"
										placeholder="nbPage" required>

								</div>
								<div class="col md-form form-sm mb-2 mt-4">
									<input type="text" id="prix"
										class="form-control form-control-sm validate"
										placeholder="prix" name="prix" required>

								</div>
							</div>
							<div class="row">


								<div class="col md-form form-sm mb-2 mt-4">
									<input type="text" id="pays"
										class="form-control form-control-sm validate"
										placeholder="description" name="pays" required>
								</div>
							</div>
							<div class="md-form form-sm mb-2">
								<i class="fa fa-lock prefix"></i> <input type="text"
									id="complement" class="form-control form-control-sm validate"
									placeholder="editeur" name="complementAdresse" required>
							</div>
							<div class="md-form form-sm mb-2">
								<i class="fa fa-envelope prefix"></i> <input type="auteur"
									id="email" class="form-control form-control-sm validate"
									onchange="testEmail()" name="auteur" placeholder="auteur"
									required> <span class="error text-danger" id="result"></span>
							</div>

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
	<footer class="footer text-faded text-center py-5"
		style="background-color: rgb(238, 244, 247); position: relative;">
		<div class="container">
			<p class="m-0 small" style="color: rgb(102, 109, 112);">Copyright&nbsp;�&nbsp;Brand
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