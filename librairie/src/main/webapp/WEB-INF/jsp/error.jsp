<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Whoops !</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
	<div class="jumbotron">
		<div class="container">
			<h1>Hmm... c'est embarrasant !</h1>
			<h2 class="text-warning">${error}</h2>
			<br>
			<a href="accueil" class="btn btn-primary" role="button">Retour accueil</a>
		</div>
	</div>
</body>
</html>