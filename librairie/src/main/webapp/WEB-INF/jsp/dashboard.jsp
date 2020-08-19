<%@page import="lombok.EqualsAndHashCode.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html style="background: white;">

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title>Untitled</title>
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="assets/bootstrap/css/bootstrap.bundle.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i">
<link rel="stylesheet" href="assets/fonts/font-awesome.min.css">
<link rel="stylesheet" href="assets/css/styles.min.css">
<link rel="stylesheet" href="assets/css/myCss.css">
</head>

<body style="background: white;">
<%@include file="navbar.jsp" %>
	<div class="container">
		<div class="header_wrap">
			<div class="num_rows">

				<div class="form-group">
					<!--		Show Numbers Of Rows 		-->
					<select class="form-control" name="state" id="maxRows">

						<option value="5">5</option>
						<option value="10">10</option>
						<option value="15">15</option>

					</select>

				</div>
			</div>
		</div>

		<table class="table table-striped table-class" id="table-id">


			<thead>
				<tr>
					<th>Nom</th>
					<th>Prenom</th>
					<th>Adresse mail</th>
					<th>Role</th>
					<th>Activé</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="u" items="${utilisateur}">
					<tr>
						<td>${u.nom}</td>
						<td>${u.prenom}</td>
						<td>${u.mail}</td>
						<td>${u.labelRole}</td>
						<td>${u.estActive}</td>
					</tr>
				</c:forEach>
			<tbody>
		</table>

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


<%@include file="footer.jsp" %>
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/js/script.min.js"></script>
	<script src="assets/js/myScript.js"></script>

</body>

</html>