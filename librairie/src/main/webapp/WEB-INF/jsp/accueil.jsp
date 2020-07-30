<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			<h2 class="text-danger">${error}</h2>
			<form action="accueil" method="post">

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
									<input id="login" type="text" name="login" class="form-control"
										placeholder="Login" required>
								</div>
								<div class="form-group">
									<input id="password" type="password" name="password"
										class="form-control" placeholder="Password" required>
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