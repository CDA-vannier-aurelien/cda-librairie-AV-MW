<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="jstlLib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
	<div class="jumbotron">
		<div class="container">
			<h1>Connexion</h1>
			<h2 class="text-danger"><c:out value="${error}"></c:out></h2>
			<form action="connection" method="post">

             
				<div class="form-group">
					<input id="login" type="text" name="login" class="form-control"
						placeholder="Login" required>
				</div>
				<div class="form-group">
					<input id="password" type="password" name="password"
						class="form-control" placeholder="Password" required>
				</div>


				<button class="btn btn-primary" type="submit">Go</button>

				<!-- Button trigger modal -->
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#exampleModal">Inscription</button>

			</form>





			<!-- Modal -->
			<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
				aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel">Ajout Utilisateur</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<form id="modalForm" action="addUser.do" method="post">
							<div class="modal-body">

								<div class="form-group">
									<input id="prenom" type="text" name="prenom"
										class="form-control" placeholder="Prénom" required>
								</div>
								<div class="form-group">
									<input id="nom" type="text" name="nom" class="form-control"
										placeholder="Nom" required>
								</div>
								<div class="form-group">
<<<<<<< HEAD
									<input id="datenais" type="datetime-local" name="datenais" class="form-control"
										   placeholder="Date de Naissance" required>
								</div>
								<div class="form-group">
									<input id="numPorte" type="number" name="numPorte" class="form-control"
										   placeholder="Numero" required>
								</div>
								<div class="form-group">
									<input id="rue" type="text" name="rue" class="form-control"
										   placeholder="Rue" required>
								</div>
								<div class="form-group">
									<input id="ville" type="text" name="ville" class="form-control"
										   placeholder="Ville" required>
								</div>
								<div class="form-group">
									<input id="codepostal" type="number" name="codepostal" class="form-control"
										   placeholder="Code Postal" required>
								</div>
								<div class="form-group">
									<input id="login" type="text" name="login" class="form-control"
										placeholder="Login" required>
=======
									<input id="mail" type="text" name="mail" class="form-control"
										placeholder="Mail" required>
>>>>>>> Dev
								</div>
								<div class="form-group">
									<input id="password" type="password" name="password"
										class="form-control" placeholder="Password" required>
								</div>
								<div class="form-group">
									<input id="nomRue" type="text" name="nomRue"
										class="form-control" placeholder="Rue" required>
								</div>
								<div class="form-group">
									<input id="numeroRue" type="number" name="numeroPorte"
										class="form-control" placeholder="Numéro de rue" required>
								</div>
								<div class="form-group">
									<input id="complementAdresse" type="text" name="complementAdresse"
										class="form-control" placeholder="Complément d'adresse" required>
								</div>
								<div class="form-group">
									<input id="pays" type="text" name="pays"
										class="form-control" placeholder="Pays" required>
								</div>
								<div class="form-group">
									<input id="codePostal" type="text" name="codePostal"
										class="form-control" placeholder="Code Postal" required>
								</div>
								<div class="form-group">
									<input id="ville" type="text" name="ville"
										class="form-control" placeholder="Ville" required>
								</div>
								<div class="form-group">
									<input id="dateNaissance" type="date" name="dateNaissance"
										class="form-control" placeholder="Date de Naissance" required>
								</div>

							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal">Fermer</button>
								<button type="submit" class="btn btn-primary">Enregistrer</button>
							</div>
						</form>
					</div>
				</div>
			</div>

		</div>
	</div>


	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

</body>
</html>