<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="fr.cda.librairie.dto.UserDto"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu principal</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
	<%@ include file="navbar.jsp"%>
	<div class="jumbotron">

		<div class="container">


			<h1>Vos informations</h1>
			<h3 class="text-danger">${error}</h3>
			<table class="table">
				<thead>
					<tr>
						
						<th>Nom</th>
						<th>Prenom</th>
						<th>Login</th>

					</tr>
				</thead>
				<tbody>


				
						<tr>
							<td><c:out value="${ user.nom }" /></td>
							<td><c:out value="${ user.prenom }" /></td>
							<td><c:out value="${ user.login }" /></td>
	
						</tr>
				</tbody>
			</table>


		
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</body>
</html>